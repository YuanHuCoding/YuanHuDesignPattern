package me.yuanhu.core.DesignPattern.AbstractFactoryPattern.UML;

public class ConcreteFactory1 extends AbstractFactory {
    //工厂方法一
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    //工厂方法二
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }

}
