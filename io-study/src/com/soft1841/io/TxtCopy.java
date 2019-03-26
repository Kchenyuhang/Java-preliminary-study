package com.soft1841.io;

import java.io.*;

/**
 * 文本复制操作
 * @author 陈宇航
 * 2019.3.26
 */
public class TxtCopy {
    public static void main(String[] args) throws IOException {
        //指定源文件
        File srcFile = new File("D:\\hello11.txt");
        if (srcFile.exists()) {
            File destFile = new File("D:\\hello副本.txt");
            Reader in = new FileReader(srcFile);
            char[] chars = new char[(int) srcFile.length()];
            in.read(chars);
            Writer out = new FileWriter(destFile);
            out.write(chars);
            in.close();
            out.close();
        } else {
            System.out.println("该文件不存在！");
        }
    }
}
