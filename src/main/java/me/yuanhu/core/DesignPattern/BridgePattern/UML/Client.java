package me.yuanhu.core.DesignPattern.BridgePattern.UML;

public class Client {
    public static void main(String args[])
    {
        Abstraction image;
        Implementor imp;
        image = (Abstraction)XMLUtil.getBean("Abstraction");
        imp = (Implementor)XMLUtil.getBean("Implementor");
        image.setImpl(imp);
        image.operation();
    }
}
