package me.yuanhu.core.DesignPattern.AbstractFactoryPattern.Example;

//界面皮肤工厂接口：抽象工厂
public interface SkinFactory {
    Button createButton();
    TextField createTextField();
    ComboBox createComboBox();
}