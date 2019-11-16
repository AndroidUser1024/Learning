package com.qinshou.qinshoubox.transformer;

import com.qinshou.okhttphelper.call.ResponseTransformer;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/16 16:59
 * Description:QinshouBox Api 的请求结果的转换器
 */
public class QSApiTransformer<T> implements ResponseTransformer<QinshouResultBean<T>, T> {
    @Override
    public T transform(QinshouResultBean<T> tQinshouResultBean) throws Exception {
        if (tQinshouResultBean.getSuccess() != 1) {
            throw new Exception(tQinshouResultBean.getFailureInfo());
        }
        return tQinshouResultBean.getData();
    }
}
