package com.qinshou.qinshoubox.util;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/23 13:52
 * Description:加密解密工具类
 */
public class EncryptUtil {
    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/12/23 13:54
     * Description:将一个字符串进行凯撒密码式的加密
     *
     * @param string 待加密的字符串
     * @return 加密后的字符串
     */
    public static String encrypt(String string) {
        char[] charArray = string.toCharArray();
        char[] encrypt = new char[charArray.length];
        for (int i = 0; i < string.toCharArray().length; i++) {
            encrypt[i] = (char) (charArray[i] + 6);
        }
        return new String(encrypt);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/12/23 13:54
     * Description:将一个凯撒密码加密的字符串解密
     *
     * @param string 待解密的字符串
     * @return 解密后的字符串
     */
    public static String decrypt(String string) {
        char[] charArray = string.toCharArray();
        char[] decrypt = new char[charArray.length];
        for (int i = 0; i < string.toCharArray().length; i++) {
            decrypt[i] = (char) (charArray[i] - 6);
        }
        return new String(decrypt);
    }
}
