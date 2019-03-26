package com.soft1841.io;

import java.io.*;
import java.util.Scanner;

/**
 * 控制台输如的内容存入文件
 * @author 陈宇航
 * 2019.3.26
 */
public class TxtWriter {
    public static void main(String[] args) throws IOException {
//        String str = "King星辰";
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要输入文件的内容：");
        String inputString = scanner.nextLine();
        byte[] bytes = inputString.getBytes();
        File destFile = new File("D:\\测试.txt");
        OutputStream out = new FileOutputStream(destFile);
        out.write(bytes);
        out.close();
    }
}
