package com.soft1841;

import java.util.*;

public class MovieList {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(001,"复仇联盟",35.00));
        movies.add(new Movie(002,"流浪地球",36.00));
        movies.add(new Movie(003,"夏目友人帐",34.00));
        Set<Integer> num = new TreeSet<>();
        num.add(2);
        num.add(1);
        num.add(3);
        Map<Integer,String> map = new HashMap<>();
        System.out.println(movies.get(1).getName());
        Object[] array = num.toArray();
        for (int i = 0, len = array.length; i < len; i++) {
            map.put(Integer.parseInt(array[i].toString()), movies.get(i).getName());
        }
        System.out.println(map);
        System.out.println("**********************电影信息**********************");
        System.out.println("序号\t\t\t\t编号\t\t\t\t电影名\t\t\t\t票价");
        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey() + "\t\t\t\t" + movies.indexOf(entry.getValue()));
            System.out.println();
        }
    }
}
