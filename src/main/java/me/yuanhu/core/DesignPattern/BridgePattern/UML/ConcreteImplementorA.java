package me.yuanhu.core.DesignPattern.BridgePattern.UML;

//ConcreteImplementor（具体实现类）：具体实现Implementor接口，在不同的ConcreteImplementor中提供基本操作的不同实现，
// 在程序运行时，ConcreteImplementor对象将替换其父类对象，提供给抽象类具体的业务操作方法。
public class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementorA.operationImpl");
    }
}
