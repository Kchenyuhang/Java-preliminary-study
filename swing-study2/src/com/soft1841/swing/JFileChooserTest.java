package com.soft1841.swing;

import javafx.stage.FileChooser;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;


/**
 * 文件选择器组件
 * @author 陈宇航
 * 2019.4.2
 */
public class JFileChooserTest extends JFrame implements ActionListener {
    private JButton chooseBtn;
    private JLabel pathLabel;
    private JFileChooser fileChooser;//文件选择器


    public JFileChooserTest() {
        init();
        setTitle("JFileChooserTest");
        setSize(new Dimension(1000, 800));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        chooseBtn = new JButton("选择文件");
        pathLabel = new JLabel("暂无选择");
        add(chooseBtn, BorderLayout.NORTH);
        chooseBtn.addActionListener(this);//监听
        Font font = new Font("微软雅黑", Font.BOLD, 26);
        pathLabel.setFont(font);
        add(pathLabel);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new JFileChooserTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("click");
        //创建JFileChooser对象
        fileChooser = new JFileChooser();
        //设置文件选择器的默认路径
        fileChooser.setCurrentDirectory(new File("D:\\"));
        //打开对话框
        int result = fileChooser.showOpenDialog(null);
        //用户点击了“确认”按钮
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
//            //将file的绝对路径显示在窗体中间
//            pathLabel.setText(file.getAbsolutePath());
            try {
                InputStream inputStream = new FileInputStream(file);
                Scanner scanner = new Scanner(inputStream);
                String resultStr = scanner.nextLine();
                pathLabel.setText(resultStr);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
