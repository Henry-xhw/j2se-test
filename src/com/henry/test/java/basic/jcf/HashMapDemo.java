package com.henry.test.java.basic.jcf;

import com.henry.test.java.basic.hash.People;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {


//        showMapCannotMakeSureOrder();
        showMapHashProcessing();
    }

    private static void showMapAllowNull() {
        Map<String, Integer> map = new HashMap<>();
        map.put(null, null);
        map.put(null, null);
        map.put(null, null);
        map.put(null, null);
        System.out.println(map.size());
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    private static void showMapCannotMakeSureOrder() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "henry");
        map.put(2, "yuzi");
        map.put(3, "youyou");
        map.put(4, "zuozuo");

        map.forEach((k, v) -> System.out.println(k + " : " + v));

        map.put(5, "xixi");
        System.out.println("-------------------------");
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    private static void showMapHashProcessing() {

        Map<People, String> map = new HashMap<>();
        People p1 = new People("henry", 39);
        People p2 = new People("henry", 39);
        People p3 = new People("yuzi", 38);
        map.put(p1, "henry");
        map.put(p2, "henry");
        map.put(p3, "yuzi");

        map.forEach((k, v) -> System.out.println(k + " : " + v));

        String oldValue = map.put(p1, "henry-put-test");
        System.out.println(p1.getHashCode() + " : old value： " + oldValue);
        System.out.println("-------------------------");
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
