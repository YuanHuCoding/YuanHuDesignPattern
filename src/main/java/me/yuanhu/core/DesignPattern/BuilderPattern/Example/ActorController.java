package me.yuanhu.core.DesignPattern.BuilderPattern.Example;

//游戏角色创建控制器：指挥者
public class ActorController
{
    //逐步构建复杂产品对象
    public Actor construct(ActorBuilder ab)
    {
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();

        //通过钩子方法来控制产品的构建
        if(!ab.isBareheaded())
        {
            ab.buildHairstyle();
        }
        return ab.createActor();
    }

}
