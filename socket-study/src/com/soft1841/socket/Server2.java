package com.soft1841.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8989);
        System.out.println("服务器启动...");
        Socket socket;
        while (true) {
            socket = serverSocket.accept();
            ServerThread2 server = new ServerThread2(socket);
            new Thread(server).start();
        }
    }
}

class ServerThread2 implements Runnable{
    private Socket socket;

    public ServerThread2(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        System.out.println("客户端" + socket.getInetAddress() + "连接成功！");
        try {
            //从客户端的输入流中读
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            //写到服务器指定路径
            File file = new File(UUID.randomUUID().toString() + ".jpg");
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            //缓冲区
            byte[] data = new byte[1024];
            int tmp;
            while ((tmp = bis.read(data)) != -1) {
                bos.write(data,0,tmp);
            }
            bos.close();
            bis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
