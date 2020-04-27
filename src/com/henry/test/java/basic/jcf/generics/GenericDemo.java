package com.henry.test.java.basic.jcf.generics;

import java.util.ArrayList;
import java.util.Iterator;

// can create type parameter E in class level
//public class GenericDemo<E> {
public class GenericDemo {

    public static void main(String[] args) {
        showGeneric();
    }

    private static void showBeforeGeneric() {
        //JDK 1.4 or before
        ArrayList list = new ArrayList();
        list.add(new String("Monday"));
        list.add(new String("Tuesday"));
        list.add(new String("Wensday"));
        for(int i = 0; i < list.size(); i++){
            String weekday = (String) list.get(i);//显式类型转换
            System.out.println(weekday.toUpperCase());
        }
    }

    private static void showGeneric() {
        //JDK 1.5 or latter
        ArrayList<String> list = new ArrayList<String>();//参数化类型
        list.add(new String("Monday"));
        list.add(new String("Tuesday"));
        list.add(new String("Wensday"));
        for(int i = 0; i < list.size(); i++){
            String weekday = list.get(i);//隐式类型转换，编译器自动完成
            System.out.println(weekday.toUpperCase());
        }
    }

    private static void showIterator() {
        //visit a list with iterator
        ArrayList<String> list = new ArrayList<String>();
        list.add(new String("Monday"));
        list.add(new String("Tuesday"));
        list.add(new String("Wensday"));
        Iterator<String> it = list.iterator();//得到迭代器
        while(it.hasNext()){
            String weekday = it.next();//访问元素
            System.out.println(weekday.toUpperCase());
        }
    }

    private static void showIteratorWithEnhancedForStatement() {
        //使用增强for迭代
        ArrayList<String> list = new ArrayList<String>();
        list.add(new String("Monday"));
        list.add(new String("Tuesday"));
        list.add(new String("Wensday"));
        for(String weekday : list){//enhanced for statement
            System.out.println(weekday.toUpperCase());
        }

    }

    private <E> E get(Object[] objs, int index) {
        Object[] objects = objs;
        return (E) objects[index];
    }

    private <E> E get2(Object[] objs, int index) {
        Object[] objects = objs;
        return (E) objects[index];
    }

}
