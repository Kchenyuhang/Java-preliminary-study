package com.soft1841.list;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List接口的基础练习
 * @author 陈宇航
 * 2019.3.19
 */
public class ListTest {
    public static void main(String[] args) {
        //1、创建一个List对象，加入元素
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        //直接输出List对象
        System.out.println(list);
        //2、通过for循环遍历集合
        for (int i = 0, len = list.size(); i < len ;i++) {
            System.out.println(list.get(i));
        }
        //3、通过Iterator迭代器遍历集合
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //4、通过Lambda表达式遍历集合
        list.forEach(str-> System.out.println(str));
    }
}
