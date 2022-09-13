package me.yuanhu.core.DesignPattern.FactoryMethodPattern.UML;

public class ConcreteProductA implements Product {
    @Override
    public void sendMSG() {
        System.out.println("ConcreteProductA");
    }
}
