package me.yuanhu.core.DesignPattern.BridgePattern.UML;

public class RefinedAbstractionB extends Abstraction {
    public void operation() {
        //业务代码
        impl.operationImpl();  //调用实现类的方法
        //业务代码
    }
}