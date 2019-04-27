package com.soft1841.carousel;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ChooseCarouselFrame extends JFrame implements ActionListener {
    private JButton chooseBtn;
    private JPanel imgPanel, topPanel;
    private static final long serialVersionUID = 1L;
    private Thread threaddA;
    private JLabel timeLabel;
    final JProgressBar progressBar = new JProgressBar();


    public ChooseCarouselFrame() {
        init();
        setTitle("多选轮播窗体");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(progressBar, BorderLayout.SOUTH);
        // 设置进度条的前景色
        progressBar.setForeground(new Color(0, 210, 40));
        // 设置进度条的背景色
        progressBar.setBackground(new Color(188, 190, 194));
        progressBar.setStringPainted(true);
        int res = JOptionPane.showConfirmDialog(null, "是否继续操作", "是否继续", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {

            threaddA = new Thread(new Runnable() {
                int count = 0;

                public void run() {
                    while (true) {
                        progressBar.setValue(++count);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            threaddA.start();
        } else {
            System.out.println("选择否后执行的代码"); // 点击“否”后执行这个代码块
            return;
        }
    }

    public void init() {
        chooseBtn = new JButton("选择图片");
        add(chooseBtn, BorderLayout.WEST);
        chooseBtn.addActionListener(this);
        imgPanel = new JPanel();
        add(imgPanel);
        imgPanel.setBackground(new Color(251, 238, 200));

        topPanel = new JPanel();
        timeLabel = new JLabel();
        Font font1 = new Font("楷体", Font.BOLD, 30);
        timeLabel.setFont(font1);
        topPanel.add(timeLabel);
        add(topPanel, BorderLayout.NORTH);
        ChooseCarouyselThread chooseCarouyselThread = new ChooseCarouyselThread();
        chooseCarouyselThread.setTimeLabel(timeLabel);
        new Thread(chooseCarouyselThread).start();
//        txtLabel = new JLabel();
//        add(txtLabel,BorderLayout.NORTH);
//        ChooseCarouyselThread ct = new ChooseCarouyselThread();
//        ct.setTxtLabel(txtLabel);
//        new Thread(ct).start();
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle =
                    BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ChooseCarouselFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtn) {
            JLabel imgLabel = new JLabel();
            imgPanel.add(imgLabel);
            ChooseImg chooseImg = new ChooseImg();
            chooseImg.setBgLabel(imgLabel);
            new Thread(chooseImg).start();
        }
    }
}

class ChooseImg implements Runnable {
    private JLabel bgLabel;
    private JFileChooser fileChooser;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }

    @Override
    public void run() {
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\陈宇航\\Pictures\\二次元壁纸"));
        fileChooser.setMultiSelectionEnabled(true);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            //获取选中的所有文件
            File[] files = fileChooser.getSelectedFiles();
            int i = 0;
            int len = files.length - 1;
            while (true) {
                try {
                    File file = new File(String.valueOf(files[i]));
                    InputStream inputStream = new FileInputStream(file);
                    byte[] bytes = new byte[(int) file.length()];
                    inputStream.read(bytes);
                    Icon icon = new ImageIcon(bytes);
                    bgLabel.setIcon(icon);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    if (i == len) {
                        i = 0;
                    }
                } catch (IOException e) {
                    System.err.println("IO异常");
                }
            }
        }
    }
}

