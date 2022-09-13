package me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain;

// 对请求消息的抽象
public class Request {

    // 请求消息
    private String request;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

}