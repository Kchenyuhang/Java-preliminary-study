package com.soft1841.week5;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 读取网络图片
 * @author 陈宇航
 * 2019.4.9
 */
public class GetImageByNet extends Object implements Runnable {
    public static void main(String[] args) {
        GetImageByNet getImageByNet = new GetImageByNet();
        getImageByNet.run();
    }
    @Override
    public void run() {
        try {
            //新建一个URL对象
            URL url = new URL("https://i0.hdslb.com/bfs/album/fc1bf70c9f7e51bd7d982694370e9f2b8e5abd1c.jpg");
            //打开链接
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //设置请求方式为"GET"
            conn.setRequestMethod("GET");
            //超时响应为5秒
            conn.setConnectTimeout(5 * 1000);
            //通过输入流获取图片数据
            InputStream instream = conn.getInputStream();
            //得到图片的二进制数据，以二进制封装得到数据，具有通用性
            ByteArrayOutputStream out1 = new ByteArrayOutputStream();
            //准备缓冲字节数组
            byte[] buffer = new byte[1024];
            int len = 0;
            //每次读入一个缓冲区大小的字节数
            while ((len = instream.read(buffer)) != -1){
                //将缓冲区内容写出
                out1.write(buffer,0,len);
            }
            instream.close();
            //通过输出流获取到字节数组
            byte[] date = out1.toByteArray();
            //new一个文件对象来保存图片，默认保存到当前工程根目录
            File imageFile = new File("D:\\1.jpg");
            //创建输出流
            OutputStream out2 = new FileOutputStream(imageFile);
            //写入数据
            out2.write(date);
            out2.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
