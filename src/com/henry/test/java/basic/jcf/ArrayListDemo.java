package com.henry.test.java.basic.jcf;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
//        showArrayListSet();
        showArrayListAllowNull();
    }

    private static void showArrayListSet() {
        List<String> list = new ArrayList<>(1);
        list.add("abc");
        // compile issue
//        list.add(123);
        list.add("henry");
        list.add("efg");
        list.forEach(System.out::println);
        System.out.println(list.set(1, "xxxxx"));
        System.out.println("------------------------");
        list.forEach(System.out::println);


    }

    private static void showArrayListAllowNull() {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list.size());
        list.forEach(System.out::println);
    }

    private static void showArrayListRemove() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove(1);

    }
}
