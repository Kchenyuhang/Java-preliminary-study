package com.soft1841.week2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArticleListTest {
    public static void main(String[] args) throws ParseException {
        List<Article> list = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        list.add(new Article(1,"只要你的心是善的对错都是别人的事","大鱼海棠",simpleDateFormat.parse("2019-03-18 22:20:50")));
        list.add(new Article(2,"樱花满地集于我心楪舞纷飞祈愿相随","罪恶王冠",simpleDateFormat.parse("2019-03-18 22:28:50")));
        list.add(new Article(3,"与肝胆人共事从无字句处读书","周恩来",simpleDateFormat.parse("2019-03-17 22:14:50")));
        System.out.println("id    标题                    作者          时间");
        Iterator<Article> iterator = list.iterator();
        while (iterator.hasNext()){
            Article article = iterator.next();
            String result;
            result = timeCal(simpleDateFormat.format(article.getWriteTime()));
            System.out.println(article.getId()+"     "+article.getTitle().substring(0,10)+"..."+
                    article.getAuthor()+"      "+result);
        }
    }
    private static String timeCal(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1;
        long diff = 0;
        try {
            d1 = format.parse(time);
            Date now = new Date();
            diff = now.getTime() - d1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        if (seconds < 60) {
            return "刚刚";
        } else if (minutes < 60) {
            return minutes + "分钟前";
        } else if (hours < 24) {
            return hours + "小时前";
        } else {
            return days + "天前";
        }
    }

}
