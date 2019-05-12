package com.soft1841.socket;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientFrame extends JFrame {
    private JButton enterBtn;
    private JLabel messageLabel;
    private JScrollPane scrollPane;

    public ClientFrame() {
        init();
        setTitle("聊天界面二");
        setBounds(350, 150, 1280, 720);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {

    }

    public static void main(String[] args) throws IOException {
        new ClientFrame();
        Socket client = new Socket("192.168.43.232",12580);
        System.out.println("成功连接上服务器");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String string = bufferedReader.readLine();
        System.out.println("服务器端输出内容：" + string);
        bufferedReader.close();
        client.close();
    }
}
