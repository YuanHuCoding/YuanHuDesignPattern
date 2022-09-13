package me.yuanhu.core.DesignPattern.SimpleFactoryPattern.UML;

//ConcreteProductA（具体产品角色）：它是简单工厂模式的创建目标，所有被创建的对象都充当这个角色的某个具体类的实例。
// 每一个具体产品角色都继承了抽象产品角色，需要实现在抽象产品中声明的抽象方法。
public class ConcreteProductA extends Product {
    //实现业务方法
    public void methodDiff() {
        //业务方法的实现
    }
}
