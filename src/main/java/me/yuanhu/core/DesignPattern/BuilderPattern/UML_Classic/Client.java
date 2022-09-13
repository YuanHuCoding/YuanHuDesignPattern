package me.yuanhu.core.DesignPattern.BuilderPattern.UML_Classic;

public class Client {
    public  static void main(String args[]){
        Builder  builder = new ConcreteBuilder(); //可通过配置文件实现

        Director director = new  Director(builder);

        Product product = director.construct();


    }
}
