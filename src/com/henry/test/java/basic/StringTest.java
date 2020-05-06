package com.henry.test.java.basic;

public class StringTest {
    public static void main(String[] args) {
//        String str = "henry" + "yuzi" + "youyou" + "zuozuo";
//        System.out.println(str);
        testString();
    }


        public static String concat() {
            return "henry" + "yuzi" + "youyou" + "zuozuo";
    }

    public static String concat(String str) {
        return str + "henry" + "yuzi" + "youyou" + "zuozuo";
    }

    public static void testString() {
        String str = "henry";
        String str2 = "henry";
        String str3 = "henry3";
        System.out.println(str == str2);
        System.out.println(str2 == str3);
    }
}
