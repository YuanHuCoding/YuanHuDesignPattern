package me.yuanhu.core.DesignPattern.VisitorPattern.Example_Classic;

//财务部类：具体访问者类
public class FAVisitor extends DepartmentVisitor
{
    //实现财务部对全职员工的访问
    public void visit(FulltimeEmployee employee)
    {
        int workTime = employee.getWorkTime();
        double weekWage = employee.getWeeklyWage();
        if(workTime > 40)
        {
            weekWage = weekWage + (workTime - 40) * 100;
        }
        else if(workTime < 40)
        {
            weekWage = weekWage - (40 - workTime) * 80;
            if(weekWage < 0)
            {
                weekWage = 0;
            }
        }
        System.out.println("正式员工" + employee.getName() + "实际工资为：" + weekWage + "元。");
    }

    //实现财务部对兼职员工的访问
    public void visit(ParttimeEmployee employee)
    {
        System.out.println("无权访问兼职员工 "+employee.getName()+" 的数据。");
    }
}