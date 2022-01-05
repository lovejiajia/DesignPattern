package com.structural;

/**
 * 装饰者模式
 * 定义：动态的将新功能附加到对象上。在对象功能扩展方面，它比继承更有弹性。
 *
 * 1.Component（被装饰对象的基类）
 *    定义一个对象接口，可以给这些对象动态地添加职责。
 * 2.ConcreteComponent（具体被装饰对象）
 *    定义一个对象，可以给这个对象添加一些职责。
 * 3.Decorator（装饰者抽象类）
 *    维持一个指向Component实例的引用，并定义一个与Component接口一致的接口。
 * 4.ConcreteDecorator（具体装饰者）
 *    具体的装饰对象，给内部持有的具体被装饰对象，增加具体的职责。
 * 被装饰对象和修饰者继承自同一个超类
 */

//被装饰的对象和装饰者都继承自同一个超类
abstract class Drink {
    public String description="";
    private float price=0f;;

    public void setDescription(String description)
    {
        this.description=description;
    }

    public String getDescription()
    {
        return description+"-"+this.getPrice();
    }
    public float getPrice()
    {
        return price;
    }
    public void setPrice(float price)
    {
        this.price=price;
    }
    public abstract float cost();
}
//被装饰对象的基类
class Coffee extends Drink {
    @Override
    public float cost() {
        // TODO Auto-generated method stub
        return super.getPrice();
    }
}
//具体被装饰对象
class Decaf extends Coffee {
    public Decaf() {
        super.setDescription("Decaf");
        super.setPrice(3.0f);
    }
}
//装饰者抽象类
public class Decorator extends Drink {
    private Drink Obj;
    public Decorator(Drink Obj) {
        this.Obj = Obj;
    };
    @Override
    public float cost() {
        // TODO Auto-generated method stub
        return super.getPrice() + Obj.cost();
    }
    @Override
    public String getDescription() {
        return super.description + "-" + super.getPrice() + "&&" + Obj.getDescription();
    }
}
//具体装饰者
class Milk extends Decorator {
    public Milk(Drink Obj) {
        super(Obj);
        // TODO Auto-generated constructor stub
        super.setDescription("Milk");
        super.setPrice(2.0f);
    }
}

class CoffeeBar {
    public static void main(String[] args) {
        Drink order;
        order = new Decaf();
        System.out.println("order1 price:" + order.cost());
        System.out.println("order1 desc:" + order.getDescription());
        System.out.println("****************");
        order = new Milk(order);
        System.out.println("order2 price:" + order.cost());
        System.out.println("order2 desc:" + order.getDescription());
    }
}