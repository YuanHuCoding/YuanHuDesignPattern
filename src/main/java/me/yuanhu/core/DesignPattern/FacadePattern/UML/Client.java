package me.yuanhu.core.DesignPattern.FacadePattern.UML;

public class Client {
    public static void main(String[] args)
    {
        AbstractFacade facade = new ConcreteFacade();
        facade.Method();
    }
}
