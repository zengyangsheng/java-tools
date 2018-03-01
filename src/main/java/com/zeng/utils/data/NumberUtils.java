package com.zeng.utils.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangsheng.zeng
 * @date 2018/3/1 16:46
 */
public class NumberUtils {
    /**
     * 是否是整数(包含负数)
     *
     * @param o 目标对象 目标对象
     * @return true or false
     */
    public static boolean isInteger(Object o) {
        boolean r = false;
        if (o != null) {
            r = RegexUtils.isMatch("^[-]{0,1}[1-9]*", o.toString());
        }
        return r;
    }

    /**
     * 是否是小数(包括负数)
     * 1.0 || 0.0 return true
     *
     * @param o 目标对象
     * @return true or false
     */
    public static boolean isFloat(Object o) {
        boolean r = false;
        // 匹配xxx.xxx
        String regex1 = "^[-]{0,1}[1-9][0-9]*\\.[0-9]+";
        // 匹配0.xxxx
        String regex2 = "^[-]{0,1}0\\.[0-9]+";
        if (o != null) {
            r = RegexUtils.isMatch(regex1, o.toString());
            if (!r) {
                r = RegexUtils.isMatch(regex2, o.toString());
            }
        }
        return r;
    }

    /**
     * 将值转成Integer型，如果不是整数，则返回替换值
     *
     * @param value   待转换对象
     * @param replace 替换值
     * @return
     */
    public static Integer parseInteger(Object value, Integer replace) {
        if (!isInteger(value)) {
            return replace;
        }
        return new Integer(value.toString());
    }

    /**
     * 将值转成Integer型，如果不是整数，则返回0
     *
     * @param value 待转换对象
     * @return
     */
    public static Integer parseInteger(Object value) {
        return parseInteger(value, 0);
    }

    /**
     * 将值转成Long型 如果不是整数，则返回替换值
     *
     * @param value   待转换对象
     * @param replace 替换值
     * @return
     */
    public static Long parseLong(Object value, Long replace) {
        if (!isInteger(value)) {
            return replace;
        }
        return new Long(value.toString());
    }

    /**
     * 将值转成Long型，如果不是整数，则返回0
     *
     * @param value 待转换对象
     * @return
     */
    public static Long parseLong(Object value) {
        return parseLong(value, 0L);
    }

    /**
     * 将值转成Double型 ，如果不是整数或小数，则返回替换值
     *
     * @param value   待转换对象
     * @param replace 替换值
     * @return
     */
    public static Double parseDouble(Object value, Double replace) {
        if (!isInteger(value) && !isFloat(value)) {
            return replace;
        }
        return new Double(value.toString());
    }

    /**
     * 将值转成Double型，如果不是整数或小数，则返回0
     *
     * @param value 待转换对象
     * @return
     */
    public static Double parseDouble(Object value) {
        return parseDouble(value, 0.0);
    }

    /**
     * 将值转成BigDecimal型 ，如果不是整数或小数，则返回替换值
     *
     * @param value   待转换对象
     * @param replace 替换值
     * @return
     */
    public static BigDecimal parseBigDecimal(Object value, BigDecimal replace) {
        if (!isInteger(value) && !isFloat(value)) {
            return replace;
        }
        return new BigDecimal(value.toString());
    }

    /**
     * 将值转成BigDecimal型，如果不是整数或小数，则返回0
     *
     * @param value 待转换对象
     * @return
     */
    public static BigDecimal parseBigDecimal(Object value) {
        return parseBigDecimal(value, BigDecimal.ZERO);
    }

    /**
     * 将值转成Float型 ，如果不是整数或小数，则返回替换值
     *
     * @param value   待转换对象
     * @param replace 替换值
     * @return
     */
    public static Float parseFloat(Object value, Float replace) {
        if (!isInteger(value) && !isFloat(value)) {
            return replace;
        }
        return Float.parseFloat(value.toString());
    }

    /**
     * 将值转成Float型，如果不是整数或小数，则返回0
     *
     * @param value 待转换对象
     * @return Float对象
     */
    public static Float parseFloat(Object value) {
        return parseFloat(value, 0.0f);
    }

    /**
     * BigDecimal加法
     *
     * @param b1
     * @param b2
     * @return 运算结果
     */
    public static BigDecimal add(BigDecimal b1, BigDecimal b2) {
        if (b1 == null) {
            b1 = BigDecimal.ZERO;
        }
        if (b2 == null) {
            b2 = BigDecimal.ZERO;
        }
        return b1.add(b2);
    }

    /**
     * BigDecimal减法
     *
     * @param b1
     * @param b2
     * @return 运算结果
     */
    public static BigDecimal subtract(BigDecimal b1, BigDecimal b2) {
        if (b1 == null) {
            b1 = BigDecimal.ZERO;
        }
        if (b2 == null) {
            b2 = BigDecimal.ZERO;
        }
        return b1.subtract(b2);
    }

    /**
     * BigDecimal乘法
     *
     * @param b1
     * @param b2
     * @return 运算结果
     */
    public static BigDecimal multiply(BigDecimal b1, BigDecimal b2) {
        if (b1 == null) {
            b1 = BigDecimal.ZERO;
        }
        if (b2 == null) {
            b2 = BigDecimal.ZERO;
        }
        return b1.multiply(b2);
    }

    /**
     * BigDecimal除法，默认保留3位小数，四舍五入
     *
     * @param b1 被除数
     * @param b2 除数
     * @return 运算结果
     */
    public static BigDecimal divide(BigDecimal b1, BigDecimal b2) {
        return NumberUtils.divide(b1, b2, 3, RoundingMode.HALF_UP);//默认使用四舍五入
    }

    /**
     * BigDecimal除法,带精度
     *
     * @param b1 被除数
     * @param b2 除数
     * @return 运算结果
     */
    public static BigDecimal divide(BigDecimal b1, BigDecimal b2, int scale, RoundingMode roudingMode) {
        if (b1 == null || b1.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        if (b2 == null || b2.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return b1.divide(b2, scale, roudingMode);
    }

    /**
     * BigDecimal大小比较
     * -1, 0, or 1 as b1 is numerically less than b2 , equal to, or greater than val.
     *
     * @param b1
     * @param b2
     * @return -1, 0, or 1
     */
    public static int compareTo(BigDecimal b1, BigDecimal b2) {
        if (b1 == null && b2 == null) {
            return 0;
        }
        if (b1 == null && b2 != null) {
            return -1;
        }
        if (b1 != null && b2 == null) {
            return 1;
        }
        return b1.compareTo(b2);
    }
}
