package me.yuanhu.core.DesignPattern.PrototypePattern.Example;

public class Client {
    public static void main(String args[])
    {
        //获取原型管理器对象
        PrototypeManager pm = PrototypeManager.getPrototypeManager();
        ShallowPrototype shallowPrototype= pm.getShallowPrototype("ShallowPrototype");
        DeepPrototype deepPrototype= pm.getDeepPrototype("DeepPrototype");
        System.out.println(shallowPrototype);
        System.out.println(deepPrototype);
    }
}
