package com.henry.test.java.design.pattern.observer.geekbang.basic.code;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    @Override public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override public void notifyObserver(Message message) {
        observers.forEach(observer -> observer.update(message));
    }
}
