package com.soft1841.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程的服务端
 * @author 陈宇航
 * 2019.5.7
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1214);
        System.out.println("服务器启动成功");
        while (true) {
            Socket socket = ss.accept();
            ServerThread serverThread = new ServerThread();
            serverThread.setSocket(socket);
            Thread thread = new Thread(serverThread);
            thread.start();
        }
    }
}

class ServerThread implements Runnable {
    private Socket socket;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println(socket.getInetAddress()+"客户端连接成功");
    }
}
