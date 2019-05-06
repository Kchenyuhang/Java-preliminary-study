package com.soft1841.week7;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8989);
        System.out.println("服务器启动");
        OutputStream out;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要发给客户端的内容：");
        String info = scanner.nextLine();
        while (true) {
            Socket socket = ss.accept();
            System.out.println(socket.getInetAddress() + "上线了");
            out = socket.getOutputStream();
            out.write(info.getBytes());
            out.close();
            socket.close();
        }
    }
}
