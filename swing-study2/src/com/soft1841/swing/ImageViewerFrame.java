package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * 使用卡片布局实现多图浏览功能
 *
 * @author 陈宇航
 * 2019.4.2
 */
public class ImageViewerFrame extends JFrame implements ActionListener {
    private JButton chooseBtn, preBtn, nextBtn,firstBtn,lastBtn;
    private JFileChooser fileChooser;
    private JPanel centerPanel, bottmPanel;
    private CardLayout cardLayout;

    public ImageViewerFrame() {
        init();
        setTitle("使用卡片布局实现多图浏览窗体");
        setSize(new Dimension(1000, 800));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init() {
        //底部按钮面板，放置三个按钮
        bottmPanel = new JPanel();
        chooseBtn = new JButton("选择图片");
        preBtn = new JButton("前一张");
        nextBtn = new JButton("后一张");
        firstBtn = new JButton("第一张");
        lastBtn = new JButton("最后一张");
        bottmPanel.add(chooseBtn);
        bottmPanel.add(firstBtn);
        bottmPanel.add(preBtn);
        bottmPanel.add(nextBtn);
        bottmPanel.add(lastBtn);
        chooseBtn.addActionListener(this);
        firstBtn.addActionListener(this);
        preBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        lastBtn.addActionListener(this);
        //按钮面板加入窗体底部
        add(bottmPanel, BorderLayout.SOUTH);
        bottmPanel.setBackground(new Color(255, 234, 125));
        //创建中间面板，并设置布局为卡片布局
        centerPanel = new JPanel();
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.setBackground(new Color(58, 181, 230));
        add(centerPanel);
    }
    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ImageViewerFrame();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtn) {
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\陈宇航\\Pictures\\二次元壁纸"));
            //设置文件为多选模式
            fileChooser.setMultiSelectionEnabled(true);
            //打开对话框，阻塞模式
            int result = fileChooser.showOpenDialog(null);
            //用户选择了文件
            if (result == JFileChooser.APPROVE_OPTION) {
                //获取选中的所有文件,放到一个文件类型的数组中
                File[] files = fileChooser.getSelectedFiles();
                //遍历文件数组
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
                        centerPanel.add(imgLabel);
                    } catch (IOException e1) {
                        JOptionPane.showConfirmDialog(null,"IO异常");
                    }
                }
            }
        }
        if (e.getSource() == preBtn) {
            cardLayout.previous(centerPanel);
        }
        if (e.getSource() == nextBtn) {
            cardLayout.next(centerPanel);
        }
        if (e.getSource() == firstBtn) {
            cardLayout.first(centerPanel);
        }
        if (e.getSource() == lastBtn) {
            cardLayout.last(centerPanel);
        }
    }
}
