package com.internousdev.template.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String getDate() {

		Date date = new Date();

//		yyyy/MM/ddの直後にスペースを空ける。
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		return simpleDateFormat.format(date);
	}
}
