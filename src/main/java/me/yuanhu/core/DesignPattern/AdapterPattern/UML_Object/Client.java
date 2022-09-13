package me.yuanhu.core.DesignPattern.AdapterPattern.UML_Object;

public class Client {
    public static void main(String args[]) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.request();
    }
}
