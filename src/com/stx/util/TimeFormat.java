package com.stx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {
	public static String getLocalTime(){
		Date d = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(d);
	}
}
