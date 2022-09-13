package me.yuanhu.core.DesignPattern.VisitorPattern.UML_Classic;

//ConcreteVisitorA（具体访问者）：具体访问者实现了每个由抽象访问者声明的操作，每一个操作用于访问对象结构中一种类型的元素。
public class ConcreteVisitorA extends Visitor
{
    public void visit(ConcreteElementA element)
    {
        //元素ConcreteElementA操作代码
        System.out.println(element.operationA());
    }
    public void visit(ConcreteElementB element)
    {
        //元素ConcreteElementB操作代码
        System.out.println(element.operationB());
    }
}
