package de.gravitex.bpmtest.ejb.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateHelper {

	private static Logger logger = Logger.getLogger(DateHelper.class);

	private static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	private static final DateFormat dateTimeFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

	/**
	 * Formatiert ein übergebenes Datum in des Format 'dd.mm.yyyy'.
	 * 
	 * @param qualifiedDate
	 * @return
	 */
	public static String formatDate(Date qualifiedDate) {
		if (qualifiedDate != null)
			return dateFormat.format(qualifiedDate);
		return "";
	}

	/**
	 * Formatiert ein übergebenes Datum in des Format 'dd.mm.yyyy'.
	 * 
	 * @param qualifiedDate
	 * @return
	 */
	public static String formatDateTime(Date qualifiedDateTime) {
		if (qualifiedDateTime != null)
			return dateTimeFormat.format(qualifiedDateTime);
		return "";
	}

	/**
	 * Double liegen von Java aus in der Form 123.3458973987345 vor. Ziel :
	 * 
	 * 123,89
	 * 
	 * @param value
	 * @return
	 */
	public static String formatDouble(Double value) {

		NumberFormat _nf = NumberFormat.getInstance(java.util.Locale.GERMAN);
		DecimalFormat _df = (DecimalFormat) _nf;
		_df.applyPattern("0.00");

		return _df.format(value);
	}

	public static String formatAsHoursMinutesSeconds(long milliSeconds) {

		long dividerHours = 1000 * 60 * 60;
		long dividerMinutes = 1000 * 60;
		long dividerSeconds = 1000;

		// h
		long hours = milliSeconds / dividerHours;
		long restOfHours = milliSeconds - (hours * dividerHours);

		// m
		long minutes = restOfHours / dividerMinutes;
		long restOfMinutes = restOfHours - (minutes * dividerMinutes);

		// s
		long seconds = restOfMinutes / dividerSeconds;

		return hours + " Stunden, " + minutes + " Minuten, " + seconds + " Sekunden";
	}

	public static String formatDateTime(long value) {
		return formatDateTime(new Date(value));
	}

	public static String formatDate(long milliSecondsFromScratch) {
		return dateTimeFormat.format(milliSecondsFromScratch);
	}

	public static Date parseDate(String dateStr) {
		try {
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			logger.warn("'" + dateStr + "' can not be parsed as " + Date.class.getCanonicalName() + ".");
			return null;
		}
	}
}
