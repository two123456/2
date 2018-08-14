package com.superhero.netctoss.test.OsQueryTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.superhero.netctoos.util.DateCast;

public class CalendarTest {
	public static void main(String[] args) {
		 Calendar cale = null;
	        cale = Calendar.getInstance();
	        int year = cale.get(Calendar.YEAR);
	        int month = cale.get(Calendar.MONTH) + 1;
	        int day = cale.get(Calendar.DATE);
	        int hour = cale.get(Calendar.HOUR_OF_DAY);
	        int minute = cale.get(Calendar.MINUTE);
	        int second = cale.get(Calendar.SECOND);
	        int dow = cale.get(Calendar.DAY_OF_WEEK);
	        int dom = cale.get(Calendar.DAY_OF_MONTH);
	        int doy = cale.get(Calendar.DAY_OF_YEAR);
	 
	        System.out.println("Current Date: " + cale.getTime());
	        System.out.println("Year: " + year);
	        System.out.println("Month: " + month);
	        System.out.println("Day: " + day);
	        System.out.println("Hour: " + hour);
	        System.out.println("Minute: " + minute);
	        System.out.println("Second: " + second);
	        System.out.println("Day of Week: " + dow);
	        System.out.println("Day of Month: " + dom);
	        System.out.println("Day of Year: " + doy);
	 
	        // 获取当月第一天和最后一天
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        String firstday, lastday;
	        // 获取前月的第一天
	        cale = Calendar.getInstance();
	        cale.add(Calendar.MONTH, 0);
	        cale.set(Calendar.DAY_OF_MONTH, 1);
	        firstday = format.format(cale.getTime());
	        // 获取前月的最后一天
	        cale = Calendar.getInstance();
	        cale.add(Calendar.MONTH, 1);
	        cale.set(Calendar.DAY_OF_MONTH, 0);
	        lastday = format.format(cale.getTime());
	        System.out.println("本月第一天和最后一天分别是 ： " + firstday + " and " + lastday);
	 
	        // 获取当前日期字符串
	        Date d = new Date();
	        System.out.println("当前日期字符串1：" + format.format(d));
	        System.out.println("当前日期字符串2：" + year + "/" + month + "/" + day + " "
	                + hour + ":" + minute + ":" + second);
	        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        System.out.println(format2.format(getStartTime(new Date())));
	        System.out.println(format2.format(getEndTime(DateCast.sqlDateChange("2018-02-02"))));
	    }
	/**
	 * 获取每天的开始时间 00:00:00:00
	 *
	 * @param date
	 * @return
	 */
	public static Date getStartTime(Date date) {
	    Calendar dateStart = Calendar.getInstance();
	    dateStart.setTime(date);
	    dateStart.set(Calendar.HOUR_OF_DAY, 0);
	    dateStart.set(Calendar.MINUTE, 0);
	    dateStart.set(Calendar.SECOND, 0);
	    return dateStart.getTime();
	}

	/**
	 * 获取每天的开始时间 23:59:59:999
	 *
	 * @param date
	 * @return
	 */
	public static Date getEndTime(Date date) {
	    Calendar dateEnd = Calendar.getInstance();
	    dateEnd.setTime(date);
	    dateEnd.set(Calendar.HOUR_OF_DAY, 23);
	    dateEnd.set(Calendar.MINUTE, 59);
	    dateEnd.set(Calendar.SECOND, 59);
	    return dateEnd.getTime();
	}
	
}
