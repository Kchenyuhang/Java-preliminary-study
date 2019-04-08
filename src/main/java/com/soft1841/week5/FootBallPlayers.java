package com.soft1841.week5;

/**
 * @author 陈宇航
 * 2019.4.8
 */
public class FootBallPlayers {
    public static void main(String[] args) {
        System.out.println("A队B队球员入场：");
        A a = new A();
        a.start();
        B b = new B();
        b.start();
    }
}

class A extends Thread {
    public void run() {
        for (int i = 1; i <= 11; i++) {
            System.out.print("A" + i + " ");
        }
    }
}

class B extends Thread {
    public void run() {
        for (int j = 1; j <= 11; j++) {
            System.out.print("B" + j + " ");
        }
    }
}
