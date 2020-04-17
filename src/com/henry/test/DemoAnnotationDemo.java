package com.henry.test;

@com.active.henry.java.DemoAnnotation(value = "henry")
public class DemoAnnotationDemo {

    public static void main(String[] args) {
        com.active.henry.java.DemoAnnotation demoAnnotation = DemoAnnotationDemo.class.getAnnotation(
            com.active.henry.java.DemoAnnotation.class);
        System.out.println(demoAnnotation.value());
    }
}
