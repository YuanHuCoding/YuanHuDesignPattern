package me.yuanhu.core.DesignPattern.SingletonPattern;

import java.io.*;
import java.lang.reflect.Constructor;

//采用双重检验锁(Double-Checked SpinLock)技术的懒汉式单例模式(线程安全)。
public class Singleton_LazyDoubleChecked implements Serializable {
    private static final long serialVersionUID = -1L;
    private static boolean flag = false;

    //声明成 volatile，禁止指令重排序优化。也就是说，在 volatile 变量的赋值操作后面会有一个内存屏障（生成的汇编代码上），读操作不会被重排序到内存屏障之前。
    private volatile static Singleton_LazyDoubleChecked INSTANCE;

    private Singleton_LazyDoubleChecked() {
        // 防止反射获取多个对象的漏洞
        if (flag == false) {
            flag = true;
        } else {
            throw new RuntimeException("单例模式险些被破坏，第二个对象未创建成功");
        }
    }

    public static Singleton_LazyDoubleChecked getInstance() {
        if (INSTANCE == null) { // 第一次检查
            synchronized (Singleton_LazyDoubleChecked.class) {
                if (INSTANCE == null) {// 第二次检查
                    /*
                     * 这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情:
                     *  1.给 instance 分配内存
                     *  2.调用 SingletonPattern 的构造函数来初始化成员变量
                     *  3.将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
                     *
                     *  但是在 JVM 的即时编译器中存在指令重排序的优化。
                     *  也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。
                     *  如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，
                     *  这时 instance 已经是非 null 了（但却没有初始化），
                     *  所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
                     *  我们只需要将 INSTANCE 变量声明成 volatile 就可以了。
                     * */
                    INSTANCE = new Singleton_LazyDoubleChecked();
                }
            }
        }
        return INSTANCE;
    }

    // 防止反序列化获取多个对象的漏洞。
    // 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
    // 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象。
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

    public void sendMessage() {
        System.out.println("采用双重检验锁(Double-Checked SpinLock)技术的懒汉式单例模式。");
    }

    public static void main(String[] args) throws Exception {
        Singleton_LazyDoubleChecked sc1 = Singleton_LazyDoubleChecked.getInstance();
        Singleton_LazyDoubleChecked sc2 = Singleton_LazyDoubleChecked.getInstance();
        System.out.println(sc1); // sc1，sc2是同一个对象
        System.out.println(sc2);
        System.out.println(sc1 == sc2);

        // 通过反射的方式直接调用私有构造器（通过在构造器里抛出异常可以解决此漏洞）
        try {
            Class<?> classType = Singleton_LazyDoubleChecked.class;

            Constructor<?> c = classType.getDeclaredConstructor(null);
            c.setAccessible(true);
            Singleton_LazyDoubleChecked sc3 = (Singleton_LazyDoubleChecked) c.newInstance();
            System.out.println(sc1 == sc3);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 通过反序列化的方式构造多个对象（类需要实现Serializable接口）
        // 1. 把对象sc1写入硬盘文件
        FileOutputStream fos = new FileOutputStream("object.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(sc1);
        oos.close();
        fos.close();

        // 2. 把硬盘文件上的对象读出来
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.out"));
        // 如果对象定义了readResolve()方法，readObject()会调用readResolve()方法。从而解决反序列化的漏洞
        Singleton_LazyDoubleChecked sc4 = (Singleton_LazyDoubleChecked) ois.readObject();
        // 反序列化出来的对象，和原对象，不是同一个对象。如果对象定义了readResolve()方法，可以解决此问题。
        System.out.println("对象定义了readResolve()方法，通过反序列化得到的对象sc4：" + sc4);
        System.out.println(sc1);
        System.out.println(sc4);
        System.out.println(sc1==sc4);
        ois.close();
    }
}