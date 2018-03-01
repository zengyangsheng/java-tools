package com.zeng.utils.crypto;


import com.zeng.utils.data.StringUtils;

import java.security.MessageDigest;

/**
 * SHA加密相关方法
 *
 * @author yangsheng.zeng
 * @date 2018/3/1 15:51
 */
public class SHAUtils {
    /**
     * 定义加密方式
     */
    private final static String KEY_SHA1 = "SHA-1";
    /**
     * 全局数组
     */
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 对byte数组进行SHA1加密
     *
     * @param source 需要加密的字节数组
     * @return 加密后的字符串
     * @throws Exception
     */
    public static byte[] encodeSHA1(byte[] source) throws Exception {
        // 创建具有指定算法名称的信息摘要
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA1);
        // 使用指定的字节数组对摘要进行最后更新
        sha.update(source);
        // 完成摘要计算并返回
        return sha.digest();
    }

    /**
     * 对字符串进行SHA1加密
     *
     * @param source 需要加密的字节数组
     * @return 加密后的字符串
     * @throws Exception
     */
    public static String encodeSHA1(String source) throws Exception {
        // 验证传入的字符串
        if (StringUtils.isBlank(source)) {
            return "";
        }
        // 创建具有指定算法名称的信息摘要
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA1);
        // 使用指定的字节数组对摘要进行最后更新
        sha.update(source.getBytes());
        // 完成摘要计算
        byte[] bytes = sha.digest();
        // 将得到的字节数组变成字符串返回
        return byteArrayToHexString(bytes);
    }

    /**
     * 将一个字节转化成十六进制形式的字符串
     *
     * @param b 字节
     * @return 字符串
     */
    private static String byteToHexString(byte b) {
        int ret = b;
        if (ret < 0) {
            ret += 256;
        }
        int m = ret / 16;
        int n = ret % 16;
        return hexDigits[m] + hexDigits[n];
    }

    /**
     * 转换字节数组为十六进制字符串
     *
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(byteToHexString(bytes[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String target = SHAUtils.encodeSHA1("123456");
        System.out.println(target);
    }

}
