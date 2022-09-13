package me.yuanhu.core.DesignPattern.VisitorPattern.Example_Acyclic;

//员工类：抽象元素类
public interface Employee {
     void accept(DepartmentVisitor vistor); //接受一个抽象访问者访问
}