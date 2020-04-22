package com.henry.test.design.pattern.observer.geekbang.basic.code;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(Message message);
}
