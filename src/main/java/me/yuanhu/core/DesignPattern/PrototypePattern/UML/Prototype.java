package me.yuanhu.core.DesignPattern.PrototypePattern.UML;

//Prototype（抽象原型类）：它是声明克隆方法的接口，是所有具体原型类的公共父类，可以是抽象类也可以是接口，甚至还可以是具体实现类。
public interface Prototype {
    Prototype clone();
}
