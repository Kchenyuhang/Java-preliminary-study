package com.soft1841.carousel;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class ChooseCarouyselThread implements Runnable {
    private JLabel timeLabel;

    public void setTimeLabel(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            Date date = new Date();
            DateFormat df3 = new SimpleDateFormat("yyy年MM月dd日 hh时mm分ss秒 EE", Locale.CHINA);
            timeLabel.setText(String.valueOf(df3.format(date)));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}