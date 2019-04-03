package com.soft1841.week4;

import java.io.*;

/**
 * 以行为单位进行输入/输出
 * @author 陈宇航
 * 2019.4.4
 */
public class BufferedTest {
    public static void main(String[] args) {
        String content[] = {"总有几个走夜路的人，","感谢照亮荒野的月亮，","虽然月亮不能带来温暖，","却能带来希望。"};
        File file = new File("Article.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            //创建BufferedWriter类对象
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int k = 0; k < content.length; k ++){
                bufferedWriter.write(content[k]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader(file);
            //创建BufferedReader类对象
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string = null;
            int i = 0;
            //如果文本行数不为null，则进入循环
            while ((string = bufferedReader.readLine()) != null){
                i ++;
                System.out.println("第" + i + "行:" + string);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
