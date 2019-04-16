package com.soft1841.draw;


import javax.swing.*;
import java.awt.*;

public class CircleFrame extends JFrame {
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public CircleFrame() {
        init();
        setTitle("同心圆");
        setSize(1350, 1080);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        textArea = new JTextArea();
        textArea.setSize(500,600);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);

        add(scrollPane,BorderLayout.EAST);
        scrollPane.setBounds(0,0,500,600);

        Circle circle = new Circle();
        Txt txt = new Txt();
        Thread circleThread = new Thread(circle);
        Thread txtThread = new Thread(txt);

        Txt t = new Txt();
        t.setTextArea(textArea);

        circle.setTxtThread(txtThread);
        circle.setFrame(this);
        circleThread.start();
        txtThread.start();
    }

    public static void main(String[] args) {
        new CircleFrame();
    }
}