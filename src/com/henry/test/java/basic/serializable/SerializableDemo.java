package com.henry.test.java.basic.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        serializeObject();
//        deserialize();
        serializeAndDeserialize();
    }


    public static void serializeObject() throws IOException {
        OutputStream op = new FileOutputStream("io"+ File.separator+"a.txt");
        ObjectOutputStream ops = new ObjectOutputStream(op);
        ops.writeObject(new Person("vae",100));

        ops.close();
    }

    public static void deserialize() throws IOException, ClassNotFoundException {

        InputStream in = new FileInputStream("io"+File.separator+"a.txt");
        ObjectInputStream os = new ObjectInputStream(in);
        Person p = (Person) os.readObject();
        System.out.println(p);
        os.close();

    }

    // 反序列化后得到的对象，是原始对象的一份深拷贝
    public static void serializeAndDeserialize() throws IOException, ClassNotFoundException {

        OutputStream op = new FileOutputStream("io"+ File.separator+"b.txt");
        ObjectOutputStream ops = new ObjectOutputStream(op);
        Person originPerson = new Person("vae",100, "test");
        ops.writeObject(originPerson);

        ops.close();


        InputStream in = new FileInputStream("io"+File.separator+"b.txt");
        ObjectInputStream os = new ObjectInputStream(in);
        Person p = (Person) os.readObject();
        System.out.println(p);
        os.close();

        System.out.println(originPerson == p);
        System.out.println(originPerson.getName());
        System.out.println(p.getName());
        System.out.println(originPerson.getName() == p.getName());
        System.out.println(originPerson.getDesc() == p.getDesc());
        System.out.println(originPerson.hashCode());
        System.out.println(originPerson.hashCode());
    }

}
