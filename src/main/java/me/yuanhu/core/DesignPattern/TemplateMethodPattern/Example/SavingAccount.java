package me.yuanhu.core.DesignPattern.TemplateMethodPattern.Example;

//定期账户类
public class SavingAccount  extends Account {

    //覆盖父类的抽象基本方法
    @Override
    public void CalculateInterest() {
        System.out.println("按定期利率计算利息！");
    }
}
