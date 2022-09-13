package me.yuanhu.core.DesignPattern.SimpleFactoryPattern.Example;

public class Client {
    public static void main2(String args[]) {
        Chart chart;
        chart = ChartFactory.getChart("histogram"); //通过静态工厂方法创建产品
        chart.display();
    }

    public static void main(String args[]) {
        Chart chart;
        String type = XMLUtil.getChartType(); //读取配置文件中的参数
        chart = ChartFactory.getChart(type); //创建产品对象
        chart.display();
    }
}
