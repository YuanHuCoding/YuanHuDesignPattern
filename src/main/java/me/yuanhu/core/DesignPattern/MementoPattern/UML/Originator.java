package me.yuanhu.core.DesignPattern.MementoPattern.UML;

// Originator（原发器）：它是一个普通类，可以创建一个备忘录，并存储它的当前内部状态，
// 也可以使用备忘录来恢复其内部状态，一般将需要保存内部状态的类设计为原发器。
public class Originator {
    private String state;

    public Originator() {
    }

    // 创建一个备忘录对象
    public Memento createMemento() {
        return new Memento(this);
    }

    // 根据备忘录对象恢复原发器状态
    public void restoreMemento(Memento m) {
        state = m.getState();
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}