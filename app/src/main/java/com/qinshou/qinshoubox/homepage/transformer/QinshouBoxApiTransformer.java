package com.qinshou.qinshoubox.homepage.transformer;

import com.qinshou.okhttphelper.call.ResponseTransformer;
import com.qinshou.qinshoubox.homepage.bean.QinshouBoxResultBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/16 16:59
 * Description:QinshouBox Api 的请求结果的转换器
 */
public class QinshouBoxApiTransformer<T> implements ResponseTransformer<QinshouBoxResultBean<T>, T> {
    @Override
    public T transform(QinshouBoxResultBean<T> tQinshouBoxResultBean) throws Exception {
        if (tQinshouBoxResultBean.getSuccess() != 1) {
            throw new Exception(tQinshouBoxResultBean.getFailureInfo());
        }
        return tQinshouBoxResultBean.getData();
    }
}
