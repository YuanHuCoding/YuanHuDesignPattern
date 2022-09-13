package me.yuanhu.core.DesignPattern.TemplateMethodPattern.UML;

public abstract class AbstractClass {
    //模板方法
    public void TemplateMethod() {
        PrimitiveOperation1();
        PrimitiveOperation2();
        if(IsXXX()){
            PrimitiveOperation3();
        }
    }

    //基本方法—具体方法
    public void PrimitiveOperation1() {
        //实现代码
        System.out.println("PrimitiveOperation1");
    }

    //基本方法—抽象方法
    public abstract void PrimitiveOperation2();

    public abstract void PrimitiveOperation3();

    //钩子方法
    public abstract Boolean IsXXX();
}