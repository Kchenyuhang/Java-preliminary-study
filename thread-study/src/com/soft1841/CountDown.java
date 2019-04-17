package com.soft1841;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * 倒计时小应用
 *
 * @author 陈宇航
 * 2019.4.17
 */
public class CountDown extends JFrame {
    private JPanel bgPanel;
    JButton jButton;
    JLabel jLabel;
    int time = 10;

    public CountDown() {
        bgPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                try {
                    Image bg = ImageIO.read(new File("C:\\Users\\陈宇航\\Pictures\\二次元壁纸\\K204.jpg"));
                    g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        bgPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 200));
        add(bgPanel);
        jButton = new JButton("Restart");
        jButton.setBackground(Color.RED);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                new CountDown();
            }
        });

        jLabel = new JLabel();
        new Thread() {
            public void run() {
                while (time > 0) {
                    time--;
                    if (time < 6) {
                        //当时间只剩5秒时闪红
                        jLabel.setForeground(Color.green);
                    }
                    jLabel.setText(time + "秒");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (time == 0) {
                        JOptionPane.showConfirmDialog(bgPanel, "起来打卡啦~~~~");
                    }
                }
            }

        }.start();
        bgPanel.add(jButton);
        bgPanel.add(jLabel);
        Font font = new Font("微软雅黑", Font.ITALIC, 20);
        Font font1 = new Font("微软雅黑", Font.ITALIC, 25);
        jButton.setFont(font);

        jLabel.setFont(font1);
        this.setTitle("倒计时");
        this.setSize(600, 400);
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new CountDown();

    }

}
