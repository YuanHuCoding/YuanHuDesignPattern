package me.yuanhu.core.DesignPattern.AbstractFactoryPattern.UML;

public class Client {
    public static void main(String args[]) {
        AbstractFactory factory;
        AbstractProductA productA;
        AbstractProductB productB;
        factory = new ConcreteFactory1();
        productA = factory.createProductA();
        productB = factory.createProductB();
        productA.sendMSG();
        productB.sendMSG();
    }
}
