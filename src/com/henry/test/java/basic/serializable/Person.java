package com.henry.test.java.basic.serializable;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -190436735224967822L;

    private String name;
    private transient int age;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override public String toString() {
        return "Person [name=" + name + ", age=" + age + ", desc=" + desc + "]";
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String desc) {
        super();
        this.name = name;
        this.age = age;
        this.desc = desc;
    }
}