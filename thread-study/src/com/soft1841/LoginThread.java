package com.soft1841;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LoginThread implements Runnable{
    //准备图片路径数组
    private String[] imgs = {"C:\\Users\\陈宇航\\Pictures\\Java大作业\\活动\\H1.png","C:\\Users\\陈宇航\\Pictures\\Java大作业\\活动\\H2.png",
            "C:\\Users\\陈宇航\\Pictures\\Java大作业\\活动\\H3.png", "C:\\Users\\陈宇航\\Pictures\\Java大作业\\活动\\H4.png"};
    //定义一个图片标签
    private JLabel bgLabel;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }
    @Override
    public void run() {
        int i = 0;
        int len = imgs.length - 1;
        while (true) {
            //通过路径构建File对象
            try {
                File file = new File(imgs[i]);
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                Icon icon = new ImageIcon(bytes);
                bgLabel.setIcon(icon);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if (i == len) {
                    i = 0;
                }
            } catch (IOException e) {
                System.out.println("IO异常");
            }
        }
    }
}
