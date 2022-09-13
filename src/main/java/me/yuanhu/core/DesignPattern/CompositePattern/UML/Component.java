package me.yuanhu.core.DesignPattern.CompositePattern.UML;

//透明组合模式
public abstract class Component {
    public abstract void add(Component c); //增加成员
    public abstract void remove(Component c); //删除成员
    public abstract Component getChild(int i); //获取成员

    public abstract void operation();  //业务方法
}

////安全组合模式
//public abstract class Component {
//    public abstract void operation();  //业务方法
//}
