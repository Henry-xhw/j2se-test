package com.henry.test.java.basic.annotation;


@Report("test")
public class Person {

    @Report(type = 2, level = "test")
    public int age;

    @Range(max = 5)
    public String name;

    public Person() {

    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
