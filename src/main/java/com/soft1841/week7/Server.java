package com.soft1841.week7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器对象，映射端口10086
        ServerSocket ss = new ServerSocket(10086);
        System.out.println("服务器启动，端口号：" + ss.getLocalPort());
        while (true) {
            //获得和客户端对象的连接
            Socket socket = ss.accept();
            System.out.println("客户端：" + socket.getInetAddress() + "上线了");
            socket.close();
        }
    }
}
