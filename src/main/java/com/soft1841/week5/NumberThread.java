package com.soft1841.week5;

import javax.swing.*;
import java.util.Random;

public class NumberThread extends Thread {
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
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        NumberThread numberThread = new NumberThread();
        numberThread.start();
    }
}
