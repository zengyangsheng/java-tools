package com.zeng.utils.data;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author yangsheng.zeng
 * @date 2018/3/1 15:51
 */
public class DateUtils {
    private final static Logger log = LoggerFactory.getLogger(DateUtils.class);
    /**
     * yyyy-MM-dd HH:mm:ss  示例：2017-12-14 09:43:32
     */
    public static final String YYYY_MM_DD_HH_MM_SS_SSSSSS = "yyyy-MM-dd HH:mm:ss:SSSSSS";

    /**
     * yyyy-MM-dd HH:mm:ss  示例：2017-12-14 09:43:32
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyy-MM-dd HH:mm  示例：2017-12-14 09:44
     */
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    /**
     * yyyy-MM-dd  示例：2017-12-14
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    /**
     * yyyyMMdd  示例：20171214
     */
    public static final String YYYYMMDD = "yyyyMMdd";
    /**
     * yyyyMMddHHmmssms  示例：2017121409433211
     */
    public static final String YYYYMMDDHHMMSSMS = "yyyyMMddHHmmssms";
    /**
     * yyMMdd  示例：171214
     */
    public static final String YYMMDD = "yyMMdd";
    /**
     * yyyyMM  示例：201712
     */
    public static final String YYYYMM = "yyyyMM";
    /**
     * yyyy-MM 示例：2017-12
     */
    public static final String YYYY_MM = "yyyy-MM";

    /**
     * MM/dd 示例:12/14
     */
    public static final String MMDD = "MM/dd";

    /**
     * MM/dd 示例:12/14
     */
    public static final String DDMM = "dd/MM";

    /**
     * HH:mm:ss 示例：09:43:32
     */
    public static final String HH_MM_SS = "HH:mm:ss";
    /**
     * HH:mm:ss 示例：094332
     */
    public static final String HHMMSS = "HHmmss";

    /**
     * 字符串转化为Date
     *
     * @return String 日期字符串
     * @throws ParseException
     * @throws ParseException
     */
    public static Date strToDate(String dateStr){

        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat();
                return sdf.parse(dateStr);
            }
        } catch (ParseException e) {
            log.error("字符串转化为Date异常!dateStr:"+dateStr+e.getMessage());
            throw new RuntimeException("字符串转化为Date异常!");
        }
    }

    /**
     * 字符串转化为Date
     *
     * @return String 日期字符串
     * @throws ParseException
     * @throws ParseException
     */
    public static Date strToDate(String dateStr,String format){

        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                return sdf.parse(dateStr);
            }
        } catch (ParseException e) {
            log.error("字符串转化为Date异常!dateStr:"+dateStr+e.getMessage());
            throw new RuntimeException("字符串转化为Date异常!");
        }
    }


    /**
     * Date转化为字符串
     * @param Date 日期
     * @return String  yyyy-MM-dd HH:mm:ss
     */
    public static String dateToStr(Date date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
            return sdf.format(date);
        }
    }

    /**
     * Date转化为字符串
     *
     * @param Date
     *            日期
     * @param format
     *            格式
     * @return String
     */
    public static String dateToStr(Date date, String format) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
    }


    /**
     * 获取当前日期且转换为long
     *
     *
     * @param format
     *            格式如：(yyyyMMdd、yyyyMMddHHmmss)
     * @return String
     */
    public static long dateToNum(Date date,String format) {
        return Integer.parseInt(DateUtils.dateToStr(date,format));
    }


    /**
     * 获取某一天
     *
     * @param days 天数
     * @return Date
     */
    public static Date add(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 获取某一天
     *
     * @param years	年数
     * @return Date
     */
    public static Date addYear(int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    /**
     * 获取某一天
     * @param dateStr  日期
     * @param format   格式
     * @param days     天数
     * @return String
     */
    public static String addDate(String dateStr, String format, long days) {

        Date d = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            } else {

                d = simpleDateFormat.parse(dateStr);
            }
        } catch (ParseException e) {
            log.error("字符串转化为Date异常!dateStr:" + dateStr + e.getMessage());
            throw new RuntimeException("字符串转化为Date异常!");
        }

        long time = d.getTime();
        days = days * 24 * 60 * 60 * 1000;
        time += days;

        return simpleDateFormat.format(new Date(time));
    }


    /**
     * 计算两日期之间天数
     *
     * @param startDate
     *            起始日期
     * @param endDate
     *            结束日期
     * @return int
     */
    public static int getDay(Date startDate, Date endDate) {
        if (startDate.after(endDate)) {
            Date cal = startDate;
            startDate = endDate;
            endDate = cal;
        }
        long sl = startDate.getTime();
        long el = endDate.getTime();
        long ei = el - sl;
        return (int) (ei / 0x5265c00L);
    }

    /**
     * 计算两日期之间天数
     *
     * @param startDate
     *            起始日期
     * @param endDate
     *            結束日期
     * @return int
     * @throws ParseException
     */
    public static int getDay(String startDate, String endDate)
            throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);

        Date s = sdf.parse(startDate);
        calendar.setTime(s);
        long timethis = calendar.getTimeInMillis();

        Date e = sdf.parse(endDate);
        calendar.setTime(e);
        long timeend = calendar.getTimeInMillis();

        return (int) ((timeend - timethis) / (1000 * 60 * 60 * 24));
    }

    /**
     * 得到今天的日期时间数组串,前面小时间,后面大时间
     * @return ['2014-03-29 00:00:00','2014-03-29 23:59:59']
     */
    public static String[] getNearTodayDateTimeStr(){
        Calendar cal=Calendar.getInstance();
        String today=dateToStr(cal.getTime(),YYYY_MM_DD);
        return  new String[]{today+" 00:00:00",today+" 23:59:59"};
    }

    /**
     * Date转化为字符串
     *
     * @param Date 日期
     * @param b (true 加 23:59:59，false加  00:00:00)
     * @return String
     */
    public static String appendStr(Date date, boolean b) {
        if(b){
            return DateUtils.dateToStr(date,DateUtils.YYYY_MM_DD) +" 23:59:59";
        }else {
            return  DateUtils.dateToStr(date,DateUtils.YYYY_MM_DD) +" 00:00:00";
        }
    }
    public static String getDateByCalendar(Calendar calendar, String format) {
        return FastDateFormat.getInstance(format).format(calendar);
    }
    public static String getPrevMonths(String format, Integer prevMons) {
        Calendar calendar = Calendar.getInstance();
        StringBuffer result = new StringBuffer(getDateByCalendar(calendar, format));
        // 获取当前月的前6个月，已默认添加了一个月
        for (int i = 0; i < prevMons; i++) {
            calendar.add(Calendar.MONTH, -1);
            result.append("," + getDateByCalendar(calendar, format));
        }
        return result.substring(0, result.length());
    }

    //增加，type传Calendar.DAY_OF_MONTH之类的枚举
    public static Date add(Date date, Integer type, Integer day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(type, day);
        return calendar.getTime();
    }
}
