package com.soft1841.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client3 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("192.168.43.232",12580);
        System.out.println("成功连接上服务器");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String string = bufferedReader.readLine();
        System.out.println("服务器端输出内容：" + string);
        bufferedReader.close();
        client.close();
    }
}
