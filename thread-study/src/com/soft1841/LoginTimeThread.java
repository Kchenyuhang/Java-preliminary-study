package com.soft1841;

import javax.swing.*;
import java.util.Random;

public class LoginTimeThread extends Thread {
    private JLabel numberLabel;
    public void setNumberLabel(JLabel numberLabel) {
        this.numberLabel = numberLabel;
    }
    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int num = random.nextInt(100);
            numberLabel.setText(String.valueOf(num));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("操作异常");
            }
        }
    }
}
