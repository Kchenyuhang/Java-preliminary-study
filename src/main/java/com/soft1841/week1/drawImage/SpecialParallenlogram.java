package com.soft1841.week1.drawImage;


/**
 * 特殊的平行四边形
 * @author 陈宇航
 * 2019.3.10
 */
public class SpecialParallenlogram {
    public static void main(String[] args) {
        //接口也可以进行向上转型操作
        DrawImage[] images = {new Rectangle(),new Square(),new Diamond()};
        //遍历“画图形”接口类型的数组
        for (int i = 0; i < images.length; i++) {
            images[i].draw();   //调用draw()方法
        }
    }
}
