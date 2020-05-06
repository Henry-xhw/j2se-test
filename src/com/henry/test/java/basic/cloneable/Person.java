package com.henry.test.java.basic.cloneable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Cloneable, Serializable {
    public String pname;
    public int page;
    public Address address;
    public Person() {}

    public Person(String pname,int page){
        this.pname = pname;
        this.page = page;
        this.address = new Address();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.address = (Address) address.clone();
        return p;
    }

    //深度拷贝
    public Object deepClone() throws Exception{
        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(this);

        // 反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }

    public void setAddress(String provices,String city ){
        address.setAddress(provices, city);
    }
    public void display(String name){
        System.out.println(name+":"+"pname=" + pname + ", page=" + page +","+ address);
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}
