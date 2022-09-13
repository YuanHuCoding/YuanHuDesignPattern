package me.yuanhu.core.DesignPattern.StatePattern.UML;

public class ConcreteStateB extends State {
    public void handle() {
        //方法具体实现代码
        System.out.println("ConcreteStateB的handle方法");
    }

    public void changeState(Context ctx) {
        //根据环境对象中的属性值进行状态转换
        if (ctx.getValue() == 1) {
            ctx.setState(new ConcreteStateA());
        } else if (ctx.getValue() == 2) {
            ctx.setState(new ConcreteStateB());
        }
    }
}
