package me.yuanhu.core.DesignPattern.StatePattern.ExampleB;

public abstract class State {
    public abstract void on(Switch s);
    public abstract void off(Switch s);
}