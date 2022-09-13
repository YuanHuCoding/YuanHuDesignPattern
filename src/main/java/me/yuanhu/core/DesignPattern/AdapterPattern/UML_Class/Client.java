package me.yuanhu.core.DesignPattern.AdapterPattern.UML_Class;

public class Client {
    public static void main(String args[]) {
        Target adapter = new Adapter();
        adapter.request();
    }
}
