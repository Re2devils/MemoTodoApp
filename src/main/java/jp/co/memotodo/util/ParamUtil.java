package jp.co.memotodo.util;

import java.sql.Timestamp;

public class ParamUtil {
	public static Timestamp stringToDate(String dateStr) {
		if(dateStr == null || dateStr.isEmpty())
			return null;
		else {
			String dateTime = dateStr.replace('T', ' ');
			dateTime += ":00";
			return Timestamp.valueOf(dateTime);
		}


	}

	public static String dateToString(Timestamp timestamp) {

		if(timestamp == null || timestamp.toString().isEmpty())
			return null;
		else {
			String dateStr = timestamp.toString().substring(0, 16);
			String dateTime = dateStr.replace(' ', 'T');
			return dateTime;
		}


	}
}
