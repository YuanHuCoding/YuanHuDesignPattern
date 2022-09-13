package me.yuanhu.core.DesignPattern.AbstractFactoryPattern.Example;

//Summer文本框类：具体产品
public class SummerTextField implements TextField {
    public void display() {
        System.out.println("显示蓝色边框文本框。");
    }
}
