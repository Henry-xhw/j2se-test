package com.henry.test.java.basic.hash;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class People {

    private String name;
    private int age;
    @Setter
    @Getter
    private int hashCode;

    public People(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return this.name.equals(((People)obj).name) && this.age== ((People)obj).age;
    }

    @Override public String toString() {
        return "People{" + "name='" + name + '\'' + ", age=" + age + ", hashcode=" + this.hashCode() + '}';
    }

//    @Override
//    public int hashCode() {
//        int hashCode = super.hashCode();
//        this.setHashCode(hashCode);
//        return getHashCode();
//    }

    //重写hashCode, 使得当name相同，并且age相同时，表示的是同一个人(对象)
    @Override
    public int hashCode() {
        return name.hashCode()*37 + age;

    }
    public static void main(String[] args) {
        People p1 = new People("Jack", 12);
        System.out.println("p1.hashCode: " + p1.hashCode());

        HashMap<People, Integer> hashMap = new HashMap<People, Integer>();
        hashMap.put(p1, 1);

        People p2 = new People("Jack", 12);
        System.out.println("p2.hashCode: " + p2.hashCode());
            System.out.println(hashMap.get(p2));
    }
}
