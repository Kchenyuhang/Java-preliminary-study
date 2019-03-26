package com.soft1841.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFolder {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        java.util.Date currentTime = new java.util.Date();
        String time = format.format(currentTime);
        String path = "D:\\" + time;
        File folder = new File(path + "\\");
        if (!folder.exists()){
            folder.mkdirs();
        }
        File file = new File(folder + "\\" + time);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
