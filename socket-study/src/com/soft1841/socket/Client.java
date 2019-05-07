package com.soft1841.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.40.185.78",1214);
        System.out.println(socket.getInetAddress() + "连接成功");
    }

}
