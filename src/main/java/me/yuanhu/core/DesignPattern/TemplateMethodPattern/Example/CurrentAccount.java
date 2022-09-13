package me.yuanhu.core.DesignPattern.TemplateMethodPattern.Example;

//活期账户类
public class CurrentAccount extends Account {

    //覆盖父类的抽象基本方法
    @Override
    public void CalculateInterest() {
        System.out.println("按活期利率计算利息！");
    }
}
