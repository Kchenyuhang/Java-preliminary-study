package com.soft1841.week7;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.43.232",8989);
        InputStream in = socket.getInputStream();
        byte[] b = new byte[1024];
        in.read(b);
        System.out.println("服务器发送的数据是：" + new String(b));
        in.close();
        socket.close();
    }
}
