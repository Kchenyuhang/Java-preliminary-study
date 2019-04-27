package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Login extends JFrame implements ActionListener {
    private JFileChooser fileChooser;
    private JButton chooseBtn, preBtn, nextBtn;
    private GridLayout gridLayout;
    private JPanel westPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private JPanel rightPanel;
    private JButton firstBtn;
    private JButton lastBtn;
    private CardLayout cardLayout;
    private Container leftContainer;
    private JLabel[] labels;

    public Login() {
        init();
        setTitle("PICView窗体");
        setVisible(true);
        setSize(1920, 1030);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        gridLayout = new GridLayout();
        cardLayout = new CardLayout();
        centerPanel = new JPanel();
        westPanel = new JPanel();
        bottomPanel = new JPanel();
        rightPanel = new JPanel();
        chooseBtn = new JButton("选择图片");
        preBtn = new JButton("上一张");
        nextBtn = new JButton("下一张");
        firstBtn = new JButton("第一张");
        lastBtn = new JButton("最后一张");
        bottomPanel.add(preBtn);
        bottomPanel.add(firstBtn);
        bottomPanel.add(chooseBtn);
        bottomPanel.add(nextBtn);
        bottomPanel.add(lastBtn);
        chooseBtn.addActionListener(this);
        firstBtn.addActionListener(this);
        preBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        lastBtn.addActionListener(this);
        //按钮面板加入窗体底部
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setBackground(new Color(255, 234, 125));

//        westPanel.setMaximumSize(new Dimension(550, JFrame.HEIGHT));
//        westPanel.setMinimumSize(new Dimension(550,JFrame.HEIGHT));

        westPanel.setLayout(gridLayout);
        add(westPanel,BorderLayout.WEST);
        rightPanel.setLayout(cardLayout);
        add(rightPanel,BorderLayout.CENTER);

        westPanel.setBackground(new Color(0, 0, 2));
        centerPanel.setBackground(new Color(60, 63, 65));
        rightPanel.setBackground(new Color(58, 181, 230));
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtn) {
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("D:\\图片"));
            //设置文件为多选模式
            fileChooser.setMultiSelectionEnabled(true);
            //打开对话框,阻塞模式
            int result = fileChooser.showOpenDialog(null);
            //用户选择了文件
            if (result == JFileChooser.APPROVE_OPTION) {
                //获取选中的所有文件,放到一个文件类型的数组中
                File[] files = fileChooser.getSelectedFiles();
                for (File fs : files) {
                    System.out.println(fs.getAbsolutePath());
                    //对每个fs文件，创建字节输入流读入字节数组，构建Icon，并设置给JLabel
                    try {
                        byte[] bytes = new byte[(int) fs.length()];
                        InputStream inputStream = new FileInputStream(fs);
                        inputStream.read(bytes);
                        Icon icon = new ImageIcon(bytes);
                        JLabel imgLabel = new JLabel();
                        imgLabel.setIcon(icon);
                        rightPanel.add(imgLabel);
                    } catch (IOException e1) {
                        JOptionPane.showConfirmDialog(null,"IO操作异常");
                    }
                }
                InputStream inputStream;
                byte[] bytes;
                gridLayout = new GridLayout((files.length / 3) + 1, 3, 5, 5);
                westPanel.setLayout(gridLayout);
                labels = new JLabel[files.length];
                for (int i = 0; i < files.length; i++) {
                    labels[i] = new JLabel();
                    try {
                        files = fileChooser.getSelectedFiles();
                        inputStream = new FileInputStream(files[i]);
                        bytes = new byte[(int) files[i].length()];
                        inputStream.read(bytes);
                        Icon icon = new ImageIcon(bytes);
                        labels[i].setIcon(icon);
                        westPanel.add(labels[i]);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "IO异常");
                    }
                }

            }
        }
        if (e.getSource() == preBtn) {
            cardLayout.previous(rightPanel);
        }
        if (e.getSource() == nextBtn) {
            cardLayout.next(rightPanel);
        }
        if (e.getSource() == firstBtn) {
            cardLayout.first(rightPanel);
        }
        if (e.getSource() == lastBtn) {
            cardLayout.last(rightPanel);
        }
    }
}