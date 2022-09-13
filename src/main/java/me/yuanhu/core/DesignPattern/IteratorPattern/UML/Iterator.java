package me.yuanhu.core.DesignPattern.IteratorPattern.UML;

//Iterator（抽象迭代器）：它定义了访问和遍历元素的接口，声明了用于遍历数据元素的方法，例如：用于获取第一个元素的first()方法，
// 用于访问下一个元素的next()方法，用于判断是否还有下一个元素的hasNext()方法，用于获取当前元素的currentItem()方法等，在具体迭代器中将实现这些方法。
public interface Iterator {
    public void first(); //将游标指向第一个元素
    public void next(); //将游标指向下一个元素
    public boolean hasNext(); //判断是否存在下一个元素
    public Object currentItem(); //获取游标指向的当前元素
}
