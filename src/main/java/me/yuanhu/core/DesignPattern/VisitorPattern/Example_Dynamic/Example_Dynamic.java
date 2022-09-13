package me.yuanhu.core.DesignPattern.VisitorPattern.Example_Dynamic;

/**
 * 动态分派
 */
class Dog {
    public void excute(){
        System.out.println("我是dog妈妈");
    }
}

class DogBaby1 extends Dog {
    public void excute(){
        System.out.println("我是dogbaby1");
    }
}

class DogBaby2 extends Dog {
    public void excute(){
        System.out.println("我是dogbaby2");
    }
}

class Client {
    public static void main(String[] args) {
        Dog baby1 = new DogBaby1();
        baby1.excute();

        Dog baby2 = new DogBaby2();
        baby2.excute();
    }
}