package me.yuanhu.core.DesignPattern.FlyweightPattern.UML;

//ConcreteFlyweight（具体享元类）：它实现了抽象享元类，其实例称为享元对象；在具体享元类中为内部状态提供了存储空间。
// 通常我们可以结合单例模式来设计具体享元类，为每一个具体享元类提供唯一的享元对象。
public class ConcreteFlyweight implements Flyweight {
    //内部状态intrinsicState作为成员变量，同一个享元对象其内部状态是一致的
    private String intrinsicState;

    /**
     * 构造函数，内蕴状态作为参数传入
     * @param intrinsicState
     */
    public  ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState=intrinsicState;
    }

    //外部状态extrinsicState在使用时由外部设置，不保存在享元对象中，即使是同一个对象，在每一次调用时也可以传入不同的外部状态
    public void operation(String  extrinsicState) {
        System.out.println("Intrinsic State = " + this.intrinsicState);
        System.out.println("Extrinsic State = " + extrinsicState);
    }

}
