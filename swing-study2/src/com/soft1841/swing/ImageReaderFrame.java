package com.soft1841.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * 图片阅读器窗体
 * @author 陈宇航
 * 2019.4.1
 */

public class ImageReaderFrame extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton confirmButton;
    private JPanel topPanel;
    private JLabel imageLabel;
    private Icon icon;

    //构造方法
    public ImageReaderFrame() {
        init();
        setTitle("图片阅读窗体");
        setSize(new Dimension(1920,1080));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        Font font = new Font("微软雅黑",Font.PLAIN,26);
        //顶部面板
        inputField = new JTextField(20);
        inputField.setFont(font);
        inputField.setPreferredSize(new Dimension(200,50));
        confirmButton = new JButton("确认");
        confirmButton.setPreferredSize(new Dimension(80,60));
        topPanel = new JPanel();
        //topPanel设置背景色和合适的大小
        topPanel.setBackground(new Color(126, 98, 255));
        topPanel.add(inputField);
        topPanel.add(confirmButton);
        //给按钮注册监听
        confirmButton.addActionListener(this);
        add(topPanel,BorderLayout.NORTH);

        imageLabel = new JLabel();
        add(imageLabel,BorderLayout.CENTER);


    }

    public static void main(String[] args) {
        new ImageReaderFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取输入框内容
        String filepath = inputField.getText().trim();
        //创建文件
        File file = new File(filepath);
        //使用三种方法
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
            icon = new ImageIcon(bytes);
            imageLabel.setIcon(icon);
            add(imageLabel,BorderLayout.CENTER);
        } catch (IOException e1) {
            JOptionPane.showConfirmDialog(null,"IO操作异常");
        }
    }
}
