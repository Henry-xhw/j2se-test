package com.henry.test.design.pattern.adapter;

// 类适配器: 基于继承
public class Adaptor extends Adaptee implements  ITarget {
    @Override public void f1() {
        super.fa();
    }

    @Override public void f2() {

    }
}