package me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.Example;

import me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.Filter;
import me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.FilterChain;
import me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.Request;
import me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.Response;

//具体处理者：HTMLFilter
// 将请求消息中的"<>"替换成"[]"
public class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        // process HTML Tag
        String msg = request.getRequest().replace("<", "[").replace(">", "]");
        request.setRequest(msg);

        chain.doFilter(request, response);

        response.setResponse(response.getResponse() + "--->HTMLFilter");
    }
}