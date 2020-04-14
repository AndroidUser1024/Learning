package com.jeejio.networkmodule.call;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2019/6/26 10:26
 * Description:响应转换接口,类似 RxJava 的 Function 接口
 */
public interface ResponseTransformer<I, O> {
    O transform(I i) throws Exception;
}
