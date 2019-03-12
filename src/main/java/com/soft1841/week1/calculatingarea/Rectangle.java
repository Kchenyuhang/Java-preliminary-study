package com.soft1841.week1.calculatingarea;


/**
 * 圆形
 * @author 陈宇航
 * 2019.3.10
 */
public class Rectangle extends Shape{
    public Rectangle() {
        super();
    }
    public Rectangle(double x, double y) {
        //在构造方法中给父类属性x和y初始化，通过super.x和super.y访问父类属性
        super.x = x;
        super.y = y;
    }
    @Override
    public void show() {
        super.show();
        System.out.print("矩形面积是：");
    }
    @Override
    public double getArea() {
        return this.x * this.y;
    }
}
