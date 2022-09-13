package me.yuanhu.core.DesignPattern.StatePattern.ExampleB;

//关闭状态
public class OffState extends State {
    public void on(Switch s) {
        System.out.println("打开！");
        s.setState(Switch.getState("on"));
    }

    public void off(Switch s) {
        System.out.println("已经关闭！");
    }
}