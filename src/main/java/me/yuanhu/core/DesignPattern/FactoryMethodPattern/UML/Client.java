package me.yuanhu.core.DesignPattern.FactoryMethodPattern.UML;

public class Client {
    public static void main(String[] args){
        Factory factory;
        Product product;
        factory = new ConcreteFactoryA(); //可引入配置文件实现
        product = factory.createProduct();
        product.sendMSG();
    }
}
