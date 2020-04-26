package com.henry.test.java.basic.anonymous;

import java.util.function.Consumer;

public class LambdaDemo {
    {
        Thread thread = new Thread(() -> System.out.println("hello world!"));
    }

    // anonymous class can be in constructor -----3
    public LambdaDemo() {
        Thread thread2 = new Thread(() -> System.out.println("hello world!"));
    }

    // anonymous class can be in static method ----4
    private static void staticMethod () {
        Thread thread3 = new Thread(() -> System.out.println("hello world!"));
    }

    private static <T> void staticMethod (Consumer<T> consumer, T t) {
//        Thread thread3 = new Thread(() -> System.out.println("hello world!"));
        consumer.accept(t);
    }

    // anonymous class can be in non-static method(instance method) ----5
    public void instanceMethod () {
        Thread thread4 = new Thread(() -> System.out.println("hello world!"));
    }

    public static void main(String[] args) {
//        staticMethod(System.out::println, "hello world");
        LambdaDemo lambdaDemo = new LambdaDemo();
        System.out.println(lambdaDemo);
        lambdaDemo.testThisInLambda("efg");
    }

    public void testThisInLambda(String str) {
        System.out.println(this);
        Consumer<String> consumer = a -> {
            System.out.println(this);
            System.out.println(a);
            System.out.println(str);
        };
        consumer.accept("abc");
    }
}
