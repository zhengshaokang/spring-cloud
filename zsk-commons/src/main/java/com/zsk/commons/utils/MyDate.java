package com.zsk.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * @author connor-zheng
 * 
 */
public class MyDate {
    public static String YEAR_FORMAT = "yyyy";
    public static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * 获得默认时区 - 亚洲/上海
     * 
     * @return
     */
    public static TimeZone getTimeZone() {
        return TimeZone.getTimeZone("Asia/Shanghai");
    }
    
    /**
     * 获得默认时区下的 Calendar 对象
     * 
     * @return
     */
    public static Calendar calendar() {
        return Calendar.getInstance(getTimeZone());
    }
    
    /**
     * 获得当天的 Date 对象
     * 
     * @return
     */
    public static Date today() {
        return calendar().getTime();
    }
    
    /**
     * 把 Date 对象转换为指定显示格式的字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        
        return sf.format(date);
    }
    
    /**
     * 获得当前时间, 以 yyyy-MM-dd HH:mm:ss 格式显示
     * 
     * @return
     */
    public static String getCurrentDateTime() {
        return format(today(), DATETIME_FORMAT);
    }
    
    /**
     * 获得当前年份
     * 
     * @return
     */
    public static Integer getCurrentYear() {
        return new Integer(format(today(), YEAR_FORMAT));
    }
    
    /**
     * 获得当前的毫秒数
     * 
     * @return
     */
    public static Long getTime() {
        return calendar().getTimeInMillis();
    }
}
