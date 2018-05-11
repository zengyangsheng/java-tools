package com.zhaogang.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: CommonConstants
 * @Description: TODO
 * @author: yangsheng.zeng
 * @date: 2018/5/8 13:25
 * @version: V1.0
 */
public class BigDecimalUtils {

	/**
	 * 加法
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static BigDecimal add(BigDecimal b1,BigDecimal b2){
		if(b1 == null){
			b1 = BigDecimal.ZERO;
		}
		if(b2 == null){
			b2 = BigDecimal.ZERO;
		}
		return b1.add(b2);
	}
	/**
	 * 减法
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static BigDecimal subtract(BigDecimal b1,BigDecimal b2){
		if(b1 == null){
			b1 = BigDecimal.ZERO;
		}
		if(b2 == null){
			b2 = BigDecimal.ZERO;
		}
		return b1.subtract(b2);
	}
	/**
	 * 乘法
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static BigDecimal multiply(BigDecimal b1,BigDecimal b2){
		if(b1 == null){
			b1 = BigDecimal.ZERO;
		}
		if(b2 == null){
			b2 = BigDecimal.ZERO;
		}
		return b1.multiply(b2);
	}
	/**
	 * 除法
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static BigDecimal divide(BigDecimal b1,BigDecimal b2){
		if(b1 == null || b1.equals(BigDecimal.ZERO)){
			return BigDecimal.ZERO;
		}
		if(b2 == null || b2.equals(BigDecimal.ZERO)){
			return BigDecimal.ZERO;
		}
		return b1.divide(b2);
	}
	
	/**
	 * 除法
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static BigDecimal divide(BigDecimal b1,BigDecimal b2,int scale){
		if(b1 == null || b1.equals(BigDecimal.ZERO)){
			return BigDecimal.ZERO;
		}
		if(b2 == null || b2.equals(BigDecimal.ZERO)){
			return BigDecimal.ZERO;
		}
		return b1.divide(b2,scale,RoundingMode.HALF_UP);//默认使用四舍五入
	}
	
	/**
	 * 除法
	 * @param b1
	 * @param b2
	 * @param scale 精度
	 * @param roundingMode 模式
	 * @return
	 */
	public static BigDecimal divide(BigDecimal b1,BigDecimal b2,int scale,int roundingMode ){
		if(b1 == null || b1.equals(BigDecimal.ZERO)){
			return BigDecimal.ZERO;
		}
		if(b2 == null){
			b2 = BigDecimal.ZERO;
		}
		return b1.divide(b2, scale, roundingMode);
	}
	
	/**
	 * 检查带有除数字以外的字符
	 * @param stockItemIdStr
	 */
	public static String transferNumber(String stockItemIdStr){
		Pattern p=Pattern.compile("^\\d+$");
		Matcher m=p.matcher(stockItemIdStr);
		if(m.matches()){
	       return stockItemIdStr;
	    }
		return "99999999";
	}
	
	/**
	 * 检查带有除数字和小数点(包含负数)以外的字符
	 * @param weightStr
	 */
	public static String transferNumberWithPoint(String weightStr){
		if(isInteger(weightStr)){//如果是整数，则不需继续判断
			return weightStr;
		}
		Pattern p=Pattern.compile("^[\\-]?\\d+\\.\\d+$");
		Matcher m=p.matcher(weightStr);
		if(m.matches()){
	       return weightStr;
	    }
		return "-999999999";
	}
	
	/** 判断是否为整数  
	  * @param str 传入的字符串  
	  * @return 是整数返回true,否则返回false  
	*/  
	public static boolean isInteger(String str) {    
	    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");    
	    return pattern.matcher(str).matches();    
	}  

	public static BigDecimal truncateDecimalPlace(BigDecimal oldValue, int scale) {
		BigDecimal midValue = oldValue.setScale(scale + 1, BigDecimal.ROUND_DOWN);
		BigDecimal newValue = midValue.setScale(scale, BigDecimal.ROUND_HALF_UP);
		return newValue;
	}
}

