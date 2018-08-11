package com.superhero.netctoos.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateCast {
	/**
	 * 字符串转sql.Date
	 * @param date 传入的字符串
	 * @return sqlDate
	 */
	public static Date sqlDateChange(String date) {
		if(date==null) {
			return null;
		}
		String sqlDate = date.replace("/", "-");
		if("".equals(sqlDate.trim())||!sqlDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
			return null;
		}
		return Date.valueOf(sqlDate);
	}

	/**
	 *字符串转util.Date
	 * @param date 传入的字符串
	 * @return utilDate
	 */
	public static java.util.Date utilDateChange(String date){
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		if(date==null) {
			return null;
		}
		String sqlDate = date.replace("/", "-");		
		try {
			return formatter.parse(sqlDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
