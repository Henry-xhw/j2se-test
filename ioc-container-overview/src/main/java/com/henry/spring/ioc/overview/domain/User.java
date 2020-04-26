package com.henry.spring.ioc.overview.domain;

import com.henry.spring.ioc.overview.annotation.Super;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.lang.annotation.Annotation;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
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

    @Override public String toString() {
        return "User{" + "hashcode: " + super.hashCode() + " age=" + age + ", name='" + name + '\'' + '}';
    }

}
