package com.soft1841.week2;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计算两个Date的差值
 * @author 陈宇航
 * 2019.3.18
 */
public class DateDifferentExample {
    public static void main(String[] args) {
        //创建日期，获取本地时间
        Date date = new Date();
        DateFormat df2 = new SimpleDateFormat("yyy-MM-dd hh:mm:ss EE");
        //分别定义起止时间
        String Time1 = "2019-03-18 08:19:00";
        String Time2 = "2019-03-18 08:10:00";
        String Time3 = "2019-03-18 03:00:00";
        String Time4 = "2019-03-17 08:00:30";
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String stopTime = format.format(date);
        Date d1;
        Date d2;
        Date d3;
        Date d4;
        Date d5;
        long diff = 0;
        long diff2 = 0;
        long diff3 = 0;
        long diff4 = 0;
        //通过SimpleDateFormat的对象来吧String类型的时间对象转化为Date类型的对象
        try {
            d1 = format.parse(Time1);
            d2 = format.parse(stopTime);
            d3 = format.parse(Time3);
            d4 = format.parse(Time4);
            d5 = format.parse(Time2);
            //毫秒ms的差值
            diff = d2.getTime() - d1.getTime();
            diff2 = d2.getTime() - d5.getTime();
            diff3 = d2.getTime() - d3.getTime();
            diff4 = d2.getTime() - d4.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //将毫秒分别转换算成秒、分、小时、天
        long diffSeconds = diff / 1000;
        long diffMinutes = diff2 / (1000 * 60);
        long diffHours = diff3 / (1000 * 60 * 60);
        long diffDays = diff4 / (1000 * 60 * 60 * 24);

        System.out.println("现在时间：" + df2.format(date));
        System.out.println(Time1 + "  " + Math.abs(diffSeconds) + "秒前");
        System.out.println(Time2 + "  " + Math.abs(diffMinutes) + "分前");
        System.out.println(Time3 + "  " + Math.abs(diffHours) + "小时前");
        System.out.println(Time4 + "  " + Math.abs(diffDays) + "天前");
    }
}
