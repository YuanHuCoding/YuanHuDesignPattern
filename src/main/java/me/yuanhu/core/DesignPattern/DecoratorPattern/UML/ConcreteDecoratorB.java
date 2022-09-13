package me.yuanhu.core.DesignPattern.DecoratorPattern.UML;

public class ConcreteDecoratorB extends Decorator
{
    public ConcreteDecoratorB(Component  component)
    {
        super(component);
    }

    public void operation()
    {
        super.operation();  //调用原有业务方法
        addedBehavior();  //调用新增业务方法
    }

    //新增业务方法
    public void addedBehavior()
    {
        System.out.println("新增业务方法B");
    }

}