package me.yuanhu.core.DesignPattern.StatePattern.UML;

//ConcreteState（具体状态类）：它是抽象状态类的子类，每一个子类实现一个与环境类的一个状态相关的行为，
// 每一个具体状态类对应环境的一个具体状态，不同的具体状态类其行为有所不同。
public class ConcreteStateA extends State {
    public void handle() {
        //方法具体实现代码
        System.out.println("ConcreteStateA的handle方法");
    }

    public void changeState(Context ctx) {
        //根据环境对象中的属性值进行状态转换
        if (ctx.getValue() == 0) {
            ctx.setState(new ConcreteStateA());
        } else if (ctx.getValue() == 1) {
            ctx.setState(new ConcreteStateB());
        }
    }
}

