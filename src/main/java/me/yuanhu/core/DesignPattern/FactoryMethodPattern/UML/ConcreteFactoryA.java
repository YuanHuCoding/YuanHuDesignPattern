package me.yuanhu.core.DesignPattern.FactoryMethodPattern.UML;

//ConcreteFactoryA（具体工厂）：它是抽象工厂类的子类，实现了抽象工厂中定义的工厂方法，并可由客户端调用，返回一个具体产品类的实例。
public class ConcreteFactoryA implements Factory {
    public Product createProduct() {
        return new ConcreteProductA();
    }
}
