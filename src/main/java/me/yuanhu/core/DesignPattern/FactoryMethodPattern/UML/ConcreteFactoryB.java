package me.yuanhu.core.DesignPattern.FactoryMethodPattern.UML;

public class ConcreteFactoryB implements Factory {
    public Product createProduct() {
        return new ConcreteProductB();
    }
}
