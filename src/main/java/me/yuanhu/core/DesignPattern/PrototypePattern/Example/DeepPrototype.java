package me.yuanhu.core.DesignPattern.PrototypePattern.Example;

import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

public class DeepPrototype implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    private String string;
    private SerializableObject obj;

    /* 浅复制 */
    public DeepPrototype clone() {
        DeepPrototype object = null;
        try {
            object = (DeepPrototype)super.clone();
        } catch (CloneNotSupportedException exception) {
            System.err.println("Not support cloneable");
        }
        return object;
    }

    /* 深复制 */
    public DeepPrototype deepClone() throws IOException, ClassNotFoundException {
        byte[] bytes = SerializationUtils.serialize(this);
        return  (DeepPrototype) SerializationUtils.deserialize(bytes);

//        //将对象写入流中
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(bos);
//        oos.writeObject(this);
//
//        //将对象从流中取出
//        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
//        ObjectInputStream ois = new ObjectInputStream(bis);
//        return (DeepPrototype)ois.readObject();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }
}
