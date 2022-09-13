package me.yuanhu.core.DesignPattern.PrototypePattern.UML;

public class ConcretePrototype implements Prototype {

    private String attr; //成员属性

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getAttr() {
        return this.attr;
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "attr='" + attr + '\'' +
                '}';
    }

    public Prototype clone() //克隆方法
    {
        ConcretePrototype prototype = new ConcretePrototype(); //创建新对象
        prototype.setAttr(this.attr);
        return prototype;
    }
}
