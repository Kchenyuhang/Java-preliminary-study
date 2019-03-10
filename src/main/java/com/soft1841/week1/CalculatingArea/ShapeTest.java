package com.soft1841.week1.CalculatingArea;


/**
 * 实现类
 * @author 陈宇航
 * 2019.3.10
 */
public class ShapeTest {
    public static void main(String[] args) {
        //上转型对象
        Shape shape1 = new Rectangle(4.0,3.0);
        shape1.show();
        System.out.println(shape1.getArea());
        Shape shape2 = new Circular(5.0,4.0);
        shape2.show();
        System.out.println(shape2.getArea());
    }
}
