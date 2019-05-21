package com.soft1841.week10;

public class AdapterTest {
    public static void main(String[] args) {
        System.out.println("大家好，我是一个射手座~~！");
        Student student1 = new Student() {
            @Override
            public void proseReading() {
                System.out.println("我喜欢阅读散文，");
            }
        };
        student1.proseReading();
        Student student2 = new Student() {
            @Override
            public void novelReading() {
                System.out.println("我也喜欢阅读小说。");
            }
        };
        student2.novelReading();
        Student student3 = new Student() {
            @Override
            public void popMusic() {
                System.out.print("喜欢听流行乐，");
            }
        };
        student3.popMusic();
        Student student4 = new Student() {
            @Override
            public void ancientMusic() {
                System.out.println("同时，也爱听古风乐！");
            }
        };
        student4.ancientMusic();
    }
}
