package me.yuanhu.core.DesignPattern.VisitorPattern.UML_Acyclic;

//ConcreteElement（具体元素）：具体元素实现了accept()方法，在accept()方法中调用访问者的访问方法以便完成对一个元素的操作。
public class ConcreteElementA implements Element
{
    public void accept(Visitor visitor)
    {
        if(visitor instanceof IConcreteVistorA){
            IConcreteVistorA iConcreteVistorA = (IConcreteVistorA) visitor;
            iConcreteVistorA.visit(this);
        }
        else{
            System.out.println("无权访问此元素。");
        }
    }

    /**
     * ConcreteElementA特有的方法
     */
    public String operationA()
    {
        //业务方法
        return "ConcreteElementA";
    }
}

