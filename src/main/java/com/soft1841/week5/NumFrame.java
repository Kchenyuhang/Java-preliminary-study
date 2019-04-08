package com.soft1841.week5;

import javax.swing.*;
import java.awt.*;

public class NumFrame extends JFrame {
    private JLabel numberLabel,timeLabel;
    private JPanel topPanel,centerPanel,bottomPanel,colorPanel;
    public NumFrame() {
        init();
        setTitle("多线程窗体");
        setSize(new Dimension(1500,1000));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public void init(){
        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();
        timeLabel = new JLabel();
        numberLabel = new JLabel();
        colorPanel = new JPanel();
        Font font = new Font("微软雅黑",Font.BOLD,60);
        Font font1 = new Font("楷体",Font.BOLD,30);
        numberLabel.setFont(font);
        timeLabel.setFont(font1);
        topPanel.add(timeLabel);
        bottomPanel.add(colorPanel);
        centerPanel.add(numberLabel);
        add(topPanel,BorderLayout.NORTH);
        add(centerPanel,BorderLayout.SOUTH);
        add(bottomPanel,BorderLayout.CENTER);
        NumberThread numThread = new NumberThread();
        TimeThread timeThread = new TimeThread();
        ColorThread colorThread = new ColorThread();
        numThread.setNumberLabel(numberLabel);
        timeThread.setTimeLabel(timeLabel);
        colorThread.setColorPanel(colorPanel);
        numThread.start();
        timeThread.start();
        colorThread.start();

    }

    public static void main(String[] args) {
        new NumFrame();
    }
}
