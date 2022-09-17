package me.yuanhu.core.DesignPattern.SingletonPattern;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;

//饿汉式单例模式(线程安全)
public class Singleton_Eager implements Serializable {
    private static final long serialVersionUID = -1L;
    private static boolean flag = false;
    private static final Singleton_Eager INSTANCE = new Singleton_Eager();

    private Singleton_Eager() {
        if (flag == false) {
            flag = true;
        } else {
            throw new RuntimeException("单例模式险些被破坏，第二个对象未创建成功");
        }
    }

    public static Singleton_Eager getInstance() {
        return INSTANCE;
    }

    /**
     * 如果实现了Serializable, 必须重写这个方法，才能保证其反序列化依旧是单例
     */
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

    public void sendMessage() {
        System.out.println("饿汉式单例模式。");
    }


    public static void main(String[] args) {
        try {
            Class<?> classType = Singleton_Eager.class;

            Constructor<?> c = classType.getDeclaredConstructor(null);
            c.setAccessible(true);
            Singleton_Eager e1 = (Singleton_Eager) c.newInstance();
            Singleton_Eager e2 = Singleton_Eager.getInstance();
            System.out.println(e1 == e2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
