package com.henry.test.java.basic.ioc;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(
            propertyDescriptor -> {
                Class<?> propertyType = propertyDescriptor.getPropertyType();
                String propertyName = propertyDescriptor.getName();
                if ("age".equals(propertyName)) {
                    propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
//                    propertyDescriptor.createPropertyEditor()
                }

//                System.out.println(propertyDescriptor);
//                System.out.println(propertyType);
            }

        );
    }
    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}


class Person {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

