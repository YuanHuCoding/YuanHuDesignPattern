package me.yuanhu.core.DesignPattern.BridgePattern.UML;

import javax.xml.parsers.*;
import org.w3c.dom.*;

import java.io.*;

//<?xml version="1.0"?>
//<config>
//    <!--RefinedAbstraction-->
//    <className>RefinedAbstractionA</className>
//    <!--ConcreteImplementor-->
//    <className>ConcreteImplementorA</className>
//</config>
public class XMLUtil {
    //该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
    public static Object getBean(String args) {
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File(XMLUtil.class.getResource("").getPath() + "config.xml"));
            NodeList nl=null;
            Node classNode=null;
            String cName=null;
            nl = doc.getElementsByTagName("className");

            if(args.equals("Abstraction")) {
                //获取第一个包含类名的节点，即扩充抽象类
                classNode=nl.item(0).getFirstChild();

            }
            else if(args.equals("Implementor")) {
                //获取第二个包含类名的节点，即具体实现类
                classNode=nl.item(1).getFirstChild();
            }

            cName=classNode.getNodeValue();
            //通过类名生成实例对象并将其返回
            Class c=Class.forName(cName);
            Object obj=c.newInstance();
            return obj;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}