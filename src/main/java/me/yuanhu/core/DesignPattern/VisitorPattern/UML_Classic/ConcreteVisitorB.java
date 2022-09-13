package me.yuanhu.core.DesignPattern.VisitorPattern.UML_Classic;

public class ConcreteVisitorB extends Visitor
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