package com.soft1841.week1.calculatingarea;


/**
 * 形状父类
 * @author 陈宇航
 * 2019.3.10
 */
public abstract class Shape {
    //声明两个受保护类型的属性x,y
    protected double x;
    protected double y;

    public Shape() {
    }

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //声明了一个非抽象的成员方法，并实现方法体
    public void show() {
        System.out.println("面积");
    }

    //声明了一个抽象方法，不能带方法体
    public abstract double getArea();
}
