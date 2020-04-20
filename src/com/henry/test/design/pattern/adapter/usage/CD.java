package com.henry.test.design.pattern.adapter.usage;

import lombok.Data;

import java.util.Date;

public class CD {//这个类来自外部sdk，我们无权修改它的代码

    //...
    public static void staticFunction1() { //...

    }

    public void uglyNamingFunction2() { //...
    }

    public void tooManyParamsFunction3(String paramA, Date paramB) { //...

    }

    public void lowPerformanceFunction4() { //...
    }

}

// 使用适配器模式进行重构
interface ITarget {
    void function1();
    void function2();
    void function3(ParamsWrapperDefinition paramsWrapper);
    void function4();
    //...
}

@Data
class ParamsWrapperDefinition {
    private String name;
    private Date date;
}

// 注意：适配器类的命名不一定非得末尾带Adaptor (类继承的方式)
class CDAdaptor extends CD implements ITarget {
    //...
    public void function1() {
        super.staticFunction1();
    }

    public void function2() {
        super.uglyNamingFunction2();
    }

    public void function3(ParamsWrapperDefinition paramsWrapper) {
        super.tooManyParamsFunction3(paramsWrapper.getName(), paramsWrapper.getDate());
    }

    public void function4() {
        //...reimplement it...
    }
}

// 对象组合的方式
class CDAdaptor2 implements ITarget {

    private CD cd;
    public CDAdaptor2 (CD cd) {
        this.cd = cd;
    }

    @Override public void function1() {
        CD.staticFunction1();
    }

    @Override public void function2() {
        cd.uglyNamingFunction2();
    }

    @Override public void function3(ParamsWrapperDefinition paramsWrapper) {
        cd.tooManyParamsFunction3(paramsWrapper.getName(), paramsWrapper.getDate());
    }

    @Override public void function4() {

    }
}