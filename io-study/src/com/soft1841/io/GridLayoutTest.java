package com.soft1841.io;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * GridLayout网格布局示例
 * @author 陈宇航
 * 2019.3.26
 */
public class GridLayoutTest extends JFrame implements ActionListener {
    //定义一个面板数组
    private JPanel panels1,panels2,panels3,panels4,topPanel;
    private JLabel timeLabel;
    private JButton cBtn1;
    private JPanel imgPanel1;
    private TimerTask timeTask;
    private Timer timer;

    private GridLayoutTest() {
        init();
        setTitle("GridLayout网格布局管理器");
        //界面启动最大化
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        //将整个容器背景置为白色
        getContentPane().setBackground(new Color(225, 225, 225));
        //定义三行三列九宫格，放置9个面板
        GridLayout gridLayout = new GridLayout(3, 3, 50, 30);
        setLayout(gridLayout);
        //创建面板数组

        //循环创建每个面板对象
//        for (int i = 0; i < 9; i++) {
//            panels[i] = new JPanel();
//            //面板加上边框
//            panels[i].setBorder(BorderFactory.createTitledBorder("面板" + (i + 1)));
//            //面板依次加入网格布局管理器，变成九宫格
//            add(panels[i]);
//        }

        Container container = new Container();
        container.setLayout(new GridLayout(2,2,10,10));

        //设置第一个面板背景色，其布局方式默认为FlowLayout居中对齐
        panels1 = new JPanel() {
            protected void paintComponent(Graphics g){
                try {
                    Image bg = ImageIO.read(new File("C:\\Users\\陈宇航\\Pictures\\二次元壁纸\\K204.jpg"));
                    g.drawImage(bg,0,0,getWidth(),getHeight(),null);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        };
        panels1.setLayout(new FlowLayout(FlowLayout.CENTER,200,200));
        add(panels1);
        Font font = new Font("微软雅黑",Font.BOLD,22);
        timeLabel = new JLabel();
        timeLabel.setFont(font);
        panels1.add(timeLabel);
        panels1.setBorder(BorderFactory.createTitledBorder("面板1"));

        timeTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeString = sdf.format(date);
                timeLabel.setText(timeString);
                if (timeString.equals("2019-04-16 09:08:40")) {
                    JOptionPane.showConfirmDialog(null, "时间到~~~！");
                    this.cancel();
                }
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(timeTask,0,1000);
//        panels[0].setBackground(new Color(1, 216, 103));
//        //在第一个面板内部加入5个按钮
//        for (int i = 0; i < 5; i++) {
//            panels[0].add(new JButton("按钮" + i));
//        }


        //设置第二个面板为BorderLayout边界布局，设置背景色
        panels2 = new JPanel();
        topPanel = new JPanel();
        cBtn1 = new JButton("选择图片");
        topPanel.add(cBtn1,BorderLayout.NORTH);
        panels2.add(topPanel);
        cBtn1.addActionListener(this);
        imgPanel1 = new JPanel();
        panels2.add(imgPanel1,BorderLayout.CENTER);
        imgPanel1.setBackground(new Color(251, 238, 200));
        add(panels2);

//        panels[1].setLayout(new BorderLayout(20, 20));
//        panels[1].setBackground(new Color(251, 209, 64));
//        //5个方向加入按钮
//        panels[1].add(new JButton("北"), BorderLayout.NORTH);
//        panels[1].add(new JButton("南"), BorderLayout.SOUTH);
//        panels[1].add(new JButton("东"), BorderLayout.EAST);
//        panels[1].add(new JButton("西"), BorderLayout.WEST);
//        panels[1].add(new JButton("中"), BorderLayout.CENTER);


        //设置第三个面板为GridLayout网格布局，设置背景色
//        panels[2].setLayout(new GridLayout(3, 3, 10, 10));
//        panels[2].setBackground(new Color(133, 217, 251));
//        //依次加入9个按钮
//        for (int i = 0; i < 9; i++) {
//            panels[2].add(new JButton(String.valueOf(i + 1)));
//        }


        //设置第四个面板
//        panels[3].setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
//        panels[3].add(new JLabel("应有尽有~~~！"), BorderLayout.CENTER);
//        JPanel jPanel = new JPanel();//创建面板
//        JLabel jLabel = new JLabel("动漫类型：");
//        JComboBox jComboBox = new JComboBox();
//        jComboBox.addItem("——请选择——");
//        jComboBox.addItem("战斗");
//        jComboBox.addItem("校园");
//        jComboBox.addItem("励志");
//        jComboBox.addItem("运动");
//        jComboBox.addItem("恋爱");
//        jPanel.add(jLabel);
//        jPanel.add(jComboBox);
//        jComboBox.setSize(60, 50);
//        panels[3].add(jComboBox, BorderLayout.CENTER);


        //设置第五面板为流式布局，加入滚动面板
//        panels[4].setBackground(new Color(111, 202, 191));
//        //创建文本区域组件，文本默认大小为20行30列
//        JTextArea ta = new JTextArea(10, 30);
//        //创建滚动面板，将文本域放入滚动面板中，
//        panels[4].add(new JScrollPane(ta));


        //设置第六面板为流式布局，加入标签组件
//        panels[5].setBackground(new Color(159, 155, 214));
//        //创建JLabel组件
//        LocalDateTime time = LocalDateTime.now();
//        dateLabel = new JLabel(String.valueOf(time));
//        panels[5].add(dateLabel);


        //设置第七面板为BorderLayout边界布局，加入标签组件
//        panels[6].setLayout(new BorderLayout(20, 20));
//        panels[6].setBackground(new Color(221, 208, 137));
//        //在中部放图片
//        //读入本地图片到到内存的字节数组
//        imgLabel = new JLabel();
//        File srcFile = new File("D:/me.png");
//        InputStream inputStream;
//        byte[] bytes = null;
//        try {
//            inputStream = new FileInputStream(srcFile);
//            bytes = new byte[(int) srcFile.length()];
//            inputStream.read(bytes);
//        } catch (IOException e) {
//            System.out.println("io异常");
//        }
//        icon = new ImageIcon(bytes);
//        imgLabel.setIcon(icon);
//        panels[5].add(imgLabel, BorderLayout.CENTER);
//        //在南部放图片路径
//        String name = srcFile.getPath();
//        nameLabel = new JLabel(name);
//        panels[5].add(nameLabel, BorderLayout.SOUTH);


        //设置第八面板为GirdLayout网格布局，加入单选按钮
//        panels[6].setBackground(new Color(205, 148, 254));
//        panels[6].setLayout(new GridLayout(1, 3, 5, 5));
//        //创建文本为“A”的单选按钮
//        String[] strings = {"first", "second", "third"};
//        for (int i = 0; i < 3; i++) {
//            radioButton = new JRadioButton(strings[i]);
//            panels[6].add(radioButton);
//        }


        //设置第九面板为流式布局，加入文本域组件
//        panels[7].setBackground(new Color(75, 132, 213));
//        //创建6行6列默认值为“文本域，葡萄葡萄”的文本域组件
//        text = new JTextArea("相信奇迹的人，本身和奇迹一样了不起~！",50,50);
//        //可自行换行
//        text.setLineWrap(true);
//        panels[7].add(text);


        //设置第七面板为流式布局，加入密码框组件
//        panels[8].setBackground(new Color(239, 12, 12));
//        String password = "2486";
//        jp = new JPasswordField(password,30);
//        //设置回显字符
//        jp.setEchoChar('*');
//        panels[8].add(jp);
    }

    public static void main(String[] args) {
        //用系统样式替代Swing默认样式，会稍微好看点
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new GridLayoutTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cBtn1) {
            JLabel imgLabel = new JLabel();
            imgPanel1.add(imgLabel);
            ChooseImg1 chooseImg = new ChooseImg1();
            chooseImg.setBgLabel1(imgLabel);
            new Thread(chooseImg).start();
        }
    }
}

class ChooseImg1 implements Runnable {
    private JLabel bgLabel1;
    private JFileChooser fileChooser1;

    public void setBgLabel1(JLabel bgLabel1) {
        this.bgLabel1 = bgLabel1;
    }
    @Override
    public void run() {
        fileChooser1 = new JFileChooser();
        fileChooser1.setCurrentDirectory(new File("C:\\Users\\陈宇航\\Desktop\\自制壁纸资源"));
        fileChooser1.setMultiSelectionEnabled(true);
        int result = fileChooser1.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            //获取选中的所有文件
            File[] files = fileChooser1.getSelectedFiles();
            int i = 0;
            int len = files.length - 1;
            while (true) {
                try {
                    File file = new File(String.valueOf(files[i]));
                    InputStream inputStream = new FileInputStream(file);
                    byte[] bytes = new byte[(int) file.length()];
                    inputStream.read(bytes);
                    Icon icon = new ImageIcon(bytes);
                    bgLabel1.setIcon(icon);
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
