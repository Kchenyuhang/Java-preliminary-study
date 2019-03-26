package com.soft1841.io;

import java.io.File;

public class FolderTest {
    public static void main(String[] args) {
        String path = "D:\\Java";
        for (int i = 0; i <= 10; i++){
            File folder = new File(path + "\\" + "chap" +i);
            if (!folder.exists()){
                folder.mkdirs();
            }
        }
    }
}
