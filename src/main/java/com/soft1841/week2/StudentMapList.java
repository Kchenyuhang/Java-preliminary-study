package com.soft1841.week2;

import java.util.*;

public class StudentMapList {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        list1.add(new Student(03,"陈宇航"));
        list1.add(new Student(04,"高丙辰"));
        list1.add(new Student(21,"杨苏祥"));
        list2.add(new Student(33,"汤萌慧"));

        Map<String,List<Student>> map = new HashMap<>();
        map.put("男生",list1);
        map.put("女生",list2);
        System.out.println("*********按性别输出集合的结果***********");
        Iterator<Map.Entry<String,List<Student>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,List<Student>> entry = iterator.next();
            System.out.println(entry.getKey());
            List<Student> list = entry.getValue();
            list.forEach(student -> System.out.println(student));
        }
    }
}
