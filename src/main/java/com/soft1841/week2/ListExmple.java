package com.soft1841.week2;

import java.util.ArrayList;
import java.util.List;

public class ListExmple {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("球员    绰号    得分    篮板    助攻");
        list.add("乔丹    飞人/神 30.1    6.2     5.3");
        list.add("拉塞尔  指环王  15.1    22.5    4.3");
        list.add("贾巴尔  天钩    24.6    11.2    3.6");
        int length = list.size();
        System.out.println("——————NBA历史十大球星——————");
        for (int i = 0; i < length; i++) {
            System.out.println(list.get(i));
        }
    }
}
