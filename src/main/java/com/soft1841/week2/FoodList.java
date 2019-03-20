package com.soft1841.week2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 实现Comparable接口的Food，放入List进行id排序
 * @author 陈宇航
 * 2019.3.20
 */
public class FoodList {
    public static void main(String[] args) {
        //创建List对象，存入Food对象
        List<Food> list = new ArrayList<>();
        list.add(new Food("西红柿",1));
        list.add(new Food("青菜",5));
        list.add(new Food("萝卜",3));
        list.add(new Food("橘子",4));
        list.add(new Food("洋葱",2));
        //调用Collections的sort方法，会自动调用之前写的compareTo方法进行排序
        Collections.sort(list);
        //用foreach循环遍历list
        for (Food food : list) {
            System.out.println("编号：" + food.getId() + "，名称：" + food.getName());

        }
    }
}
