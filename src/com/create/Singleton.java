package com.create;

/** 单例模式
 * 预加载只有一条语句return instance,这显然可以保证线程安全。但是，我们知道预加载会造成内存的浪费。
 * 懒加载不浪费内存，但是无法保证线程的安全。首先，if判断以及其内存执行代码是非原子性的。其次，new Singleton()无法保证执行的顺序性。
 *
 */
public class Singleton {

}

//预加载
class Prestrain{
    public static Prestrain prestrain = new Prestrain();

    //其他的类无法实例化单例类的对象
    private Prestrain(){
    }

    public static Prestrain getPrestrain(){
        return prestrain;
    }
}

//懒加载
class SingletonLazy {
    private static SingletonLazy instance = null;

    //其他的类无法实例化单例类的对象
    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}

//懒加载(线程安全处理)
/**
 * 创建对象步骤
 * 1.memory=allocate();//1:初始化内存空间
 * 2.ctorInstance(memory);//2:初始化对象
 * 3.instance=memory();//3:设置instance指向刚分配的内存地址
 * 线程安全步骤
 * 1.synchronized加载getInstace()函数上确实保证了线程的安全
 * 2.new一个对象的代码是无法保证顺序性的，因此，我们需要使用另一个关键字volatile保证对象实例化过程的顺序性。
 */
class Lazy {
    private static volatile Lazy instance = null;

    //其他的类无法实例化单例类的对象
    private Lazy() {
    }

    public static Lazy getInstance() {
        if (instance == null) {
            //保证instance未实例化的时候才加锁
            synchronized (Lazy.class) {
                instance = new Lazy();
            }
        }
        return instance;
    }
}
