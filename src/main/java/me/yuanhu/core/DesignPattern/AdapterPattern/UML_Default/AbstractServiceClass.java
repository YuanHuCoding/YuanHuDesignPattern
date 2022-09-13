package me.yuanhu.core.DesignPattern.AdapterPattern.UML_Default;


// AbstractServiceClass（缺省适配器类）：它是缺省适配器模式的核心类，使用空方法的形式实现了在
// ServiceInterface接口中声明的方法。通常将它定义为抽象类，因为对它进行实例化没有任何意义。
public abstract class AbstractServiceClass implements ServiceInterface {

    @Override
    public void method1() {

    }
    @Override
    public void method2() {

    }

}
