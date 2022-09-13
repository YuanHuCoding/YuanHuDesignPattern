package me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain;

// 对响应消息的抽象
public class Response {

    // 响应消息
    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}