package com.soft1841.week1.CalculatingArea;


/**
 * 圆形
 * @author 陈宇航
 * 2019.3.10
 */
public final class Circular extends Shape{
    public Circular() {
        super();
    }
    public Circular(double x, double y) {
        super(x,y);
    }
    @Override
    public void show() {
        System.out.print("圆形面积是：");
    }
    @Override
    public double getArea() {
        return super.x * super.y * super.y;
    }
}
