package me.yuanhu.core.DesignPattern.StatePattern.ExampleB;

//打开状态
public class OnState extends State {
    public void on(Switch s) {
        System.out.println("已经打开！");
    }

    public void off(Switch s) {
        System.out.println("关闭！");
        s.setState(Switch.getState("off"));
    }
}