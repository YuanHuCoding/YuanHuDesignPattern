package me.yuanhu.core.DesignPattern.StatePattern.ExampleA;

//抽象状态类
abstract class AccountState {
    protected Account acc;
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void computeInterest();
    public abstract void stateCheck();
}