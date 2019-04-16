package com.soft1841;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 闹钟
 * @author 陈宇航
 * 2019.4.16
 */
public class AlarmClock extends JFrame {
    private JLabel timeLabel;
    private JPanel jPanel;
    private TimerTask timeTask;
    private Timer timer;

    public AlarmClock() {
        init();
        setTitle("闹钟窗体");
        setSize(new Dimension(500,350));
        setLocationRelativeTo(null);
        setLocation(0,0);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        jPanel = new JPanel(){
            protected void paintComponent(Graphics g){
                try {
                    Image bg = ImageIO.read(new File("C:\\Users\\陈宇航\\Pictures\\二次元壁纸\\K204.jpg"));
                    g.drawImage(bg,0,0,getWidth(),getHeight(),null);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        };
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER,200,200));
        add(jPanel);
        Font font = new Font("微软雅黑",Font.BOLD,22);
        timeLabel = new JLabel();
        timeLabel.setFont(font);
        jPanel.add(timeLabel);

        timeTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeString = sdf.format(date);
                timeLabel.setText(timeString);
                if (timeString.equals("2019-04-16 09:08:40")) {
                    JOptionPane.showConfirmDialog(null,"时间到~~~！");
                    this.cancel();
                }
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(timeTask,0,1000);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new AlarmClock();
    }
}
