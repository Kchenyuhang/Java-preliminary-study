package com.soft1841.week4;


import java.io.*;

/**
 * 以字节为单位进行输入\输出
 * @author 陈宇航
 * 2019.4.3
 */
public class BufferedStreamTest {
    public static void main(String[] args) {
        //定义字符串数组
        String content[] = {"木叶飞舞之处，","火亦生生不息！\n","樱花满地集于我心，","楪舞纷飞祈愿相随！"};
        File file = new File("D:\\word.txt");
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            byte[] bContent = new byte[1024];
            for (int k = 0;k < content.length;k++){
                bContent = content[k].getBytes();
                bos.write(bContent);
            }
            System.out.println("写入成功！\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            byte[] bContent = new byte[1024];
            int len = bis.read(bContent);
            //输出文件数据
            System.out.println("文件中的信息是：" + new String(bContent,0,len));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
