package me.yuanhu.core.DesignPattern.MementoPattern.Example;

import java.util.ArrayList;

//象棋棋子备忘录管理类：负责人
public class MementoCaretaker {
    //定义一个集合来存储多个备忘录
    private ArrayList mementolist = new ArrayList();

    public ChessmanMemento getMemento(int i) {
        return (ChessmanMemento)mementolist.get(i);
    }

    public void setMemento(ChessmanMemento memento) {
        mementolist.add(memento);
    }
}