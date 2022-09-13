package me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_Classic;

// Handler（抽象处理者）：它定义了一个处理请求的接口，一般设计为抽象类，由于不同的具体处理者处理请求的方式不同，
// 因此在其中定义了抽象请求处理方法。因为每一个处理者的下家还是一个处理者，因此在抽象处理者中定义了一个抽象处理者类型的对象
// （如结构图中的successor），作为其对下家的引用。通过该引用，处理者可以连成一条链。
public abstract class Handler {
    //维持对下家的引用
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor=successor;
    }

    public abstract void handleRequest(String request);
}
