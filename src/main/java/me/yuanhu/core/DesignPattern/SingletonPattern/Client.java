package me.yuanhu.core.DesignPattern.SingletonPattern;

public class Client {
    public static void main(String[] args) {
        Singleton_Eager.getInstance().sendMessage();
        Singleton_LazyDoubleChecked.getInstance().sendMessage();
        Singleton_IoDH.getInstance().sendMessage();
        Singleton_CAS.getInstance().sendMessage();
        Singleton_Enum.getInstance().sendMessage();
        Singleton_Enum_Perfect.getInstance().sendMessage();
    }
}
