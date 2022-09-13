package me.yuanhu.core.DesignPattern.TemplateMethodPattern.UML;

public class Client {
    public static void main(String args[])
    {
        AbstractClass abstractClass = new ConcreteClassA();
        abstractClass.TemplateMethod();
    }
}
