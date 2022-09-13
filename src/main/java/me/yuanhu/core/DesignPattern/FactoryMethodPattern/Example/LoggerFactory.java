package me.yuanhu.core.DesignPattern.FactoryMethodPattern.Example;

//日志记录器工厂接口：抽象工厂
interface LoggerFactory {
    Logger createLogger();
    Logger createLogger(String args);
    Logger createLogger(Object obj);
}
