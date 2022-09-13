package me.yuanhu.core.DesignPattern.FlyweightPattern.UML;

//UnsharedConcreteFlyweight（非共享具体享元类）：并不是所有的抽象享元类的子类都需要被共享，
// 不能被共享的子类可设计为非共享具体享元类；当需要一个非共享具体享元类的对象时可以直接通过实例化创建。
public class UnsharedConcreteFlyweight implements Flyweight {
    //内部状态intrinsicState作为成员变量，同一个享元对象其内部状态是一致的
    private String intrinsicState;

    public  UnsharedConcreteFlyweight(String intrinsicState) {
        this.intrinsicState=intrinsicState;
    }

    public void operation(String  extrinsicState) {
        System.out.println("Intrinsic State = " + this.intrinsicState);
        System.out.println("Extrinsic State = " + extrinsicState);
    }
}
