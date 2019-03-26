package com.soft1841.io;


import java.io.*;
import java.util.UUID;

/**
 * 文件复制
 * @author 陈宇航
 * 2019.3.26
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        //指定原文件
        File srcFile = new File("D:\\me.png");
        String srcFileName = srcFile.getName();
        int position = srcFileName.indexOf(".");
        //获取源文件的扩展名
        String suffixName = srcFileName.substring(position + 1);
        //新的主文件名
        String newName = UUID.randomUUID().toString();
        //指定目标文件
        File destFile = new File("D:\\" + newName + "." + suffixName);
        //创建一个字节数组，大小为源文件长度，长度转成int
        byte[] bytes = new byte[(int) srcFile.length()];
        //创建字节输入流
        InputStream in = new FileInputStream(srcFile);
        //将源文件读入字节数组
        in.read(bytes);
        //创建字节输出流
        OutputStream out = new FileOutputStream(destFile);
        //将字节数组输出到目标文件
        out.write(bytes);
        in.close();
        out.close();
    }

}
