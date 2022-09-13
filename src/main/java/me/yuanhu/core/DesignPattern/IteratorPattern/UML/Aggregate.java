package me.yuanhu.core.DesignPattern.IteratorPattern.UML;

//Aggregate（抽象聚合类）：它用于存储和管理元素对象，声明一个createIterator()方法用于创建一个迭代器对象，充当抽象迭代器工厂角色。
public interface  Aggregate {
    Iterator createIterator();
}
