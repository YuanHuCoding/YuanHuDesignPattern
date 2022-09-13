package me.yuanhu.core.DesignPattern.FlyweightPattern.UML;

import java.util.HashMap;
import java.util.Map;

public class ConcreteCompositeFlyweight implements Flyweight {

    private Map<String,Flyweight> flyweightMap = new HashMap<>();

    /**
     * 增加一个新的单纯享元对象到聚集中
     */
    public void add(String key , Flyweight fly){
        flyweightMap.put(key,fly);
    }
    /**
     * 外蕴状态作为参数传入到方法中
     */
    @Override
    public void operation(String state) {
        Flyweight fly = null;
        for(Object o : flyweightMap.keySet()){
            fly = flyweightMap.get(o);
            fly.operation(state);
        }

    }
}
