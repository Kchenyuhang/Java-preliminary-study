package com.soft1841;

import javax.swing.*;
import java.awt.*;

public class DrawImage extends JFrame {
    public DrawImage(){
        this.setSize(1000,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new CanvasTest());
        this.setTitle("绘制图像");
    }

    public static void main(String[] args) {
        //使窗体可见
        new DrawImage().setVisible(true);
    }

    class CanvasTest extends Canvas{
        public  void paint(Graphics g){
            super.paint(g);
            Graphics2D graphics2D = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/img/2.jpg")).getImage();
            graphics2D.drawImage(img,0,0,this);
        }
    }
}
