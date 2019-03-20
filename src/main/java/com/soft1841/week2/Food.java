package com.soft1841.week2;


/**
 * 自定义食品类，实现比较器接口，按照id升序排序
 * 实现Comparable接口，必须强制重写其compareTo()方法
 * @author 陈宇航
 * 2019.3.20
 */
public class Food implements Comparable<Food> {
    private String name;
    private Integer id;

    public Food(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(Food food) {
        return this.getId() - food.getId();
    }
}
