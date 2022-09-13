package me.yuanhu.core.DesignPattern.StrategyPattern.UML;

//ConcreteStrategy（具体策略类）：它实现了在抽象策略类中声明的算法，在运行时，具体策略类将覆盖在环境类中定义的抽象策略类对象，使用一种具体的算法实现某个业务处理。
public class ConcreteStrategyA extends AbstractStrategy {

    //算法的具体实现
    public void algorithm() {
        //算法A
        System.out.println("算法A的实现。");
    }
}

