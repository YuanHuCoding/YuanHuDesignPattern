package me.yuanhu.core.DesignPattern.VisitorPattern.UML_Classic;

//Element（抽象元素）：抽象元素一般是抽象类或者接口，它定义一个accept()方法，该方法通常以一个抽象访问者作为参数。
public interface Element
{
    void accept(Visitor visitor);
}
