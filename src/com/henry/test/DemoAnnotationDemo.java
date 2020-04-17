package com.active.henry.java;

@DemoAnnotation(value = "henry")
public class DemoAnnotationDemo {

    public static void main(String[] args) {
        DemoAnnotation demoAnnotation = com.active.henry.java.DemoAnnotationDemo.class.getAnnotation(DemoAnnotation.class);
        System.out.println(demoAnnotation.value());
    }
}
