package me.yuanhu.core.DesignPattern.MediatorPattern.UML;

import java.util.ArrayList;

//Mediator（抽象中介者）：它定义一个接口，该接口用于与各同事对象之间进行通信。
public abstract class Mediator {
    protected ArrayList<Colleague> colleagues; //用于存储同事对象

    //注册方法，用于增加同事对象
    public void register(Colleague colleague) {
        colleagues.add(colleague);
    }

    //声明抽象的业务方法
    public abstract void operation();
}
