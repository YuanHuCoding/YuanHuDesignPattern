package me.yuanhu.core.DesignPattern.VisitorPattern.Example_Classic;

//部门类：抽象访问者类
public abstract class DepartmentVisitor
{
    //声明一组重载的访问方法，用于访问不同类型的具体元素
    public abstract void visit(FulltimeEmployee employee);
    public abstract void visit(ParttimeEmployee employee);
}
