package com.soft1841.week5;

/**
 * @author 陈宇航
 * 2019.4.8
 */
public class RunnableTest extends Object implements Runnable{
    private int count = 10;
    @Override
    public void run() {
        while (true){
            System.out.print(count + " ");
            if (--count == 0){
                break;
            }
        }
    }
    public static void main(String[] args) {
        //实现Runnabel接口
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        //启动线程
        thread.start();
    }
}
