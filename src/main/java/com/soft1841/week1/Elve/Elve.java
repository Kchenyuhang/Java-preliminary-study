package com.soft1841.week1.Elve;


/**
 * 精灵实体类
 * @author 陈宇航
 * 2019.3.10
 */
public class Elve {
    public static void main(String[] args) {
        MoveApp moveApp = new MoveApp();
        SingApp singApp = new SingApp();
        System.out.println("精灵" + moveApp.move() + ",也" + singApp.sing());
    }
}
