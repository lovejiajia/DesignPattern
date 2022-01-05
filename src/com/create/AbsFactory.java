package com.create;

/**
 * 抽象工厂模式
 * 定义：定义了一个接口用于创建相关或有依赖关系的对象族，而无需明确指定具体类。
 */
public interface AbsFactory {
    void create();
}

class A1 implements AbsFactory{

    @Override
    public void create() {
        System.out.println("A");
    }
}

class B1 implements AbsFactory{

    @Override
    public void create() {
        System.out.println("B");
    }
}