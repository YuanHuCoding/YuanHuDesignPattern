package me.yuanhu.core.DesignPattern.BuilderPattern.UML_A;

public class Client {
    public  static void main(String args[]){
        Builder  builder = new ConcreteBuilder(); //可通过配置文件实现

        Product product = Builder.construct(builder);

        System.out.println(product);

        Product product2 = Builder.construct(builder);

        System.out.println(product2);

        System.out.println(product==product2);//是同一个对象，咋办？
    }
}
