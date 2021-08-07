package com.henry.test.java.basic.annotation;

import java.lang.reflect.Field;

public class AnnotationTest {

    public static void main(String[] args) throws IllegalAccessException {
        boolean flag = Person.class.isAnnotationPresent(Report.class);
        System.out.println(flag);

        try {
            Field field = Person.class.getField("age");
            Report report = field.getAnnotation(Report.class);
            System.out.println(report.level());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Report report = Person.class.getAnnotation(Report.class);
        System.out.print(report.value());

        Person testPerson = new Person(40, "henry");

        check(testPerson);




    }




    public static void check(Person person) throws IllegalAccessException {
        for (Field field: person.getClass().getFields()) {
            Range range = field.getAnnotation(Range.class);
            if (range != null) {
                String name = (String) field.get(person);
                if (name.length() < range.min() || name.length() > range.max()) {
                    throw new IllegalArgumentException("Invalid field: " + field.getName());
                }
            }
        }
    }
}
