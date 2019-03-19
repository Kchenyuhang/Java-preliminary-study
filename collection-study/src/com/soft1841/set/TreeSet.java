package com.soft1841.set;

import java.util.Iterator;
import java.util.Set;

public class TreeSet {
    public static void main(String[] args) {
        Set<Integer> set = new java.util.TreeSet<>();
        //向Set集合中添加元素
        set.add(-5);
        set.add(-7);
        set.add(10);
        set.add(6);
        set.add(3);
        //创建Iterator迭代器对象
        Iterator<Integer> iterator = set.iterator();
        System.out.print("Set集合中的元素：");
        //遍历并输出Set集合中的元素
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
