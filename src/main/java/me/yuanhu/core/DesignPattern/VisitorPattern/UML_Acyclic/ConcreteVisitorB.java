package me.yuanhu.core.DesignPattern.VisitorPattern.UML_Acyclic;

public class ConcreteVisitorB implements Visitor,IConcreteVistorA
{
    public void visit(ConcreteElementA element)
    {
        //元素ConcreteElementA操作代码
        System.out.println(element.operationA());
    }
}