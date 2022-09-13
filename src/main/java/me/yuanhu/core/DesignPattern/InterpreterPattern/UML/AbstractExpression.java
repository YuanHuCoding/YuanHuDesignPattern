package me.yuanhu.core.DesignPattern.InterpreterPattern.UML;

//抽象表达式：在抽象表达式中声明了抽象的解释操作，它是所有终结符表达式和非终结符表达式的公共父类。
public abstract class AbstractExpression {

    public  abstract void interpret(Context ctx);

}
