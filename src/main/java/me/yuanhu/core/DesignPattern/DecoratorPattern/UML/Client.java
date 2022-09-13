package me.yuanhu.core.DesignPattern.DecoratorPattern.UML;

public class Client {
    public static void main(String args[]) {
        Component component, componentA, componentB;  //使用抽象构件定义
        component = new ConcreteComponent(); //定义具体构件
        componentA = new ConcreteDecoratorA(component); //定义装饰后的构件
        componentB=new ConcreteDecoratorB(componentA);
        componentB.operation();
    }
}
