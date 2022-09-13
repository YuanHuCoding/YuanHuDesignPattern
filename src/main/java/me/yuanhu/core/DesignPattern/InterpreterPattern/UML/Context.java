package me.yuanhu.core.DesignPattern.InterpreterPattern.UML;

import java.util.HashMap;

//环境类：环境类又称为上下文类，它用于存储解释器之外的一些全局信息，通常它临时存储了需要解释的语句。
public class Context {

    private HashMap map = new HashMap();


    public void assign(String key, String value) {
        //往环境类中设值
    }


    public String  lookup(String key) {
        //获取存储在环境类中的值
        return "";
    }
}
