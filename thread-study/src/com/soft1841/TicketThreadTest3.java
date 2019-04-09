package com.soft1841;

/**
 * 售票线程程序3
 * 实现Runnable接口并同步线程（加锁）
 *
 * @author 陈宇航
 * 2019.4.9
 */
public class TicketThreadTest3 {
    public static void main(String[] args) {
        TicketThread3 tt = new TicketThread3();
        Thread thread1 = new Thread(tt, "窗口1");
        thread1.start();
        Thread thread2 = new Thread(tt, "窗口2");
        thread2.start();
        Thread thread3 = new Thread(tt, "窗口3");
        thread3.start();
    }
}

class TicketThread3 implements Runnable {
    private int tickets = 10;

    @Override
    public void run() {
        while (tickets > 0) {
            //线程加锁
            synchronized (this) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("中断异常");
                    }
                    System.out.println(Thread.currentThread().getName() + "售票，当前票数：" + --tickets);
                } else {
                    break;
                }
            }
        }
    }
}
