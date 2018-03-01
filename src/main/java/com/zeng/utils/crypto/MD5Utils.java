package com.zeng.utils.crypto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * MD5加密相关方法
 *
 * @author yangsheng.zeng
 * @date 2018/3/1 15:51
 */
public class MD5Utils {
    private final static Logger LOGGER = LoggerFactory.getLogger(MD5Utils.class);

    /**
     * 对字符串进行MD5加密
     *
     * @param source 需要加密的字符串
     * @return 加密后的字符串
     * @throws Exception
     */
    public static String encodeMD5(String source) throws Exception {
        LOGGER.info("MD5Utils encodeMD5 source:" + source);
        //使用JRE自带的加密方式
        MessageDigest msgDigest = MessageDigest.getInstance("MD5");
        //指定UTF-8，不然会随着运行环境改变格式，导致与外交互，无法匹配
        msgDigest.update(source.getBytes("utf-8"));
        byte[] bytes = msgDigest.digest();
        String target = new String();
        for (int i = 0; i < bytes.length; ++i) {
            byte tb = bytes[i];
            char tmpChar = (char) (tb >>> 4 & 15);
            char high;
            if (tmpChar >= 10) {
                high = (char) (97 + tmpChar - 10);
            } else {
                high = (char) (48 + tmpChar);
            }
            target = target + high;
            tmpChar = (char) (tb & 15);
            char low;
            if (tmpChar >= 10) {
                low = (char) (97 + tmpChar - 10);
            } else {
                low = (char) (48 + tmpChar);
            }
            target = target + low;
        }
        LOGGER.info("MD5Utils encodeMD5 target:" + target);
        return target;
    }

    public static void main(String[] args) throws Exception {
        String target = MD5Utils.encodeMD5("123456");
        System.out.println(target);
    }
}
