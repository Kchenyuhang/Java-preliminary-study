package com.soft1841.week7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1214);
        System.out.println("服务器启动");
//
//        OutputStream out;
//        System.out.println("请输入要发给客户端的内容：");
//        String info = scanner.nextLine();
        while (true) {
            Socket socket = ss.accept();
            System.out.println("客户端" + socket.getInetAddress() + "上线了");
            InputStream in = socket.getInputStream();
            byte[] b = new byte[1024];
            in.read(b);
            System.out.println("客户端" + socket.getInetAddress() + "发送了：" + new String(b));
//            in.close();


            Socket socket1 = ss.accept();
            OutputStream out = socket1.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入要发给客户端的内容：");
            String info = scanner.nextLine();
            out.write(info.getBytes());
            out.close();
            socket.close();
        }
    }
}
