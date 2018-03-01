package com.zeng.utils.crypto;

import org.apache.commons.net.util.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Base64加密相关方法
 *
 * @author yangsheng.zeng
 * @date 2018/3/1 15:51
 */
public class Base64Utils {

    /**
     * 对字符串进行Base64加密
     *
     * @param source 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String encodeBase64(String source) {
        byte[] b = null;
        String s = null;
        try {
            b = source.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    /**
     * 对字符串进行Base64解密
     *
     * @param source 需要解密的字符串
     * @return 解密后的字符串
     */
    public static String decodeBase64(String source) {
        byte[] b = null;
        String result = null;
        if (source != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(source);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 对byte数组进行Base64加密
     *
     * @param source 需要加密的字节数组
     * @return 加密后的字符串
     * @throws Exception
     */
    public static String encode(byte[] source) {
        return Base64.encodeBase64String(source);
    }

    /**
     * 对InputStream流进行Base64加密
     *
     * @param source 需要加密的流
     * @return 加密后的字符串
     * @throws Exception
     */
    public static String encryptBase64(InputStream source) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            data = new byte[source.available()];
            source.read(data);
            source.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        return encode(data);
    }

    public static void main(String[] args) throws Exception {
        String target = Base64Utils.encodeBase64("漆峻铭");
        System.out.println(target);
    }

}
