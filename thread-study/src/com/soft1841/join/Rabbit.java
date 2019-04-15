package com.soft1841.join;

public class Rabbit implements Runnable{
    private Thread tortoiseThread;

    public void setTortoiseThread(Thread tortoiseThread) {
        this.tortoiseThread = tortoiseThread;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("兔子跑了" + i * 10 + "米");
            if (i == 7) {
                //兔子跑到七十米开始睡觉
                System.out.println("兔子开始睡觉");
                try {
                    tortoiseThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (i == 10){
                //显示兔子到达终点
                System.out.println("兔子到达了终点");
            }
        }
    }
}
