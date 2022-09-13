package me.yuanhu.core.DesignPattern.AdapterPattern.UML_Default;

public class Client {
    public static void main(String args[]) {
        ServiceInterface serviceInterface = new ConcreteServiceClass();

        serviceInterface.method1();
        serviceInterface.method2();
    }
}
