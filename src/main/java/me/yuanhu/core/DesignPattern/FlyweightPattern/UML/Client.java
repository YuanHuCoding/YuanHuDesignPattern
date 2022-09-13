package me.yuanhu.core.DesignPattern.FlyweightPattern.UML;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String args[]) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight aaa= flyweightFactory.factory("aaa");
        Flyweight bbb= flyweightFactory.factory("aaa");
        aaa.operation("111");
        aaa.operation("222");

        System.out.println("---------------------------------");

        List<String> compositeState = new ArrayList<String>();
        compositeState.add("x");
        compositeState.add("y");
        compositeState.add("c");
        compositeState.add("x");
        compositeState.add("y");

        FlyweightFactory flyFactory = new FlyweightFactory();
        Flyweight compositeFly1 = flyFactory.factory(compositeState);
        Flyweight compositeFly2 = flyFactory.factory(compositeState);
        compositeFly1.operation("Composite Call");

        System.out.println("---------------------------------");
        System.out.println("复合享元模式是否可以共享对象：" + (compositeFly1 == compositeFly2));

        String state = "x";
        Flyweight fly1 = flyFactory.factory(state);
        Flyweight fly2 = flyFactory.factory(state);
        System.out.println("单纯享元模式是否可以共享对象：" + (fly1 == fly2));

    }
}
