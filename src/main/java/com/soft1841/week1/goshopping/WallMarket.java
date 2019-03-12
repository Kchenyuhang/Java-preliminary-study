package com.soft1841.week1.goshopping;

/**
 * 定义一个WallMarket类，继承自Market抽象类，实现其中的shop()抽象方法
 * @author 陈宇航
 * 2019.3.10
 */
public class WallMarket extends Market{
    @Override
    public void shop() {
        System.out.println(name + "实体店购买" + goods);
    }
}
