package com.soft1841.week2;

import java.util.ArrayList;
import java.util.List;

public class BookListTest {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1,"《钢铁是怎样炼成的》",30.00));
        list.add(new Book(2,"《老人与海》",25.00));
        list.add(new Book(3,"《汤姆索亚历险记》",20.00));
        System.out.println(list);
        list.add(2,new Book(4,"《Java》",35.00));
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.set(2,new Book(5,"《三国演义》",24.55));
        System.out.println(list);
        System.out.println(list.get(1));
        list.add(new Book(4,"《西游记》",25.55));
        System.out.println(list);
        System.out.println(list.indexOf("《老人与海》"));
        System.out.println(list.lastIndexOf("《Java》"));
    }
}
