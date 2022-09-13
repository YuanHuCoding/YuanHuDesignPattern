package me.yuanhu.core.DesignPattern.FlyweightPattern.JDKString;

public class Client {
    // 在Java语言中，如果每次执行类似String str1="abcd"的操作时都创建一个新的字符串对象将导致内存开销很大，
    // 因此如果第一次创建了内容为"abcd"的字符串对象str1，下一次再创建内容相同的字符串对象str2时会将它的引用指向"abcd"，
    // 不会重新分配内存空间，从而实现了"abcd"在内存中的共享。

    //上述代码输出结果如下：
    //
    //true
    //
    //true
    //
    //false
    //
    //false
    //
    // 可以看出，前两个输出语句均为true，说明str1、str2、str3在内存中引用了相同的对象
    // ；如果有一个字符串str4，其初值为"ab"，再对它进行操作str4 += "cd"，此时虽然str4的内容与str1相同，
    // 但是由于str4的初始值不同，在创建str4时重新分配了内存，所以第三个输出语句结果为false；最后一个输出语句结果也为false，
    // 说明当对str2进行修改时将创建一个新的对象，修改工作在新对象上完成，而原来引用的对象并没有发生任何改变，
    // str1仍然引用原有对象，而str2引用新对象，str1与str2引用了两个完全不同的对象。

    //关于Java    String类这种在修改享元对象时，先将原有对象复制一份，然后在新对象上再实施修改操作的机制称为“Copy On Write”，
    // 大家可以自行查询相关资料来进一步了解和学习“Copy On Write”机制，在此不作详细说明。
    public  static void main(String args[]) {
        String  str1 = "abcd";
        String  str2 = "abcd";
        String  str3 = "ab" + "cd";
        String  str4 = "ab";
        str4  += "cd";

        System.out.println(str1  == str2);
        System.out.println(str1  == str3);
        System.out.println(str1  == str4);

        str2  += "e";
        System.out.println(str1  == str2);

    }
}
