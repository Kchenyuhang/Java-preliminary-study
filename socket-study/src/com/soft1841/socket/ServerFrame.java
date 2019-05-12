package com.soft1841.socket;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFrame extends JFrame {
    private JButton enterBtn;
    private JLabel messageLabel;
    private JScrollPane scrollPane;

    public ServerFrame() {
        init();
        setTitle("聊天界面一");
        setBounds(350, 150, 1280, 720);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {

    }

    public static void main(String[] args) throws IOException {
        new ServerFrame();
        ServerSocket serverSocket = new ServerSocket(12580);
        System.out.println("服务器启动...");
        while (true){
            Socket socket = serverSocket.accept();
            ServerThread3 server = new ServerThread3(socket);
            new Thread(server).start();
        }
    }
    static class ServerThread3 implements Runnable{
        private Socket socket;

        public ServerThread3(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("客户端" + socket.getInetAddress() + "连接成功");
            String info = "这是一条服务器通知";
            OutputStream outputStream = null;
            try {
                outputStream = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintStream printStream = new PrintStream(outputStream);
            printStream.print(info);
            printStream.close();
        }
    }
}

