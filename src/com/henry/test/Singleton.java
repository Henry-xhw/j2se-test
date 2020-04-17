package com.henry.test;

public class Singleton {
    private static volatile com.active.henry.java.Singleton instance = null;
    private Singleton() {

    }
    public static com.active.henry.java.Singleton getInstance() {
        if (instance == null) {
            synchronized (com.active.henry.java.Singleton.class) {
                if (instance == null) {
                    instance = new com.active.henry.java.Singleton();
                }
            }
        }
        return instance;
    }
}
