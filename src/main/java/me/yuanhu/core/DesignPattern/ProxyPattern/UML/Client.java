package me.yuanhu.core.DesignPattern.ProxyPattern.UML;

public class Client {
    public static void main(String args[]) {
        Subject subject = new Proxy();
        subject.Request();
    }
}
