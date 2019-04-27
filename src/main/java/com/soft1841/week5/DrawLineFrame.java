package com.soft1841.week5;


import javax.swing.*;
import java.awt.*;

public class DrawLineFrame extends JFrame {
    public DrawLineFrame(){
        Init();
        setTitle("彩绘彩色线段");
        setSize(1000,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void Init(){
        getContentPane().setBackground(new Color(0,0,0));
        DrawLineThread drawLineThread = new DrawLineThread();
        drawLineThread.setFrame(this);
        new Thread(drawLineThread).start();
    }

    public static void main(String[] args) {
        new DrawLineFrame();
    }
}
