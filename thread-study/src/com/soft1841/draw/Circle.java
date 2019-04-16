package com.soft1841.draw;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Circle implements Runnable {
    int x = 600;
    int y = 600;
    private JFrame frame;
    private Thread txtThread;

    public void setTxtThread(Thread txtThread) {
        this.txtThread = txtThread;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                for (int i = 1; i <= 8; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Graphics graphics = frame.getGraphics();
                    graphics.setColor(Color.red);
                    graphics.drawOval(x / 2 - (i + 1) * 10, y / 2 - (i + 1) * 10, 10 + 20 * i, 10 + 20 * i);

                    if (i == 8) {
                        try {
                            txtThread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask,5,1000);
    }
}
