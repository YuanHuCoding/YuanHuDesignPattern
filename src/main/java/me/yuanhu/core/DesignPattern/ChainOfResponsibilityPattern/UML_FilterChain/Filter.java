package me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain;


//抽象处理者：Filter
public interface Filter {
    //每个Filter均为FilterChain的成员, Filter持有FilterChain的引用，以便调用链条中的各处理者
    void doFilter(Request request, Response response, FilterChain chain);
}
