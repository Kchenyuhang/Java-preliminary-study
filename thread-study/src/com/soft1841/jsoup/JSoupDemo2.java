package com.soft1841.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

/**
 * 爬取https://b.faloo.com页面图片到本地D盘download目录，图片名UUID，后缀jpg
 * @author 陈宇航
 * 2019.4.19
 */
public class JSoupDemo2 {
    public static void main(String[] args) throws Exception {
        File file;
        InputStream in;
        OutputStream out;
        String url = "https://b.faloo.com";
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
//        Element elementDiv = document.getElementById("page-container");
        Elements elements = document.getElementsByClass("m_t4");
        System.out.println(elements.size());
        for (Element e : elements) {
            Element imgElement = e.child(0).child(0);
            UUID uuid = UUID.randomUUID();
            String imgName = uuid + ".jpg";
            file = new File("D:\\download\\" + imgName);
            URL url1 = new URL(imgElement.attr("src"));
            URLConnection uc = url1.openConnection();
            in = uc.getInputStream();
            out = new FileOutputStream(file);
            int temp;
            byte[] buf = new byte[1024];
            while ((temp = in.read(buf)) != -1) {
                out.write(buf, 0, temp);
            }
            out.close();
            in.close();
        }
    }
}
