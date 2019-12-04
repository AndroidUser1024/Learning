package com.qinshou.immodule.util.EncryptUtil;

import java.nio.charset.Charset;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/27 16:07
 * Description:类描述
 */
public class CodeUtil {
    private static final String key = "QinshouBox";
    private static final Charset charset = Charset.forName("UTF-8");
    private static byte[] keyBytes = key.getBytes(charset);

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/11/27 16:30
     * Description:加密
     *
     * @param string 需要加密的字符串
     */
    public static String encode(String string) {
        byte[] byteArray = string.getBytes(charset);
        for (int i = 0, size = byteArray.length; i < size; i++) {
            for (byte b : keyBytes) {
                byteArray[i] = (byte) (byteArray[i] ^ b);
            }
        }
        return new String(byteArray);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/11/27 16:30
     * Description:解密
     *
     * @param string 需要解密的字符串
     */
    public static String decode(String string) {
        byte[] byteArray = string.getBytes(charset);
        for (int i = 0, size = byteArray.length; i < size; i++) {
            for (byte b : keyBytes) {
                byteArray[i] = (byte) (byteArray[i] ^ b);
            }
        }
        return new String(byteArray);
    }
}
