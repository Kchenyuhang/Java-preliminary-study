package com.soft1841.week2;

import java.util.ArrayList;
import java.util.List;

public class ListBallTest {
    public static void main(String[] args) {
        List<ListBall> ballList = new ArrayList<>();
        ballList.add(new ListBall("乔丹","飞人/神",30.1,6.2,5.3));
        ballList.add(new ListBall("拉塞尔","指环王",15.1,22.5,4.3));
        ballList.add(new ListBall("贾巴尔","天钩",24.6,11.2,3.6));
        System.out.println("--------NBA历史十大巨星--------");
        System.out.println("球员      绰号      得分    篮板    助攻");
        for (int i = 0,len = ballList.size();i < len; i++) {
            System.out.print(ballList.get(i).getName() + "     " + ballList.get(i).getNickname() +
                    "    " + ballList.get(i).getScore() + "     " + ballList.get(i).getRebounds() + "    " + ballList.get(i).getAssists());
            System.out.println();
        }
    }
}
