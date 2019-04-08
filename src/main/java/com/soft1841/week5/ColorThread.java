package com.soft1841.week5;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ColorThread extends Thread{
    private JPanel colorPanel;
    public void setColorPanel(JPanel colorPanel) {
        this.colorPanel = colorPanel;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int a = random.nextInt(256);
            int b = random.nextInt(256);
            int c = random.nextInt(256);
            colorPanel.setBackground(new Color(a,b,c));
            int x = random.nextInt(640);
            int y = random.nextInt(480);
            colorPanel.setBounds(x,y,100,100);
            try {
                Thread.sleep(0);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}