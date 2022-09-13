package me.yuanhu.core.DesignPattern.StrategyPattern.UML;

public class Client {
    public static void main(String args[]) {
        Context context = new Context();
        AbstractStrategy strategy;
        strategy = new ConcreteStrategyA(); //可在运行时指定类型
        context.setStrategy(strategy);
        context.algorithm();
    }
}
