package me.yuanhu.core.DesignPattern.VisitorPattern.UML_Classic;

import java.util.ArrayList;
import java.util.Iterator;

//ObjectStructure（对象结构）：对象结构是一个元素的集合，它用于存放元素对象，并且提供了遍历其内部元素的方法。
// 它可以结合组合模式来实现，也可以是一个简单的集合对象，如一个List对象或一个Set对象。
public class ObjectStructure {
    private ArrayList<Element> list = new ArrayList<Element>(); //定义一个集合用于存储元素对象

    public void accept(Visitor visitor)
    {
        Iterator i=list.iterator();

        while(i.hasNext())
        {
            ((Element)i.next()).accept(visitor); //遍历访问集合中的每一个元素
        }
    }

    public void addElement(Element element)
    {
        list.add(element);
    }

    public void removeElement(Element element)
    {
        list.remove(element);
    }

}
