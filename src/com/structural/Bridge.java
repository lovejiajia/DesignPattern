package com.structural;

/**
 * 桥接模式
 * 定义： 将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 *
 * 将抽象部分（手机）与它的实现部分（手机软件类）分离，将实现部分抽象成单独的类，使它们都可以独立地变化。整个类图看起来像一座桥，所以称为桥接模式
 *
 * 桥接模式通常适用于以下场景。
 * 1.当一个类存在两个独立变化的维度，且这两个维度都需要进行扩展时。
 * 2.当一个系统不希望使用继承或因为多层次继承导致系统类的个数急剧增加时。
 * 3.当一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性时。
 */
public class Bridge {
}

//实现
interface Software {
    public void run();

}
class AppStore implements Software {
    @Override
    public void run() {
        System.out.println("run app store");
    }
}
class Camera implements Software {
    @Override
    public void run() {
        System.out.println("run camera");
    }
}

//抽象
abstract class Phone {

    protected Software software;

    public void setSoftware(Software software) {
        this.software = software;
    }

    public abstract void run();

}
class Oppo extends Phone {
    @Override
    public void run() {
        software.run();
    }
}
class Vivo extends Phone {
    @Override
    public void run() {
        software.run();
    }
}