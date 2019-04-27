package com.soft1841;

import com.soft1841.week5.TimeThread;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 仿制幻想全明星登陆界面
 * @author 陈宇航
 * 2019.4.25
 */
public class Login extends JFrame implements ActionListener {
    private JMenuBar top;
    private FlowLayout flowLayout;
    private JPanel leftPanel, topPanel, centerPanel, SouthBottomPanel;
    private JMenuItem bt, bt1, bt2, bt3, bt4, bt5;
    private JButton pBt1, pBt2;
    private JLabel bgLabel, timeLabel;
    private Thread threaddA;
    final JProgressBar progressBar = new JProgressBar();
    private JLabel accountLabel, passwordLabel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton confirmButton;

    public Login() {
        init();
        setTitle("登录界面");
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(350, 150, 1280, 720);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(progressBar, BorderLayout.SOUTH);
        // 设置进度条的前景色
        progressBar.setForeground(new Color(88, 116, 190));
        // 设置进度条的背景色
        progressBar.setBackground(new Color(39, 34, 51));
        progressBar.setStringPainted(true);
        int res = JOptionPane.showConfirmDialog(null, "是否检查", "版本更新检查", JOptionPane.YES_NO_OPTION);
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
        Font font = new Font("微软雅黑", Font.BOLD, 15);
        SouthBottomPanel = new JPanel();
        leftPanel = new JPanel();
        centerPanel = new JPanel();
        topPanel = new JPanel();
        flowLayout = new FlowLayout();
        centerPanel.setLayout(flowLayout);
        flowLayout.setHgap(5);
        add(leftPanel, BorderLayout.CENTER);
        leftPanel.setBackground(new Color(73, 198, 231));
        centerPanel.setBackground(new Color(73, 198, 231));
        topPanel.setBackground(new Color(73, 198, 231));
        //设置菜单
        top = new JMenuBar();
        bt = new JMenuItem() {
            protected void paintComponent(Graphics graphics) {
                try {
                    Image bg = ImageIO.read(new File("C:\\Users\\陈宇航\\Pictures\\Java大作业\\p1.png"));
                    graphics.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        bt.setPreferredSize(new Dimension(95, 80));
        bt.setFocusPainted(false);
        bt.setContentAreaFilled(false);
        bt.setBorderPainted(false);
        //设置组件
        bt1 = new JMenuItem("官方首页");
        bt1.setFont(font);
        bt2 = new JMenuItem("注册账号");
        bt2.setFont(font);
        bt3 = new JMenuItem("问题反馈");
        bt3.setFont(font);
        bt4 = new JMenuItem("充值中心");
        bt4.setFont(font);
        bt5 = new JMenuItem("新手礼包");
        bt5.setFont(font);
        //将组件加入菜单
        top.add(bt);
        top.add(bt1);
        top.add(bt2);
        top.add(bt3);
        top.add(bt4);
        top.add(bt5);
        add(top, BorderLayout.NORTH);
        //设置按钮，用画笔绘制按钮
        pBt1 = new JButton() {
            protected void paintComponent(Graphics g) {
                try {
                    Image bg = ImageIO.read(new File("C:\\Users\\陈宇航\\Pictures\\Java大作业\\按钮\\D1.png"));
                    g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
                } catch (IOException e) {
                    System.out.println("操作异常");
                }
            }
        };
        pBt1.setPreferredSize(new Dimension(110, 70));
        pBt1.setFocusPainted(false);
        pBt1.setContentAreaFilled(false);
        pBt1.setBorderPainted(false);

        pBt2 = new JButton() {
            protected void paintComponent(Graphics g) {
                try {
                    Image bg = ImageIO.read(new File("C:\\Users\\陈宇航\\Pictures\\Java大作业\\按钮\\D2.png"));
                    g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
                } catch (IOException e) {
                    System.out.println("异常");
                }
            }
        };
        pBt2.setPreferredSize(new Dimension(110, 70));
        pBt2.setFocusPainted(false);
        pBt2.setContentAreaFilled(false);
        pBt2.setBorderPainted(false);
        //给按钮设置监听
        pBt1.addActionListener(this);
        pBt2.addActionListener(this);
        topPanel.add(pBt1);
        topPanel.add(pBt2);
        leftPanel.add(topPanel, BorderLayout.NORTH);
        leftPanel.add(SouthBottomPanel, BorderLayout.SOUTH);
        //链接线程
        bgLabel = new JLabel();
        SouthBottomPanel.add(bgLabel);
//        add(bgLabel);
        LoginThread lt = new LoginThread();
        lt.setBgLabel(bgLabel);
        new Thread(lt).start();
        //设置登陆组件
        accountLabel = new JLabel("幻想账号");
        accountField = new JTextField();
        accountLabel.setFont(font);
        accountField.setPreferredSize(new Dimension(150, 25));
        passwordLabel = new JLabel("密码");
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 25));
        passwordLabel.setFont(font);
        confirmButton = new JButton("登陆");
        //设置登陆监听效果
        confirmButton.addActionListener(this);
        confirmButton.setFont(font);
        confirmButton.setPreferredSize(new Dimension(80, 25));
        confirmButton.setBackground(new Color(114, 46, 211));
        leftPanel.add(accountLabel);
        leftPanel.add(accountField);
        leftPanel.add(passwordLabel);
        leftPanel.add(passwordField);
        leftPanel.add(confirmButton);
        //连接时间线程
        timeLabel = new JLabel();
        Font font1 = new Font("楷体", Font.BOLD, 30);
        timeLabel.setFont(font1);
        leftPanel.add(timeLabel, BorderLayout.WEST);
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pBt1) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\陈宇航\\Pictures\\Java大作业\\服务器"));
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
                        centerPanel.add(imgLabel);
                        leftPanel.add(centerPanel, BorderLayout.CENTER);
                    } catch (IOException e1) {
                        JOptionPane.showConfirmDialog(null, "IO操作异常");
                    }
                }
            }
        }
        //登录效果
        if (e.getSource() == confirmButton) {
            if (accountField.getText().equals("1797262364") && String.valueOf(passwordField.getPassword()).equals("991214")) {
                JOptionPane.showMessageDialog(null, "登陆成功!\n欢迎来到幻想全明星！");
            } else {
                JOptionPane.showMessageDialog(null, "用户名或密码错误!\n请重新登陆！");
                //点击确认后自动清空账号和密码输入框
                accountField.setText("");
                passwordField.setText("");
            }
        }
    }
}