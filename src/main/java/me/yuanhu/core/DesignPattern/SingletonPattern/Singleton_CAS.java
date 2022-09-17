package me.yuanhu.core.DesignPattern.SingletonPattern;

import java.util.concurrent.atomic.AtomicReference;

//CAS AtomicReference(线程安全)
public class Singleton_CAS {
    private static final AtomicReference<Singleton_CAS> INSTANCE = new
            AtomicReference<Singleton_CAS>();
    private static Singleton_CAS instance;

    private Singleton_CAS() {
    }

    public static final Singleton_CAS getInstance() {
        for (; ; ) {
            Singleton_CAS instance = INSTANCE.get();
            if (null != instance) return instance;
            INSTANCE.compareAndSet(null, new Singleton_CAS());
            return INSTANCE.get();
        }
    }


    public void sendMessage() {
        System.out.println("采用CAS AtomicReference技术的单例模式。");
    }
}