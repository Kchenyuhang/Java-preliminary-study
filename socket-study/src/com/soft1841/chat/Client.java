package com.soft1841.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class  Client extends JFrame implements ActionListener {
    private JTextField textField;
    private JTextArea textArea;
    private JButton startBtn;
    private JButton confirmBtn;
    private JPanel topPanel;
    private Socket socket;
    private String info;

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Client();
    }

    public Client()  {
        init();
        setLocationRelativeTo(null);
        setTitle("客户端");
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        Font font = new Font(null,Font.BOLD,35);

        topPanel = new JPanel();
        confirmBtn = new JButton("发送");
        confirmBtn.setBackground(new Color(73, 156, 84));
        confirmBtn.setPreferredSize(new Dimension(120, 40));
        confirmBtn.addActionListener(this);
        textField = new JTextField();
        textField.setFont(font);
        textField.setPreferredSize(new Dimension(300, 40));
        topPanel.add(textField);
        topPanel.add(confirmBtn);
        add(topPanel, BorderLayout.SOUTH);
        textArea = new JTextArea();
        textArea.setFont(font);
        //文本域设置成不可编辑
        textArea.setEditable(false);
        //文本域设置成不可获得焦点
        textArea.setFocusable(false);
        JScrollPane jScrollPane = new JScrollPane(textArea);
        add(jScrollPane,BorderLayout.CENTER);
        startBtn = new JButton("启动客户端");
        add(startBtn, BorderLayout.NORTH);
        startBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn) {
            try {
                startClient();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == confirmBtn) {
            OutputStream out = null;
            try {
                info="自己："+textField.getText();
                out = socket.getOutputStream();
                out.write(info.getBytes());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    private void startClient() throws IOException {
        socket = new Socket("192.168.43.232",10086);
        read();
    }
    private void read(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream in = null;
                try {
                    while (true){
                        in = socket.getInputStream();
                        byte[] a = new byte[1024];
                        in.read(a);
                        textArea.append(new String(a)+"\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}