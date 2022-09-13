package me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.Example;

import me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.Filter;
import me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.FilterChain;
import me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.Request;
import me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.Response;

//将请求消息中的"被就业"替换成"就业"
public class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        String msg = request.getRequest().replace("被就业", "就业");
        request.setRequest(msg);

        chain.doFilter(request, response);

        response.setResponse(response.getResponse() + "--->SensitiveFilter");
    }
}