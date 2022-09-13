package me.yuanhu.core.DesignPattern.StatePattern.UML;

public class Client {
    public static void main(String args[]) {
        Context context = new Context();
        context.setValue(0);
        context.request();
        context.setValue(1);
        context.request();
    }
}
