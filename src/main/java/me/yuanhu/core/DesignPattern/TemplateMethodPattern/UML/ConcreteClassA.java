package me.yuanhu.core.DesignPattern.TemplateMethodPattern.UML;

public class ConcreteClassA extends AbstractClass {
    @Override
    public void PrimitiveOperation2() {
        System.out.println("PrimitiveOperation2");
    }

    @Override
    public void PrimitiveOperation3() {
        System.out.println("PrimitiveOperation3");
    }

    @Override
    public Boolean IsXXX() {
        return false;
    }
}
