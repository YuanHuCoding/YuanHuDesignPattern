package me.yuanhu.core.DesignPattern.MediatorPattern.Example;

//文本标签类：具体同事类
public class Label extends Component {
    public void update() {
        System.out.println("文本标签内容改变，客户信息总数加1。");
    }
}