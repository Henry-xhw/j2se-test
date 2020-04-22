package com.henry.test.design.pattern.decorator.geekbang;
// 代理模式的代码结构(下面的接口也可以替换成抽象类)
public interface IA {
    void f();
}
class A implements  IA {

    @Override public void f() {

    }
}

class AProxy implements IA {
    private IA a;
    public AProxy (IA a) {
        this.a = a;
    }

    @Override public void f() {
        // 新添加的代理逻辑
        a.f();
        // 新添加的代理逻辑
    }
}

// 装饰器模式的代码结构(下面的接口也可以替换成抽象类)
interface IB {
    void f();
}

class B implements IB {

    @Override public void f() {

    }
}

class BDecorator implements IB {
    private IB b;
    public BDecorator(IB b) {
        this.b = b;
    }
    @Override public void f() {
        // 功能增强代码
        b.f();
        // 功能增强代码
    }
}