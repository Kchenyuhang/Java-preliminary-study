package com.soft1841.week2;


/**
 * 枚举类型实例
 * 书P219拓展训练一
 * @author 陈宇航
 * 2019.3.21
 */

enum Week {
    MONDAY("周一"),TUESDAY("周二"),WEDNESDAY("周三"),THURSDAY("周四"),FRIDAY("周五"),SATURDAY("周六"),SUNDAY("周日");

    String weekName;

    Week(String weekName) {
        this.weekName = weekName;
    }

    public String getWeekName() {
        return weekName;
    }

    //定义一个静态方法，根据一个简称得到完整的日期名称
    public static Week getResult(String input) {
        switch (input) {
            case "mon":
                return Week.MONDAY;
            case "tue":
                return Week.TUESDAY;
            case "wed":
                return Week.WEDNESDAY;
            case "thu":
                return Week.THURSDAY;
            case "fri":
                return Week.FRIDAY;
            case "sta":
                return Week.SATURDAY;
            case "sun":
                return Week.SUNDAY;
        }
        return null;
    }
}
public class EnumTest {
    public static void main(String[] args) {
        Week week = Week.getResult("sta");
        System.out.println(week + "—" + week.getWeekName());
    }
}
