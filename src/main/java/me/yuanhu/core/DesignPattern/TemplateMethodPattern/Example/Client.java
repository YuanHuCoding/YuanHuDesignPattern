package me.yuanhu.core.DesignPattern.TemplateMethodPattern.Example;

public class Client {
    public static void main(String args[])
    {
        Account account = new SavingAccount();
        account.Handle("张无忌", "123456");
        System.out.println("==============================================");
        account = new CurrentAccount();
        account.Handle("张无忌", "123456");
    }
}
