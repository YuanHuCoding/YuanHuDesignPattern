package me.yuanhu.core.DesignPattern.IteratorPattern.UML;

//ConcreteIterator（具体迭代器）：它实现了抽象迭代器接口，完成对聚合对象的遍历，同时在具体迭代器中通过游标来记录在聚合
// 对象中所处的当前位置，在具体实现时，游标通常是一个表示位置的非负整数。
public class ConcreteIterator implements Iterator {
    private ConcreteAggregate objects; //维持一个对具体聚合对象的引用，以便于访问存储在聚合对象中的数据
    private int cursor; //定义一个游标，用于记录当前访问位置
    public ConcreteIterator(ConcreteAggregate objects) {
        this.objects=objects;
    }

    public void first() {    }

    public void next() {   }

    public boolean hasNext() {  return true; }

    public Object currentItem(){ return null;}
}
