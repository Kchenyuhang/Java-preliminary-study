package com.soft1841;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        //创建目录
       File path = new File("D:\\");
       if (!path.exists()) {
           path.mkdirs();
       }
       //在上述目录里创建文件
        File file = new File(path + "\\" + "today.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

    }
}
