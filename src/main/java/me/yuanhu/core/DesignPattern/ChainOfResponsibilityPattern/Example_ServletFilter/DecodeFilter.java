//package me.yuanhu.core.DesignPattern.ChainOfResponsibilityPattern.Example_ServletFilter;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
///**
// * Description: 使用 Filter 解决 GET/POST 提交的中文乱码
// */
//public class DecodeFilter implements Filter {
//
//    /**
//     * 指定编码方式，默认 utf-8
//     */
//    private String encoding;    // Filter 参数
//
//    @Override
//    public void destroy() {
//        this.encoding = null;
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse response,
//                         FilterChain chain) throws IOException, ServletException {
//
//        HttpServletRequest request = (HttpServletRequest) req;
//
//        // 重新编码后的请求
//        HttpServletRequest newReq = null;
//
//        // 获取请求方式
//        String method = request.getMethod();
//
//        if ("POST".equalsIgnoreCase(method)) {          // POST请求的处理方式
//            request.setCharacterEncoding(encoding);
//            newReq = request;
//        } else {             // GET请求的处理方式
//            //  匿名内部类：最终提供给我们的是一个匿名子类对象
//            newReq = new HttpServletRequestWrapper(request) {  // HttpServletRequest 接口的实现类
//
//                // 重写对请求参数所有可能的获取方式
//                @Override
//                public String getParameter(String name) {
//                    String value = super.getParameter(name);
//                    if (value != null) {
//                        value = this.transCoding(value);
//                    }
//                    return value;
//                }
//
//                // 重写对请求参数所有可能的获取方式
//                @Override
//                public String[] getParameterValues(String name) {
//                    String[] values = super.getParameterValues(name);
//                    if (values == null) {
//                        return values;
//                    }
//                    for (int i = 0; i < values.length; i++) {
//                        values[i] = this.transCoding(values[i]);
//                    }
//                    return values;
//                }
//
//                // 重写对请求参数所有可能的获取方式
//                @Override
//                public Map<String, String[]> getParameterMap() {
//                    Map<String, String[]> map = super.getParameterMap();
//                    Map<String, String[]> result = new HashMap<String, String[]>();
//                    Set<Map.Entry<String, String[]>> entrySet = map.entrySet();
//                    for (Map.Entry<String, String[]> set : entrySet) {
//                        String name = set.getKey();
//                        String[] values = set.getValue();
//                        for (int i = 0; i < values.length; i++) {
//                            values[i] = values[i];
//                        }
//                        result.put(name, values);
//                    }
//                    return result;
//                }
//
//                // 代码重用，对中文字符进行解码
//                public String transCoding(String value) {
//                    try {
//                        value = new String(value.getBytes("iso-8859-1"),
//                                encoding);
//                    } catch (UnsupportedEncodingException e) {
//                        System.out.println(this.getClass().getName()
//                                + " 发生转码错误： 从 " + "iso-8859-1" + " 到 "
//                                + encoding);
//                        e.printStackTrace();
//                    }
//                    return value;
//                }
//            };
//        }
//
//        // AOP 思想的重要体现，将请求交给其下家继续进行处理，不纯的责任链模式
//        chain.doFilter(newReq, response);
//    }
//
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//        // 从配置文件获取编码参数
//        encoding = config.getInitParameter("encoding");
//        encoding = encoding == null ? "utf-8" : encoding;
//    }
//}