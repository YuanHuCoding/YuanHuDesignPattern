package me.yuanhu.core.DesignPattern.FactoryMethodPattern.Example;

public class Client {
    public static void main2(String args[]) {
        LoggerFactory factory;
        Logger logger;
        factory = new FileLoggerFactory(); //可引入配置文件实现
        logger = factory.createLogger();
        logger.writeLog();
    }

    public static void main(String args[]) {
        LoggerFactory factory;
        Logger logger;
        factory = (LoggerFactory)XMLUtil.getBean(); //getBean()的返回类型为Object，需要进行强制类型转换
        logger = factory.createLogger();
        logger.writeLog();
    }
}
