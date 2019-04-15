package com.soft1841.join;

public class RaceTest {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        Thread rabbitThread = new Thread(rabbit);
        Thread tortoiseThread = new Thread(tortoise);
        rabbit.setTortoiseThread(tortoiseThread);
        rabbitThread.start();
        tortoiseThread.start();
    }
}
