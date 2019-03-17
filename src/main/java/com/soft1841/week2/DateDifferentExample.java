package com.soft1841.week2;


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
        //分别定义起止时间
        String startTime = "2019-03-16 06:30:00";
        String stopTime = "2019-03-18 11:54:30";
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date d1;
        Date d2;
        long diff = 0;
        //通过SimpleDateFormat的对象来吧String类型的时间对象转化为Date类型的对象
        try {
            d1 = format.parse(startTime);
            d2 = format.parse(stopTime);
            //毫秒ms的差值
            diff = d2.getTime() - d1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //将毫秒分别转换算成秒、分、小时、天
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (1000 * 60);
        long diffHours = diff / (1000 * 60 * 60);
        long diffDays = diff / (1000 * 60 * 60 * 24);

        System.out.println("两个时间相差：" + Math.abs(diffSeconds) + "秒");
        System.out.println("两个时间相差：" + Math.abs(diffMinutes) + "分");
        System.out.println("两个时间相差：" + Math.abs(diffHours) + "小时");
        System.out.println("两个时间相差：" + Math.abs(diffDays) + "天");
    }
}
