package me.yuanhu.core.DesignPattern.BuilderPattern.Example;

//角色建造器：抽象建造者
public abstract class ActorBuilder
{
    protected  Actor actor = new Actor();

    public  abstract void buildType();

    public  abstract void buildSex();

    public  abstract void buildFace();

    public  abstract void buildCostume();

    public  abstract void buildHairstyle();

    //钩子方法
    public boolean isBareheaded()
    {
        return false;
    }

    //工厂方法，返回一个完整的游戏角色对象
    public Actor createActor()
    {
        return actor;
    }

    // 在有些情况下，为了简化系统结构，可以将Director和抽象建造者Builder进行合并，在Builder中提供逐步构建复杂产品对象的construct()方法
    public Actor construct()
    {
        this.buildType();
        this.buildSex();
        this.buildFace();
        this.buildCostume();
        this.buildHairstyle();
        return actor;
    }
}