package me.yuanhu.core.DesignPattern.CommandPattern.UML;

public class Client {
    public static void main(String args[]) {
        Invoker invoker = new Invoker();
        invoker.setCommand(new ConcreteCommand());
        invoker.call();
    }
}
