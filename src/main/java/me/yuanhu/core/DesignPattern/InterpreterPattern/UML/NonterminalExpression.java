package me.yuanhu.core.DesignPattern.InterpreterPattern.UML;

//非终结符表达式：非终结符表达式也是抽象表达式的子类，它实现了文法中非终结符的解释操作，由于在非终结符表达式中可以包含终结符表达式，
// 也可以继续包含非终结符表达式，因此其解释操作一般通过递归的方式来完成。
public class NonterminalExpression extends  AbstractExpression {

    private  AbstractExpression left;

    private  AbstractExpression right;



    public  NonterminalExpression(AbstractExpression left,AbstractExpression right) {

        this.left=left;

        this.right=right;

    }



    public void interpret(Context ctx) {

        //递归调用每一个组成部分的interpret()方法

        //在递归调用时指定组成部分的连接方式，即非终结符的功能

    }

}

