package me.yuanhu.core.DesignPattern.VisitorPattern.Example_Static;
/**
 * 静态分派
 */
class Dog {

}

class DogBaby1 extends Dog{

}

class DogBaby2 extends Dog{

}

class Execute {
    public void excute(Dog dog){
        System.out.println("我是dog妈妈");
    }

    public void excute(DogBaby1 baby1){
        System.out.println("我是dogbaby1");
    }

    public void excute(DogBaby2 baby2){
        System.out.println("我是dogbaby2");
    }
}

class Client {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Dog baby1 = new DogBaby1();
        Dog baby2 = new DogBaby2();

        Execute exe = new Execute();
        exe.excute(dog);
        exe.excute(baby1);
        exe.excute(baby2);
    }
}