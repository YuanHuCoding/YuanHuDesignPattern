package me.yuanhu.core.DesignPattern.BuilderPattern.UML_B;

public class Client {
    public  static void main(String args[]){
        Builder  builder = new ConcreteBuilder(); //可通过配置文件实现

        Product product = builder.construct();

        System.out.println(product);
    }
}
