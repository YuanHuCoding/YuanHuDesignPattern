package me.yuanhu.core.DesignPattern.SingletonPattern;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;

// 采用IoDH(Initialization on Demand Holder)技术的单例模式(线程安全)。也是老版《Effective Java》中推荐的单例模式。
public class Singleton_IoDH implements Serializable {
    private static final long serialVersionUID = -1L;
    private static boolean flag = false;

    private Singleton_IoDH() {
        //通过反射获取构造函数，然后调用setAccessible(true)就可以调用私有的构造函数
        synchronized (Singleton_IoDH.class) {
            if (flag == false) {
                flag = true;
            } else {
                throw new RuntimeException("单例模式险些被破坏，第二个对象未创建成功");
            }
        }
    }

    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例没有绑定关系，
     * 而且只有被调用到才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static final Singleton_IoDH INSTANCE = new Singleton_IoDH();
    }

    public static final Singleton_IoDH getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private Object readResolve() throws ObjectStreamException {
        return SingletonHolder.INSTANCE;
    }

    public void sendMessage() {
        System.out.println("采用IoDH(Initialization on Demand Holder)技术的单例模式。也是老版《Effective Java》中推荐的单例模式。");
    }

    public static void main(String[] args) {
        try {
            Class<?> classType = Singleton_IoDH.class;

            Constructor<?> c = classType.getDeclaredConstructor(null);
            c.setAccessible(true);
            Singleton_IoDH e1 = (Singleton_IoDH) c.newInstance();
            Singleton_IoDH e2 = Singleton_IoDH.getInstance();
            System.out.println(e1 == e2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}