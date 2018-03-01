package com.zeng.utils.crypto;


import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 安全相关方法
 *
 * @author yangsheng.zeng
 * @date 2018/3/1 15:51
 */
public class SecurityUtils {

    private static Logger logger = Logger.getLogger(SecurityUtils.class);

    /**
     * 对MAP数据进行签名，根据key进行字典排序，再加上密钥，进行MD5加密
     *
     * @param map       需要签名的MAP数据
     * @param secretKey 密钥
     * @return 签名后的数据
     */
    public static String getMd5Sign(Map<String, Object> map, String secretKey) {
        // 第一步：把字典按Key的字母顺序排序
        Set<String> sets = new TreeSet<String>();
        Set<String> mapSets = map.keySet();
        for (String item : mapSets) {
            sets.add(item);
        }
        sets.remove("sign");// 移除加密字符串

        // 第二步：把所有参数名和参数值串在一起
        StringBuilder parames = new StringBuilder();
        for (String item : sets) {
            Object value = map.get(item);
            if (value != null) {
                parames.append(item).append(value);
            }
        }
        parames.append(secretKey);

        // 第三步：使用MD5加密
        logger.debug("MD5 params : " + parames.toString());
        String md5 = null;
        try {
            md5 = MD5Utils.encodeMD5(parames.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 第四步：把二进制转化为大写
        return md5.toUpperCase();
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("aaa", "111");
        map.put("ccc", "333");
        map.put("bbb", "222");
        String target = SecurityUtils.getMd5Sign(map, "123456");
        System.out.println(target);
    }


}
