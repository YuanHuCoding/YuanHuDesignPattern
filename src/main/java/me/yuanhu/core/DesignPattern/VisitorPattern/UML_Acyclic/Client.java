package me.yuanhu.core.DesignPattern.VisitorPattern.UML_Acyclic;

public class Client {
    public static void main(String[] args) {
        //创建一个结构对象
        ObjectStructure os = new ObjectStructure();
        //给结构增加一个节点
        os.addElement(new ConcreteElementA());
        //给结构增加一个节点
        os.addElement(new ConcreteElementB());
        //创建一个访问者
        Visitor visitor = new ConcreteVisitorB();
        os.accept(visitor);
    }
}