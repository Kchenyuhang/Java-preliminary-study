package com.soft1841.set;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set接口基础程序
 * @author 陈宇航
 * 2019.3.19
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set = new java.util.HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A");
        System.out.println(set);
//        String s1 = new String("A");
//        String s2 = new String("B");
//        String s3 = new String("C");
//        String s4 = new String("A");
//        set.add(s1);
//        set.add(s2);
//        set.add(s3);
//        set.add(s4);
//        System.out.println(set);
        //用for循环遍历set集合
        System.out.println("for循环遍历结果");
        Object[] array = set.toArray();
        for (int i = 0, len = set.size(); i < len; i++) {
            System.out.print(array[i] + "  ");
        }
        //用Iterator迭代器遍历set集合
        System.out.println("\n" + "Ietrator迭代器遍历结果");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
        System.out.println("\n" + "Lambda表达式遍历结果");
        //用Lambda表达式遍历集合
        set.forEach(str-> System.out.print(str + "  "));
    }
}
