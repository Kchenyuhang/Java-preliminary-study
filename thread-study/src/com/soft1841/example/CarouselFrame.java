package com.soft1841.example;

import javax.swing.*;
import java.awt.*;

/**
 * 轮播窗体
 * @author 陈宇航
 * 2019.4.9
 */
public class CarouselFrame extends JFrame {
    private JLabel bgLabel;

    public CarouselFrame() {
        init();
        setTitle("轮播窗体");
        setSize(new Dimension(1500,1000));
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        bgLabel = new JLabel();
        add(bgLabel);
        CarouselThread ct = new CarouselThread();
        ct.setBgLabel(bgLabel);
        new Thread(ct).start();
    }

    public static void main(String[] args) {
        new CarouselFrame();
    }
}
