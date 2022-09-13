package me.yuanhu.core.DesignPattern.AdapterPattern.UML_Class;

//类适配器模式
//类适配器模式和对象适配器模式最大的区别在于适配器和适配者之间的关系不同，对象适配器模式中适配器和适配者之间是关联关系，而类适配器模式中适配器和适配者是继承关系
//Adapter（适配器类）：适配器可以调用另一个接口，作为一个转换器，对Adaptee和Target进行适配，适配器类是适配器模式的核心，
public class Adapter extends Adaptee implements Target {

    public void request() {
        specificRequest();
    }

}

