package me.yuanhu.core.DesignPattern.PrototypePattern.Example;

import java.io.IOException;
import java.util.Hashtable;

//原型管理器
public class PrototypeManager {
    //定义一个Hashtable，用于存储原型对象
    private Hashtable ht = new Hashtable();
    private static PrototypeManager pm = new PrototypeManager();

    public static PrototypeManager getPrototypeManager()
    {
        return pm;
    }

    //为Hashtable增加对象
    private PrototypeManager()
    {
        ht.put("ShallowPrototype", new ShallowPrototype());
        ht.put("DeepPrototype", new DeepPrototype());
    }

    //增加新对象
    public void addShallowPrototype(String key, ShallowPrototype doc)
    {
        ht.put(key, doc);
    }

    //通过浅克隆获取新的对象
    public ShallowPrototype getShallowPrototype(String key)
    {
        return ((ShallowPrototype) ht.get(key)).clone();
    }

    //增加新对象
    public void addDeepPrototype(String key, DeepPrototype doc)
    {
        ht.put(key, doc);
    }

    //通过深克隆获取新的对象
    public DeepPrototype getDeepPrototype(String key)
    {
        try {
            return ((DeepPrototype) ht.get(key)).deepClone();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
