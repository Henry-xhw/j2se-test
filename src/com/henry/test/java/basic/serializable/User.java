package com.henry.test.java.basic.serializable;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private Integer age;

    private static final long serialVersionUID = 1L;
    private transient boolean man;
    private static String signature = "我的眼里只有你";
//
//
    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static String getSignature() {
        return signature;
    }

    public static void setSignature(String signature) {
        User.signature = signature;
    }

    //    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }


//        @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", man=" + man +
//                '}';
//    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", man=" + man +
                ", signature=" + signature +
                '}';
    }
}