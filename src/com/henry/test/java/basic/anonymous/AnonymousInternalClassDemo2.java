package com.henry.test.java.basic.anonymous;

public class AnonymousInternalClassDemo2 {

    private transient Object[] elements;
    {
        Thread thread = new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("hello world!");
            }
        });
    }

    // anonymous class can be in constructor -----3
    public AnonymousInternalClassDemo2() {
        Thread thread2 = new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("hello world!");
            }
        });
    }

    // anonymous class can be in static method ----4
    private static void staticMethod () {
        Thread thread3 = new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("hello world!");
            }
        });
    }

    // anonymous class can be in non-static method(instance method) ----5
    public void instanceMethod () {
//        Thread thread4 = new Thread(new Runnable() {
//            @Override public void run() {
//                System.out.println("hello world!");
//            }
//        });
        System.out.println(this);
        new Runnable() {

            @Override public void run() {

                System.out.println(this);
            }
        }.run();
    }

    public static void main(String[] args) {
        AnonymousInternalClassDemo2 demo2 = new AnonymousInternalClassDemo2();
        System.out.println(demo2);
        demo2.instanceMethod();
    }

    private class Test {
        private void println() {
            System.out.println(elements.length);
        }
    }
}
