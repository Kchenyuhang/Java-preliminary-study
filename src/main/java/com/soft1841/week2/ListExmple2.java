package com.soft1841.week2;

import java.util.ArrayList;
import java.util.List;

public class ListExmple2 {
    public static void main(String[] args) {
        System.out.println("---------NBA历史十大球星---------\n");
        String titles[] = {"球员","绰号","得分","篮板","助攻"};
        for (int i  = 0; i < titles.length; i++) {
            System.out.print(titles[i] + "   ");
        }
        System.out.println();//换行
        List<String> list = new ArrayList<>();
        list.add("乔丹,飞人/神,30.1,6.2,5.3");
        list.add("拉塞尔,指环王,15.1,22.5,4.3");
        list.add("贾巴尔,天钩,24.6,11.2,3.6");
        int length = list.size();
        for (int i = 0; i < length; i++) {
            String element = (String) list.get(i);
            String info[] = element.split(",");
            for (int j = 0; j < info.length; j++) {
                System.out.print(info[j] + "    ");
            }
            System.out.println();
        }
    }
}
