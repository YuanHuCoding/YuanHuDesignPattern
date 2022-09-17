package me.yuanhu.core.DesignPattern.SingletonPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//最佳方法：枚举单例模式(线程安全)。新版的《Effective Java》中推荐的单例模式。
public enum Singleton_Enum {
    INSTANCE;

    public static final Singleton_Enum getInstance() {
        return Singleton_Enum.INSTANCE;
    }

    public void sendMessage() {
        System.out.println("枚举单例模式。新版的《Effective Java》中推荐的单例模式。");
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        Class<Singleton_Enum> classType = Singleton_Enum.class;
        Constructor<Singleton_Enum> c = (Constructor<Singleton_Enum>) classType.getDeclaredConstructor();
        c.setAccessible(true);
        c.newInstance();
    }
}