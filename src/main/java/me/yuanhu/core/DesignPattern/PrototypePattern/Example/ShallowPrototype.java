package me.yuanhu.core.DesignPattern.PrototypePattern.Example;

public class ShallowPrototype implements Cloneable {
    public ShallowPrototype clone(){
        ShallowPrototype object = null;
        try {
            object = (ShallowPrototype)super.clone();
        } catch (CloneNotSupportedException exception) {
            System.err.println("Not support cloneable");
        }
        return object;
    }
}
