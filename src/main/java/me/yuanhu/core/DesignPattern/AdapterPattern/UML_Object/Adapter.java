package me.yuanhu.core.DesignPattern.AdapterPattern.UML_Object;

//对象适配器模式
//类适配器模式和对象适配器模式最大的区别在于适配器和适配者之间的关系不同，对象适配器模式中适配器和适配者之间是关联关系，而类适配器模式中适配器和适配者是继承关系
//Adapter（适配器类）：适配器可以调用另一个接口，作为一个转换器，对Adaptee和Target进行适配，适配器类是适配器模式的核心，
// 在对象适配器中，它通过继承Target并关联一个Adaptee对象使二者产生联系。
public class Adapter implements Target {

    private Adaptee adaptee; //维持一个对适配者对象的引用

    public Adapter(Adaptee adaptee) {
        this.adaptee=adaptee;
    }

    public void request() {
        adaptee.specificRequest(); //转发调用
    }

}

