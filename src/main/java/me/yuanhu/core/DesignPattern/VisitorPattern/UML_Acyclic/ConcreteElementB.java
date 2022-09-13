package me.yuanhu.core.DesignPattern.VisitorPattern.UML_Acyclic;

//ConcreteElement（具体元素）：具体元素实现了accept()方法，在accept()方法中调用访问者的访问方法以便完成对一个元素的操作。
public class ConcreteElementB  implements Element
{
    public void accept(Visitor visitor)
    {
        if(visitor instanceof IConcreteVistorB){
            IConcreteVistorB iConcreteVistorB = (IConcreteVistorB) visitor;
            iConcreteVistorB.visit(this);
        }
        else{
            System.out.println("无权访问此元素。");
        }
    }

    /**
     * ConcreteElementB特有的方法
     */
    public String operationB()
    {
        //业务方法
        return "ConcreteElementB";
    }
}