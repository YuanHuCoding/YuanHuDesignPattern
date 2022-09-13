package me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.Example;

import me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.Filter;
import me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.FilterChain;
import me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.Request;
import me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.UML_FilterChain.Response;

// 将请求消息中的":)"替换成"笑脸"
public class FaceFilter implements Filter {

    public void doFilter(Request request, Response response, FilterChain chain) {
        String msg = request.getRequest().replace(":)", "笑脸");
        request.setRequest(msg);

        chain.doFilter(request, response);

        response.setResponse(response.getResponse() + "--->FaceFilter");
    }
}