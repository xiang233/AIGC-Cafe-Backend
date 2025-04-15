package com.aigccafe.buterin.common.util;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
public class DateTimeUtils {
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    private static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMAT_CONSECUTIVE = "yyyyMMdd";
    private static final String DATE_MINUTER_FORMAT = "yyyy-MM-dd HH:mm";
    private static final String NORMAL_DATETIME_FORMAT = "yyyy-MM-dd+HH:mm:ss.SSSSSS";

    public static String formatDate(String format, long time) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date(time));
    }

    public static String formatDatetime(long time) {
        return formatDate(DEFAULT_DATETIME_FORMAT, time);
    }

    public static String formatNormalDatetime(long time) {
        return formatDate(NORMAL_DATETIME_FORMAT, time);
    }

    public static String formatDate(long time) {
        return formatDate(DEFAULT_DATE_FORMAT, time);
    }

    public static String formatConsecutiveDate(long time) {
        return formatDate(DATE_FORMAT_CONSECUTIVE, time);
    }

    public static String formatDateHour(long time) {
        return formatDate(DATE_MINUTER_FORMAT, time);
    }

    public static String nowDate() {
        return formatDate(System.currentTimeMillis());
    }

    public static String nowDateTime() {
        return formatDatetime(System.currentTimeMillis());
    }

    public static Long nowSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static Long nowMilliSeconds() {
        return System.currentTimeMillis();
    }

    public static Long dateToTime(String dateStr) {
        if (dateStr == null || dateStr.length() == 0) {
            return null;
        }
        return dateToTime(DEFAULT_DATE_FORMAT, dateStr);
    }

    public static Long datetimeToTime(String dateStr) {
        if (dateStr == null) {
            return null;
        }
        return dateToTime(DEFAULT_DATETIME_FORMAT, dateStr);
    }

    public static long dateToTime(String dateFormat, String dateStr) {
        try {
            Date date = new SimpleDateFormat(dateFormat).parse(dateStr);
            return date.getTime();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int daysDiff(String date1, String date2) {
        return (int) ((dateToTime(date1) - dateToTime(date2)) / (1000 * 60 * 60 * 24));
    }

    public static String addDays(String dateStr, int days) {
        DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        try {
            Date d = new Date(dateFormat.parse(dateStr).getTime() + 24L * 3600 * 1000 * days);
            return dateFormat.format(d);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String addDayTimes(String dateTimeStr, int second) {
        DateFormat dateTimeFormat = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);
        try {
            Date d = new Date(dateTimeFormat.parse(dateTimeStr).getTime() + 1000 * second);
            return dateTimeFormat.format(d);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String subtractDays(String dateStr, int days) {
        return addDays(dateStr, -days);
    }

    public static long dateToSeconds(String dateStr) {
        return dateToTime(DEFAULT_DATE_FORMAT, dateStr) / 1000;
    }

    public static Long datetimeToSeconds(String dateStr) {
        if (dateStr == null) {
            return null;
        }
        return dateToTime(DEFAULT_DATETIME_FORMAT, dateStr) / 1000;
    }

    public static List<String> getDateList(String startDate, String endDate) {
        List<String> list = new ArrayList<>();
        String date = startDate;
        while (endDate.compareTo(date) >= 0) {
            list.add(date);
            date = addDays(date, 1);
        }
        return list;
    }

    public static List<String> getDateList(Long startTimeSecond, Long endTimeSecond) {
        return getDateList(formatDate(startTimeSecond * 1000), formatDate(endTimeSecond * 1000));
    }

    public static List<String> getConsecutiveFormatDateList(Long startTimeSecond, Long endTimeSecond) {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_CONSECUTIVE);
        List<String> dateList = new ArrayList<>();
        while (formatDate(startTimeSecond * 1000).compareTo(formatDate(endTimeSecond * 1000)) <= 0) {
            Date d = new Date(startTimeSecond * 1000);
            dateList.add(dateFormat.format(d));
            startTimeSecond = startTimeSecond + 24L * 3600;
        }
        return dateList;
    }

    public static int dateToDay(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        Date d = null;
        Calendar calendar = Calendar.getInstance();
        try {
            d = dateFormat.parse(dateStr);
            calendar.setTime(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
