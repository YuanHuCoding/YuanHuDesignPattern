package me.yuanhu.core.DesignPattern.StrategyPattern.Example;

//学生票折扣类：具体策略类
public class StudentDiscount implements Discount {
    public double calculate(double price) {
        System.out.println("此人是学生票");
        return price * 0.8;
    }
}