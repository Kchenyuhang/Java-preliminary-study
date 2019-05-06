package com.soft1841.week7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        while (true) {
            Socket socket = new Socket("192.168.43.232",1214);
//        InputStream in = socket.getInputStream();
//        byte[] b = new byte[1024];
//        in.read(b);
//        System.out.println("服务器发送的数据是：" + new String(b));
//        in.close();
////        socket.close();
            OutputStream out = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入要发给服务器的内容：");
            String info = scanner.nextLine();
            out.write(info.getBytes());
            out.close();
            socket.close();

            Socket socket1 = new Socket("192.168.43.232",1214);
            InputStream in = socket1.getInputStream();
            byte[] b = new byte[1024];
            in.read(b);
            System.out.println("服务器发送的内容是：" + new String(b));
//        in.close();
            socket.close();
        }

    }
}
