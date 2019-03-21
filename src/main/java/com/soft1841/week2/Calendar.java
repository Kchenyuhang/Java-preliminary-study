package com.soft1841.week2;

import java.util.Date;

public class Calendar {
    public static void main(String[] args) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        //获取年份、月份、天、小时、分钟、秒
        int year = calendar.get(java.util.Calendar.YEAR);
        int month = calendar.get(java.util.Calendar.MONTH);
        int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        int hours = calendar.get(java.util.Calendar.HOUR);
        int minute = calendar.get(java.util.Calendar.MINUTE);
        int second = calendar.get(java.util.Calendar.SECOND);
        System.out.println("当前时间为：" + year+ "-" + month+ "-" + day +
                "\t" + hours + ":" + minute + ":" + second);
        //调用Calender提供getTime（）方法用来获取date对象
        //将Calender对象转化为date对象
        Date date = new Date();
        //获取单前毫秒数
        Long time = calendar.getTimeInMillis();
        System.out.println("当前时间：" + date);
        System.out.println("当前毫秒数："+ time);
    }

}
