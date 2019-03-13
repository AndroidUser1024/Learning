package com.qinshou.networkmodule.interceptor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;

import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Description:打印网络请求和响应结果的拦截器
 * Created by 禽兽先生
 * Created on 2018/6/5
 */

public class LogInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private Level mLevel;
    private Logger mLogger;

    public enum Level {
        /**
         * 没有任何打印
         */
        NONE,
        /**
         * 打印请求行和响应行
         */
        BASIC,
        /**
         * 打印请求行和响应行，请求头和响应头
         */
        HEADERS,
        /**
         * 打印请求行和响应行，请求头和响应头，请求体和响应体
         */
        BODY,
    }

    public LogInterceptor() {
        this(Level.BASIC);
    }

    public LogInterceptor(Level level) {
        this(level, new Logger() {
            @Override
            public void log(String message) {

            }
        });
    }

    public LogInterceptor(Logger logger) {
        this(Level.BASIC, logger);
    }

    public LogInterceptor(Level level, Logger logger) {
        mLevel = level;
        mLogger = logger;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Level level = this.mLevel;

        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }

        boolean logBody = level == Level.BODY;
        boolean logHeaders = logBody || level == Level.HEADERS;

        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;

        Connection connection = chain.connection();
        Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
        String requestStartMessage = "--> " + request.method() + ' ' + request.url() + ' ' + protocol;
        if (!logHeaders && hasRequestBody) {
            requestStartMessage += " (" + requestBody.contentLength() + "-byte body)";
        }
        mLogger.log(requestStartMessage);

        if (logHeaders) {
            if (hasRequestBody) {
                // Request body headers are only present when installed as a network interceptor. Force
                // them to be included (when available) so there values are known.
                if (requestBody.contentType() != null) {
                    mLogger.log("Content-Type: " + requestBody.contentType());
                }
                if (requestBody.contentLength() != -1) {
                    mLogger.log("Content-Length: " + requestBody.contentLength());
                }
            }

            Headers headers = request.headers();
            for (int i = 0, count = headers.size(); i < count; i++) {
                String name = headers.name(i);
                // Skip headers from the request body as they are explicitly logged above.
                if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                    mLogger.log(name + ": " + headers.value(i));
                }
            }

            if (!logBody || !hasRequestBody) {
                mLogger.log("--> END " + request.method());
            } else if (bodyEncoded(request.headers())) {
                mLogger.log("--> END " + request.method() + " (encoded body omitted)");
            } else {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);

                Charset charset = UTF8;
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    charset = contentType.charset(UTF8);
                }

                mLogger.log("");
                mLogger.log(buffer.readString(charset));

                mLogger.log("--> END " + request.method()
                        + " (" + requestBody.contentLength() + "-byte body)");
            }
        }

        long startNs = System.nanoTime();
        Response response = chain.proceed(request);
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);

        ResponseBody responseBody = response.body();
        long contentLength = responseBody.contentLength();
        String bodySize = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
        mLogger.log("<-- " + response.code() + ' ' + response.message() + ' '
                + response.request().url() + " (" + tookMs + "ms" + (!logHeaders ? ", "
                + bodySize + " body" : "") + ')');

        if (logHeaders) {
            Headers headers = response.headers();
            for (int i = 0, count = headers.size(); i < count; i++) {
                mLogger.log(headers.name(i) + ": " + headers.value(i));
            }
            if (!logBody || !hasBody(request, response)) {
                mLogger.log("<-- END HTTP");
            } else if (bodyEncoded(response.headers())) {
                mLogger.log("<-- END HTTP (encoded body omitted)");
            } else {
                BufferedSource source = responseBody.source();
                source.request(Long.MAX_VALUE); // Buffer the entire body.
                Buffer buffer = source.buffer();

                Charset charset = UTF8;
                MediaType contentType = responseBody.contentType();
                if (contentType != null) {
                    try {
                        charset = contentType.charset(UTF8);
                    } catch (UnsupportedCharsetException e) {
                        mLogger.log("");
                        mLogger.log("Couldn't decode the response body; charset is likely malformed.");
                        mLogger.log("<-- END HTTP");

                        return response;
                    }
                }

                if (contentLength != 0) {
                    mLogger.log("");
                    mLogger.log(buffer.clone().readString(charset));
                }

                mLogger.log("<-- END HTTP (" + buffer.size() + "-byte body)");
            }
        }

        return response;
    }

    private boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity");
    }

    private boolean hasBody(Request request, Response response) {
        // HEAD requests never yield a body regardless of the response headers.
        if (response.request().method().equals("HEAD")) {
            return false;
        }

        int responseCode = response.code();
        if ((responseCode < okhttp3.internal.http.StatusLine.HTTP_CONTINUE || responseCode >= 200)
                && responseCode != java.net.HttpURLConnection.HTTP_NO_CONTENT
                && responseCode != java.net.HttpURLConnection.HTTP_NOT_MODIFIED) {
            return true;
        }

        if (stringToLong(request.headers().get("Content-Length")) != -1
                || "chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return true;
        }

        return false;
    }

    private long stringToLong(String s) {
        if (s == null) return -1;
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public interface Logger {
        void log(String message);
    }
}
