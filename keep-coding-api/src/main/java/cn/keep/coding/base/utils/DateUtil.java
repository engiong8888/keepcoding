package cn.keep.coding.base.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *<pre><b><font color="blue">DateUtils</font></b></pre>
 *
 *<pre><b>&nbsp;--描述说明--</b></pre>
 * JDK版本：JDK1.5.0
 */
public class DateUtil {
	
	
	/**
	 * 字符串yyyy-MM-dd HH:mm:ss，如果该对象为空，则返回空对象，否则返回该字符串转日期格式
	 */
	public static Date getStringToDate(String string){
		Date date = null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		try {
			if(!StringUtil.isBlank(string)){
				date = format.parse(string);
			}
		} catch (ParseException e) {
			System.err.println("字符串"+ string +"转为yyyy-MM-dd HH:mm:ss日期格式出错!");
		}
		return date;
	}
	
	/**
	 * 字符串yyyyMMddHHmmss，如果该对象为空，则返回空对象，否则返回该字符串转日期格式
	 */
	public static Date getString14ToDate(String string){
		DateFormat format14 = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Date date = null;
		try {
			if(!StringUtil.isBlank(string)){
				date = format14.parse(string);
			}
		} catch (ParseException e) {
			System.err.println("字符串"+ string +"转为yyyyMMddHHmmss日期格式出错!");
		}
		return date;
	}
	
	/**
	 * 字符串yyyy-MM-dd，如果该对象为空，则返回空对象，否则返回该字符串转日期格式
	 */
	public static Date getString10ToDate(String string){
		Date date = null;
		DateFormat format10 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(!StringUtil.isBlank(string)){
				date = format10.parse(string);
			}
		} catch (ParseException e) {
			System.err.println("字符串"+ string +"转为yyyy-MM-dd日期格式出错!");
		}
		return date;
	}
	
	/**
	 * 字符串yyyyMMdd，如果该对象为空，则返回空对象，否则返回该字符串转日期格式
	 */
	public static Date getString8ToDate(String string){
		Date date = null;
		DateFormat format8 = new SimpleDateFormat("yyyyMMdd");
		try {
			if(!StringUtil.isBlank(string)){
				date = format8.parse(string);
			}
		} catch (ParseException e) {
			System.err.println("字符串"+ string +"转为yyyyMMdd日期格式出错!");
		}
		return date;
	}
	
	/**
	 * 字符串HH，如果该对象为空，则返回空对象，否则返回该字符串转日期格式
	 */
	public static Date getStringH24ToDate(String string){
		Date date = null;
		DateFormat format = new SimpleDateFormat("HH");
		try {
			if(!StringUtil.isBlank(string)){
				date = format.parse(string);
			}
		} catch (ParseException e) {
			System.err.println("字符串"+ string +"转为HH日期格式出错!");
		}
		return date;
	}
	
	/**
	 * 日期转换为yyyy-MM-dd HH:mm:ss格式的字符串
	 */
	public static String getDateString(Date date){
		String str = "";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		if(date != null){
			try {
				str = format.format(date);
			} catch (Exception e) {
				System.err.println("日期转换为yyyy-MM-dd HH:mm:ss格式的字符串出错!");
			}
		}
		return str;
	}
	
	/**
	*  日期转换为yyyy-MM-dd HH:mm格式的字符串
	*/
	public static String getDateString16(Date date){
		String str = "";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		if(date != null){
			try {
				str = format.format(date);
			} catch (Exception e) {
				System.err.println("日期转换为yyyy-MM-dd HH:mm格式的字符串出错!");
			}
		}
		return str;
	}
	
	/**
	 *  日期转换为MM-dd HH:mm格式的字符串
	 */
	public static String getDateStringMdHm(Date date){
		String str = "";
		DateFormat format = new SimpleDateFormat("MM-dd HH:mm"); 
		if(date != null){
			try {
				str = format.format(date);
			} catch (Exception e) {
				System.err.println("日期转换为MM-dd HH:mm格式的字符串出错!");
			}
		}
		return str;
	}
	
	/**
	 *  日期转换为HH:mm格式的字符串
	 */
	public static String getDateStringHm(Date date){
		String str = "";
		DateFormat format = new SimpleDateFormat("HH:mm"); 
		if(date != null){
			try {
				str = format.format(date);
			} catch (Exception e) {
				System.err.println("日期转换为HH:mm格式的字符串出错!");
			}
		}
		return str;
	}
	
	/**
	 * 日期转换为yyyyMMddHHmmss格式的字符串
	 */
	public static String getDateString14(Date date){
		DateFormat format14 = new SimpleDateFormat("yyyyMMddHHmmss"); 
		String str = "";
		if(date != null){
			try {
				str = format14.format(date);
			} catch (Exception e) {
				System.err.println("日期转换为yyyyMMddHHmmss格式的字符串出错!");
			}
		}
		return str;
	}
	
	/**
	 * 日期转换为yyyy-MM-dd格式的字符串
	 */
	public static String getDateString10(Date date){
		String str = "";
		DateFormat format10 = new SimpleDateFormat("yyyy-MM-dd");
		if(date != null){
			try {
				str = format10.format(date);
			} catch (Exception e) {
				System.err.println("日期转换为yyyy-MM-dd格式的字符串出错!");
			}
		}
		return str;
	}
	
	/**
	 * 日期转换为yyyyMMdd格式的字符串
	 */
	public static String getDateString8(Date date){
		String str = "";
		DateFormat format8 = new SimpleDateFormat("yyyyMMdd");
		if(date != null){
			try {
				str = format8.format(date);
			} catch (Exception e) {
				System.err.println("日期转换为yyyyMMdd格式的字符串出错!");
			}
		}
		return str;
	}
	
	/**
	 * 日期转换为yyyy-MM-dd-HH格式的字符串
	 */
	public static String getDateStringYMDHH(Date date){
		String str = "";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH"); 
		if(date != null){
			try {
				str = format.format(date);
			} catch (Exception e) {
				System.err.println("日期转换为yyyy-MM-dd-HH格式的字符串出错!");
			}
		}
		return str;
	}
	
	/**
	 * 日期转换为HHmm格式的字符串
	 */
	public static String getDateStringHHmm(Date date){
		String str = "";
		DateFormat format = new SimpleDateFormat("HHmm");
		if(date != null){
			try {
				str = format.format(date);
			} catch (Exception e) {
				System.err.println("日期转换为HH:mm格式的字符串出错!");
			}
		}
		return str;
	}
	
	
	/**
	 * yyyyMMddHHmmss格式的字符串，转换成yyyy-MM-dd HH:mm:ss的格式的字符串
	 */
	public static String getString14ToLongDateString(String string){
		String str = "";
		if(!StringUtil.isBlank(string)){
			try {
				str = string.substring(0,4) + "-" + string.substring(4,6) + "-" +
				string.substring(6, 8) + " " + string.substring(8,10) + ":" +
				string.substring(10, 12) + ":" + string.substring(12,14);
			} catch (Exception e) {
				System.err.println("14位日期格式："+ string +"，转换成长日期格式出错!");
			}
		}
		return str;
	}
	
	/**
	 * yyyyMMddHHmmss格式的字符串，转换成yyyy-MM-dd的格式的字符串
	 */
	public static String getDateString8ToDateString10(String string){
		String str = "";
		if(!StringUtil.isBlank(string)){
			try {
				str = string.substring(0,4) + "-" + string.substring(4,6) + "-" + string.substring(6, 8);
			} catch (Exception e) {
				System.err.println("8位日期格式："+ string +"，转换为10位日期格式出错出错!");
			}
		}
		return str;
	}
	
	/**
	 * yyyy-MM-dd HH:mm:ss或yyyy-MM-dd格式的字符串，去掉"-"和":"<br>
	 * yyyy-MM-dd HH:mm:ss转为yyyyMMddHHmmss<br>
	 * yyyy-MM-dd 转为yyyyMMdd<br>
	 */
	public static String getLongDateStringToShortDateString(String string){
		String str = "";
		if(!StringUtil.isBlank(string)){
			try {
				str = string.replace("-", "").replace(":", "").replace(" ", "");
			} catch (Exception e) {
				System.err.println("长日期格式："+ string +"，转换为14位日期格式出错!");
			}
		}
		return str;
	}
	
	
	/**
	 * 传入一个日期，获得这个日期的前一天
	 */
	public static Date getDateToYesterday(Date date){
		Date ysDate = null;
		try {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(GregorianCalendar.DATE, -1);
			ysDate = new Date(calendar.getTime().getTime());
		} catch (Exception e) {
			System.err.println("获得这个日期的前一天出错!");
		}
		return ysDate;
	}
	
	/**
	 * 传入一个日期，获得这个日期的后一天
	 */
	public static Date getDateToTomorrow(Date date){
		Date twDate = null;
		try {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(GregorianCalendar.DATE, 1);
			twDate = new Date(calendar.getTime().getTime());
		} catch (Exception e) {
			System.err.println("获得这个日期的后一天出错!");
		}
		return twDate;
	}
	
	/**
	 * 传入两个日期，date1和date2<br>
	 * 返回date2减去date1所得的分钟数，long类型
	 */
	public static long getDateSubDateToMinutes(Date date1, Date date2){
		long minute = 0;
		try {
			if(date1 != null && date2 != null){
				long long1 = date1.getTime();
				long long2 = date2.getTime();
				minute = (long2 - long1) / 1000 / 60;
			}else{
				//System.out.println("date1或date2的对象为空!");
			}
		} catch (Exception e) {
			System.err.println("计算date2减去date1所得的秒数失败!");
		}
		return minute;
	}
	
	/**
	 * 传入两个日期，date1和date2<br>
	 * 返回date2减去date1所得的秒数，long类型
	 */
	public static long getDateSubDateToSeconds(Date date1, Date date2){
		long seconds = 0;
		try {
			if(date1 != null && date2 != null){
				long long1 = date1.getTime();
				long long2 = date2.getTime();
				seconds = (long2 - long1) / 1000;
			}else{
				//System.out.println("date1或date2的对象为空!");
			}
		} catch (Exception e) {
			System.err.println("计算date2减去date1所得的秒数失败!");
		}
		return seconds;
	}
	
	
	/**
	 * 传入两个日期，date1和date2<br>
	 * 判断date1是否比date2大，如果大的话，返回true，否则返回false
	 */
	public static boolean getDate1CompareDate2(Date date1, Date date2){
		boolean bool = false;
		try {
			if(date1 != null && date2 != null){
				if(date1.after(date2)){
					bool = true;
				}
			}else{
				//System.out.println("date1或date2的对象为空!");
			}
		} catch (Exception e) {
			System.err.println("比较date1和date2的大小出错!");
		}
		return bool;
	}
	
	/**
	 * 传入一个日期时间，获得当天的0点
	 */
	public static Date getDateZero(Date date){
		Date twDate = null;
		try {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
			calendar.set(GregorianCalendar.MINUTE, 0);
			calendar.set(GregorianCalendar.SECOND, 1);
			calendar.set(GregorianCalendar.MILLISECOND, 0);
			twDate = new Date(calendar.getTime().getTime());
			//System.out.println("计算后的时间是"+ getDateString(twDate));
		} catch (Exception e) {
			System.err.println("传入一个日期时间，获得当天的0点出错!");
		}
		return twDate;
	}
	
	/**
	 * 传入一个日期，根据传入的年、月、日进行相加减，获得新的日期
	 */
	public static Date getDateByYMD(Date date, int year, int month, int day){
		Date twDate = null;
		try {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(GregorianCalendar.YEAR, year);
			calendar.add(GregorianCalendar.MONTH, month);
			calendar.add(GregorianCalendar.DATE, day);
			twDate = new Date(calendar.getTime().getTime());
		} catch (Exception e) {
			System.err.println("传入一个日期，根据传入的年、月、日进行相加减，获得新的日期出错!");
		}
		return twDate;
	}
	
	/**
	 * 传入一个日期时间，根据传入的小时数进行相加减，正为加，负为减，获得相加后新的日期时间
	 */
	public static Date getDateByHour(Date date, int hour){
		Date twDate = null;
		try {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(GregorianCalendar.HOUR, hour);
			twDate = new Date(calendar.getTime().getTime());
			//System.out.println("计算后的时间是"+ getDateString(twDate));
		} catch (Exception e) {
			System.err.println("传入一个日期时间，根据传入的小时数进行相加减，获得相加后新的日期时间出错!");
		}
		return twDate;
	}
	
	/**
	 * 传入一个日期时间，根据传入的秒数进行相加减，正为加，负为减，获得相加后新的日期时间
	 */
	public static Date getDateBySecond(Date date, int second){
		Date twDate = null;
		try {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(GregorianCalendar.SECOND, second);
			twDate = new Date(calendar.getTime().getTime());
			//System.out.println("计算后的时间是"+ getDateString(twDate));
		} catch (Exception e) {
			System.err.println("传入一个日期时间，根据传入的秒数进行相加减，获得相加后新的日期时间出错!");
		}
		return twDate;
	}
	
	/**
	 * 传入一个日期时间，根据传入的天数进行相加减，正为加，负为减，获得相加后新的日期时间
	 */
	public static Date getDateByDay(Date date, int day){
		Date twDate = null;
		try {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(GregorianCalendar.DAY_OF_YEAR, day);
			twDate = new Date(calendar.getTime().getTime());
			//System.out.println("计算后的时间是"+ getDateString(twDate));
		} catch (Exception e) {
			System.err.println("传入一个日期时间，根据传入的天数进行相加，获得相加后新的日期时间!");
		}
		return twDate;
	}
	
	/**
	 * 传入一个日期时间，根据传入的月数进行相加减，正为加，负为减，获得相加后新的日期时间
	 */
	public static Date getDateByMonth(Date date, int month){
		Date twDate = null;
		try {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(GregorianCalendar.MONTH, month);
			twDate = new Date(calendar.getTime().getTime());
			//System.out.println("计算后的时间是"+ getDateString(twDate));
		} catch (Exception e) {
			System.err.println("传入一个日期时间，根据传入的月数进行相加，获得相加后新的日期时间!");
		}
		return twDate;
	}
	
	public static long getTimestampToPHP(Date date){
		if(date == null){
			return 0;
		}
		long timestamp = date.getTime();
		try {
			String timestampString = StringUtil.getlongToString(timestamp);
			timestampString = timestampString.substring(0, timestampString.length() -3);
			timestamp = StringUtil.getStringTolong(timestampString);
		} catch (Exception e) {
			System.err.println("日期转为php的时间戳出错!");
		} return timestamp;
	}
	
	public static Date getDateByPHPTimestamp(Long timestamp){
		Date date = new Date();
		if(timestamp == null){
			return date;
		}
		try {
			timestamp = timestamp * 1000;
			date = new Date(timestamp);
		} catch (Exception e) {
			System.err.println("php的时间戳转为日期出错!");
		} return date;
	}
	
	/*public static void main(String[] args){
		Date date = getStringH24ToDate("05");
		date = getDateZero(date);
		System.out.println(getDateString(date));
	}*/
	
}
