package com.soft1841.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 组件绘制
 * @author 陈宇航
 * 2019.4.16
 */
public class ComponentPaintFrame extends JFrame {
    public ComponentPaintFrame(){
        init();
        setTitle("组件绘制");
        setSize(1200,700);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void init(){
        JPanel jPanel =new  JPanel(){
            protected void paintComponent(Graphics graphics){
                try {
                    Image bg = ImageIO.read(new File("C:\\Users\\陈宇航\\Pictures\\二次元壁纸\\K384.png"));
                    graphics.drawImage(bg,0,0,getWidth(),getHeight(),null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER,200,200));
        add(jPanel);
        JButton jButton = new JButton(){
            protected void paintComponent(Graphics graphics){
                try {
                    Image bg = ImageIO.read(new File("C:\\Users\\陈宇航\\Pictures\\二次元壁纸\\K204.jpg"));
                    graphics.drawImage(bg,0,0,getWidth(),getHeight(),null);
                    graphics.drawString("按钮",55,25);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
        jButton.setPreferredSize(new Dimension(150,50));
        jButton.setFocusPainted(false);
        jButton.setContentAreaFilled(false);
        jButton.setBorderPainted(false);
        jPanel.add(jButton);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new ComponentPaintFrame();
    }
}
