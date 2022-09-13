package me.yuanhu.core.DesignPattern.IteratorPattern.UML;

//ConcreteAggregate（具体聚合类）：它实现了在抽象聚合类中声明的createIterator()方法，
// 该方法返回一个与该具体聚合类对应的具体迭代器ConcreteIterator实例。
public class ConcreteAggregate implements Aggregate {

    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
}

