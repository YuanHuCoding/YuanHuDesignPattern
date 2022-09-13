package me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_Classic;

//ConcreteHandler（具体处理者）：它是抽象处理者的子类，可以处理用户请求，在具体处理者类中实现了抽象处理者中定义的抽象请求处理方法，
// 在处理请求之前需要进行判断，看是否有相应的处理权限，如果可以处理请求就处理它，否则将请求转发给后继者；
// 在具体处理者中可以访问链中下一个对象，以便请求的转发。
public class ConcreteHandler extends Handler {
    public void handleRequest(String request) {
        if (true) {//请求满足条件
            //处理请求
        }
        else {
            this.successor.handleRequest(request);  //转发请求
        }
    }
}

