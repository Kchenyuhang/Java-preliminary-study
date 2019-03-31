package com.soft1841.week4;

import java.io.File;
import java.io.IOException;


/**
 * 遍历文件夹
 * @author 陈宇航
 * 2019.4.1
 */

public class FolderTest extends IOException {
    public static void main(String[] args) {
        //要遍历的路径
        String path = "D:\\image";
        //获取其file对象
        File file = new File(path);
        //遍历path下的文件和目录，放在File数组中
        File[] fs = file.listFiles();
        //遍历File[]数组
        for (File f : fs) {
            //若非目录（即文件），则打印
            if (!f.isDirectory()) {
                System.out.println(f);
            }
        }
    }
}
