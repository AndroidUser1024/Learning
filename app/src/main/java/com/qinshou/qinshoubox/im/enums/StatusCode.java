package com.qinshou.qinshoubox.im.enums;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2020/1/7 21:12
 * Description:WebSocket 自定义状态码
 */
public enum StatusCode {
    NORMAL_CLOSE(1000,"正常关闭"),
    SERVER_FORCE_CLOSE(4000,"服务器强制关闭");

    private int code;
    private String reason;

    StatusCode(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
}
