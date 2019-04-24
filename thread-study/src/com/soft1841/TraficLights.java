package com.soft1841;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 交通信号灯
 * @author 陈宇航
 * 2019.4.15
 */
public class TraficLights extends JFrame {
    private JPanel contentPane;
    private JLabel lblImage;

    public TraficLights() {
        init();
        setTitle("交通信号灯");
        setSize(new Dimension(700,400));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        setContentPane(contentPane);

        JPanel imagePane = new JPanel();
        imagePane.setBackground(Color.WHITE);
        imagePane.setBorder(new TitledBorder(null,"交通灯", TitledBorder.LEADING,TitledBorder.TOP,null,null));
        contentPane.add(imagePane);
        imagePane.setLayout(new BorderLayout(0,0));

        lblImage = new JLabel("");
        lblImage.setBackground(Color.WHITE);
        lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("/img/Green.png")));
        imagePane.add(lblImage,BorderLayout.CENTER);

        Thread thread = new TurnColor(lblImage);
        thread.start();
    }

    public static void main(String[] args) {
        new TraficLights();
    }
}

class TurnColor extends Thread {
    private JLabel lblImage;

    public TurnColor(JLabel lblImage) {
        this.lblImage = lblImage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("/img/Yellow.png"))); // 黄灯
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("/img/Red.png"))); // 红灯
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("/img/Green.png"))); // 绿灯
        }
    }
}
