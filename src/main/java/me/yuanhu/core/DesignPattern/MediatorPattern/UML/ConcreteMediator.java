package me.yuanhu.core.DesignPattern.MediatorPattern.UML;

//ConcreteMediator（具体中介者）：它是抽象中介者的子类，通过协调各个同事对象来实现协作行为，它维持了对各个同事对象的引用。
public class ConcreteMediator extends Mediator {
    //实现业务方法，封装同事之间的调用
    public void operation() {

        ((Colleague)(colleagues.get(0))).method1(); //通过中介者调用同事类的方法

    }
}

