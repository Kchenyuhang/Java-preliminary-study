package com.soft1841.week3;

import javax.swing.*;
import java.awt.*;

public class JinYong extends JFrame {
    public JinYong() {
        setTitle("这个窗体使用边界布局管理器");
        Container c = getContentPane();
        setLayout(new BorderLayout());
        JButton centerBtn = new JButton("中神通");
        JButton northBtn = new JButton("北丐");
        JButton southBtn = new JButton("南帝");
        JButton westBtn = new JButton("西毒");
        JButton eastBtn = new JButton("东邪");
        c.add(centerBtn,BorderLayout.CENTER);
        c.add(northBtn,BorderLayout.NORTH);
        c.add(southBtn,BorderLayout.SOUTH);
        c.add(westBtn,BorderLayout.WEST);
        c.add(eastBtn,BorderLayout.EAST);
        setSize(500,300);
        setVisible(true);
        //设置窗体关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JinYong();
    }
}
