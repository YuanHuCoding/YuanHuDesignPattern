package me.yuanhu.core.DesignPattern.SingletonPattern;

//不暴露枚举类实现细节的枚举单例模式
public class Singleton_Enum_Perfect {

    public static Singleton_Enum_Perfect getInstance(){
        return EnumSingleton.INSTANCE.getInstance();
    }

    //jvm层保证绝对单例
    private enum EnumSingleton{
        INSTANCE;

        private Singleton_Enum_Perfect instance;

        EnumSingleton(){//枚举类的构造方法在类加载是被实例化
            instance = new Singleton_Enum_Perfect();
        }

        private Singleton_Enum_Perfect getInstance(){
            return instance;
        }
    }

    private Singleton_Enum_Perfect(){}

    public void sendMessage() {
        System.out.println("不暴露枚举类实现细节的枚举单例模式");
    }

}
