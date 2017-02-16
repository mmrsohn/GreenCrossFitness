package com.greencross.fitness.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 시간 클래스의 시간 문자열 처리 & 시간 문자열의 시간 클래스 처리
 * @author yss1976
 */
public class CDateUtil {
	public static final String				DEFAULT_FORMAT		= "yyyy-MM-dd HH:mm:ss";
	public static final String				PULL_TO_REFRESH_FORMAT = "yyyy.MM.dd aa KK:mm";
	
	private static final SimpleDateFormat	simpleDateFormat	= new SimpleDateFormat(DEFAULT_FORMAT);

	private CDateUtil() {

	}
	
	public static String getPullToRefreshString(long timeMillis) {
		SimpleDateFormat tempFormat = new SimpleDateFormat(PULL_TO_REFRESH_FORMAT);
		return tempFormat.format(new Date(timeMillis));
	}

	/**
	 * milliseconds를 시간 포멧 문자열로 변환
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFormattedString(long timeMillis, String format) {
		SimpleDateFormat tempFormat = new SimpleDateFormat(format);
		return tempFormat.format(new Date(timeMillis));
	}

	/**
	 * milliseconds를 표준 시간 포멧 문자열로 변환
	 * @param date
	 * @return
	 */
	public static String getFormattedString(long timeMillis) {
		return simpleDateFormat.format(new Date(timeMillis));
	}

	/**
	 * 시간 포멧 문자열을 milliseconds로 변환
	 * @param formatStr
	 * @param timeStr
	 * @return
	 */
	public static long getTime(String formatStr, String timeStr) {
		long timeMillis = 0L;
		try {
			SimpleDateFormat dform = new SimpleDateFormat(formatStr);
			timeMillis = dform.parse(timeStr).getTime();
		} catch (ParseException e) {
			timeMillis = 0L;
		}
		return timeMillis;
	}
}
