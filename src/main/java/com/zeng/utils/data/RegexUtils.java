package com.zeng.utils.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yangsheng.zeng
 * @date 2018/3/1 16:49
 */
public class RegexUtils {
    /**
     * @param regex 正则表达式
     * @param orginal 待匹配字符串
     * @return
     */
    public static boolean isMatch(String regex, String orginal){
        if (orginal == null || orginal.trim().equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(orginal);
        return m.matches();
    }
}
