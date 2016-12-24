package com.ytwman.greens.commons.helper;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ytwman on 16/12/24.
 */
public class DateFormatter {

    private static String[] weeks = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
    private static String YESTERDAY = "昨天";
    private static String BEFORE_DAWN = "凌晨"; // 0 - 8
    private static String MORNING = "上午";// 8-12
    private static String AFTERNOON = "下午"; // 12-18
    private static String EVENING = "晚上"; // 18-24

    public static final String FORMAT_DATETIME = "yyyy-MM-dd hh:mm:ss";
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_TIME = "HH:mm:ss";
    public static final String FORMAT_YEAR_AND_MONTH = "yyyy年M月";
    public static final String FORMAT_MONTH_AND_DAY = "M月d日";
    public static final String FORMAT_HOUR = "HH:mm";

    /**
     * 根据当前时间按照标准格式输出
     *
     * @param date
     * @return
     */
    public static String toPrettyString(Date date) {
        Calendar now = Calendar.getInstance();
        Calendar val = Calendar.getInstance();
        val.setTime(date);

        // 年
        int yearNow = now.get(Calendar.YEAR);
        int yearVal = val.get(Calendar.YEAR);
        // 年的第几周
        int weekNow = now.get(Calendar.WEEK_OF_YEAR);
        int weekVal = val.get(Calendar.WEEK_OF_YEAR);
        // 年的第几日
        int dayNow = now.get(Calendar.DAY_OF_YEAR);
        int dayVal = val.get(Calendar.DAY_OF_YEAR);

        StringBuffer sb = new StringBuffer();

        if (yearNow == yearVal) {
            if (dayNow == dayVal) {
                // 是否当天，返回时间
                int hour = val.get(Calendar.HOUR_OF_DAY);
                if (hour >= 0 && hour < 8) {
                    sb.append(BEFORE_DAWN);
                }
                if (hour >= 8 && hour < 12) {
                    sb.append(MORNING);
                }
                if (hour >= 12 && hour < 18) {
                    sb.append(AFTERNOON);
                }
                if (hour >= 18 && hour <= 24) {
                    sb.append(EVENING);
                }

                sb.append(Delimiter.BLANK).append(DateFormatUtils.format(val, FORMAT_HOUR));
            } else if (dayNow - 1 == dayVal) {
                // 是否昨天，返回昨天 时间
                sb.append(YESTERDAY).append(Delimiter.BLANK).append(DateFormatUtils.format(val, FORMAT_HOUR));
            } else if (weekNow == weekVal) {

                // 如果为周日则不显示
                if (val.get(Calendar.DAY_OF_WEEK) == 1) {
                    sb.append(DateFormatUtils.format(val, FORMAT_MONTH_AND_DAY));
                } else {
                    // 是否当年当周，返回周几 时间
                    String week = weeks[val.get(Calendar.DAY_OF_WEEK) - 1];
                    sb.append(week).append(Delimiter.BLANK).append(DateFormatUtils.format(val, FORMAT_HOUR));
                }
            } else {
                // 是否当年，返回月 日
                sb.append(DateFormatUtils.format(val, FORMAT_MONTH_AND_DAY));
            }
        } else {
            // 其他
            sb.append(DateFormatUtils.format(val, FORMAT_YEAR_AND_MONTH));
        }

        return sb.toString();
    }

    public static Date parse(String dateStr, String s) {
        SimpleDateFormat format = new SimpleDateFormat(s);
        try {
            return format.parse(dateStr);
        } finally {
            return null;
        }
    }

    public static Date parse(String dateStr) {
        return parse(dateStr, FORMAT_DATETIME);
    }

    public static String format(Date date, String s) {
        SimpleDateFormat format = new SimpleDateFormat(s);
        return format.format(date);
    }

    public static String format(Date date) {
        return format(date, FORMAT_DATETIME);
    }

    public static void main(String[] args) {
        Calendar calendar
                = Calendar.getInstance();

        // 当前时间
        String text = toPrettyString(calendar.getTime());
        System.err.println(text);

        // 昨天
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        text = toPrettyString(calendar.getTime());
        System.err.println(text);

        // 前天
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        text = toPrettyString(calendar.getTime());
        System.err.println(text);

        // 间隔3天
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        text = toPrettyString(calendar.getTime());
        System.err.println(text);

        // 上个月
        calendar.add(Calendar.MONTH, -1);
        text = toPrettyString(calendar.getTime());
        System.err.println(text);

        // 去年
        calendar.add(Calendar.YEAR, -1);
        text = toPrettyString(calendar.getTime());
        System.err.println(text);
    }
}
