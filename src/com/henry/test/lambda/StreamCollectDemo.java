package com.henry.test.lambda;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectDemo {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 5, 7);
//        List<Integer> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        List<Integer> list = stream.collect(ArrayList::new, (al, a) -> al.add(a), (al, al2) -> al.addAll(al2));
//        list.forEach(System.out::println);
        showCollectorMapUsePartition();
        showCollectorMap();
        showCollectorMapUsingGroupingBy();

    }

    private static void showCollect() {
        //　将Stream规约成List
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);// 方式１
        //List<String> list = stream.collect(Collectors.toList());// 方式2
        System.out.println(list);


        // 将Stream转换成List或Set
        Stream<String> stream2= Stream.of("I", "love", "you", "too");
        List<String> list2 = stream2.collect(Collectors.toList()); // (1)
        Set<String> set = stream2.collect(Collectors.toSet()); // (2)

        // 使用toCollection()指定规约容器的类型
        List<String> arrayList = stream.collect(Collectors.toCollection(LinkedList::new));// (3)
        HashSet<String> hashSet = stream.collect(Collectors.toCollection(HashSet::new));// (4)
    }

    private static void showCollectorMapUsePartition() {
        Stream<Integer> stream = Stream.of(1, 4, 9, 2, 3);
        Map<Boolean, List<Integer>> map = stream.collect(Collectors.partitioningBy(integer -> integer > 5));
        map.forEach((k, v) -> System.out.println("key: " + k + " ; value: " + v));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Student {
        private Integer stuNo;
        private String name;
        private boolean sex;

    }
    private static void showCollectorMap() {
        Stream<Student> stream = Stream.of(new Student(1, "henry", true), new Student(2, "yuzi", false));
        Map<Integer, String> studentMap =  stream.collect(Collectors.toMap(student -> student.getStuNo(), student -> student.getName()));
        studentMap.forEach((k, v) -> System.out.println("stuNo: " + k + " ; stuName: " + v));
    }

    private static void showCollectorMapUsingGroupingBy() {
        Stream<Student> stream = Stream.of(new Student(1, "henry", true), new Student(2, "yuzi", false), new Student(3, "youyou", true),
            new Student(4, "zuozuo", true));
//        Map<Boolean, List<Student>> map = stream.collect(Collectors.partitioningBy(student -> student.isSex()));
//        map.forEach((k, v) -> System.out.println("male: " + k + " ; student: " + v));

        Map<Boolean, List<Student>> map = stream.collect(Collectors.groupingBy(Student::isSex));
        map.forEach((a, b) -> System.out.println(a ? "男: " : "女: " + b));
//        map.forEach((a, b) -> System.out.println((a ? "男: " : "女: ") + b));
//        map.forEach((a, b) -> {
//            String str = a.booleanValue() ? "男" : "女";
//            System.out.println(str + " : " + b);
//        });


    }
}
