package com.create;

/**
 * 工厂模式
 * 定义:定义了一个创建对象的抽象方法，由子类决定要实例化的类。工厂方法模式将对象的实例化推迟到子类
 */
public abstract class Factory {
    abstract void create();
}

class A extends Factory{
    @Override
    void create() {
        System.out.println("A");
    }
}

class B extends Factory{
    @Override
    void create() {
        System.out.println("B");
    }
}

class test{
    public static void main(String[] args) {
        Factory a = new A();
        a.create();
    }
}