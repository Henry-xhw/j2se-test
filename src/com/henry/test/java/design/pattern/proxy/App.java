package com.henry.test.java.design.pattern.proxy;

public class App {
    public static void main(String[] args) {
        WizardTower proxy = new WizardTowerProxy(new IvoryTower());
        proxy.enter(new Wizard("henry"));
        proxy.enter(new Wizard("yuzi"));
        proxy.enter(new Wizard("youyou"));
        proxy.enter(new Wizard("zuozuo"));
    }
}
