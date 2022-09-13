package me.yuanhu.core.DesignPattern.CommandPattern.UML;

//Receiver（接收者）：接收者执行与请求相关的操作，它具体实现对请求的业务处理。
public class Receiver {
    public void action() {
        //具体操作
        System.out.println("具体操作");
    }
}
