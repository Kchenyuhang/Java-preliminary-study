package com.soft1841.week3;

import javax.swing.*;
import java.awt.*;


/**
 * 使用流布局管理器
 * @author 陈宇航
 * 2019.3.25
 */
public class FlowLayoutPosition extends JFrame {
    public FlowLayoutPosition() {
        setTitle("本窗体使用流布局管理器");
        Container c = getContentPane();
        //设置窗体使用流布局管理器，使组件右对齐，组件之间的水平间隔为10像素，垂直间隔为10像素
        setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
        for (int i = 0; i < 10; i ++){
            c.add(new JButton("button" + i));
        }
        setSize(500,200);
        //设置窗体关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //设置窗体可见
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutPosition();
    }
}
