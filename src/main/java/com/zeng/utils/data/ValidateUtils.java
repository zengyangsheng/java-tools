package com.zeng.utils.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yangsheng.zeng
 * @date 2018/3/1 16:50
 */
public class ValidateUtils {
    /** 整数  */
    private static final String  V_INTEGER="^-?[1-9]\\d*$";

    /**  正整数 */
    private static final String V_POSITIVE_INTEGER="^[1-9]\\d*$";

    /**负整数 */
    private static final String V_NEGATIVE_INTEGER="^-[1-9]\\d*$";

    /** 数字 */
    private static final String V_NUMBER="^([+-]?)\\d*\\.?\\d+$";

    /**正数 */
    private static final String V_POSITIVE_NUMBER="^[1-9]\\d*|0$";

    /** 负数 */
    private static final String V_NEGATINE_NUMBER="^-[1-9]\\d*|0$";

    /** 浮点数 */
    private static final String V_FLOAT="^([+-]?)\\d*\\.\\d+$";

    /** 正浮点数 */
    private static final String V_POSTTIVE_FLOAT="^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$";

    /** 负浮点数 */
    private static final String V_NEGATIVE_FLOAT="^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$";

    /** 邮件 */
    private static final String V_EMAIL="^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

    /** url */
    private static final String V_URL="^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$";

    /** 仅中文 */
    private static final String V_CHINESE="^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";

    /** 邮编 */
    private static final String V_ZIPCODE="^\\d{6}$";

    /** 手机 */
    private static final String V_MOBILE="^(1)[0-9]{10}$";

    /** ip地址 */
    private static final String V_IP4="^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$";

    /** 电话号码的函数(包括验证国内区号,国际区号,分机号) */
    private static final String V_TEL="^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?$";

    /** 用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串 */
    private static final String V_USERNAME="^\\w+$";

    /** 字母 */
    private static final String V_LETTER="^[A-Za-z]+$";

    /** 身份证  */
    private static final String V_IDCARD ="^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";


    private ValidateUtils(){}


    /**
     * 验证是不是整数
     * @param value 要验证的字符串
     * @return  如果是符合格式的字符串,返回true,否则为false
     */
    public static boolean isInteger(String value){
        return match(V_INTEGER,value);
    }

    /**
     * 验证是不是正整数
     * @param value 要验证的字符串
     * @return  如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isPositiveInteger(String value){
        return match(V_POSITIVE_INTEGER,value);
    }

    /**
     * 验证是不是负整数
     * @param value 要验证的字符串
     * @return  如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isNegativeInteger(String value){
        return match(V_NEGATIVE_INTEGER,value);
    }

    /**
     * 验证是不是数字
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isNumber(String value){
        return match(V_NUMBER,value);
    }

    /**
     * 验证是不是正数
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isPositiveNumber(String value){
        return match(V_POSITIVE_NUMBER,value);
    }

    /**
     * 验证是不是负数
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isNegatineNumber(String value){
        return match(V_NEGATINE_NUMBER,value);
    }

    /**
     * 验证是不是浮点数
     * @param value 要验证的字符串
     * @return  如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isFloat(String value){
        return match(V_FLOAT,value);
    }

    /**
     * 验证是不是正浮点数
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isPosttiveFloat(String value){
        return match(V_POSTTIVE_FLOAT,value);
    }

    /**
     * 验证是不是负浮点数
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isNegativeFloat(String value){
        return match(V_NEGATIVE_FLOAT,value);
    }

    /**
     * 验证是不是中文
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isChinese(String value){
        return match(V_CHINESE,value);
    }

    /**
     * 验证是不是邮箱地址
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isEmail(String value){
        return match(V_EMAIL,value);
    }

    /**
     * 验证是不是正确的身份证号码
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isIDcard(String value){
        return match(V_IDCARD,value);
    }

    /**
     * 验证是不是正确的IP地址
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isIP4(String value){
        return match(V_IP4,value);
    }

    /**
     * 验证是不是字母
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isLetter(String value){
        return match(V_LETTER,value);
    }


    /**
     * 验证是不是手机号码
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isMobile(String value){
        return match(V_MOBILE,value);
    }

    /**
     * 验证电话 包括验证国内区号,国际区号,分机号
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isTel(String value){
        return match(V_TEL,value);
    }

    public static void main(String[] args) {
        boolean result = ValidateUtils.isZipCode("422333");
        System.out.println(result);
    }

    /**
     * 验证URL
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isUrl(String value){
        return match(V_URL,value);
    }

    /**
     * 验证邮编
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isZipCode(String value){
        return match(V_ZIPCODE,value);
    }

    /**
     * 验证用户注册,匹配由数字、26个英文字母或者下划线组成的字符串
     * @param value 要验证的字符串
     * @return 如果是符合格式的字符串,返回 true,否则为false
     */
    public static boolean isUserName(String value){
        return match(V_USERNAME,value);
    }

    /**
     * 正则表达式匹配
     * @param regex 正则表达式字符串
     * @param str 要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false
     */
    public static boolean match(String regex, String str){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
