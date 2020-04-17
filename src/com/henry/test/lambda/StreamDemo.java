package com.henry.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // iterator 有"可消费性"
        List<Integer> integerList = Arrays.asList(1, 2, 3, 5);
        Iterator<Integer> iterator = integerList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //        System.out.println(iterator.next());

        Stream stream = Stream.of(1, 2, 3, 5);
        stream.forEach(System.out::println);
        //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        // stream 也有"可消费性"
//        stream.forEach(System.out::println);

//        showMap();
        showReduce();
        showCollect();

    }

    private static void showForeach() {
        Stream stream = Stream.of(1, 2, 3, 5);
        stream.forEach(System.out::println);

    }

    private static void showFilter() {
        // 保留长度等于3的字符串
        Stream<String> stream= Stream.of("I", "love", "you", "too");
        stream.filter(str -> str.length()==3)
            .forEach(str -> System.out.println(str));
    }

    private static void showDistinct() {
        Stream<String> stream= Stream.of("I", "love", "you", "too", "too");
        stream.distinct()
            .forEach(str -> System.out.println(str));
    }

    private static void showSort() {
        Stream<String> stream= Stream.of("I", "love", "you", "too");
        stream.sorted((str1, str2) -> str1.length()-str2.length())
            .forEach(str -> System.out.println(str));
    }

    private static void showMap() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.map(str -> str.toUpperCase())
            .forEach(str -> System.out.println(str));

//        Stream<String> stream2 = Stream.of("Henry", "love", "you", "too");
//        stream2.flatMap(str -> Stream.of(str)).forEach(System.out::println);
    }

    private static void showFlatMap() {
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
        stream.flatMap(list -> list.stream())
            .forEach(i -> System.out.println(i));
    }

    private static void showReduce() {
        // 找出最长的单词
        Stream<String> stream = Stream.of("I", "love", "you", "Azooooo");
//        Optional<String> longest = stream.reduce((s1, s2) -> s1.length()>=s2.length() ? s1 : s2);
//        Optional<String> longest = stream.reduce(BinaryOperator.maxBy(Comparator.naturalOrder()));
        Optional<String> longest = stream.reduce(BinaryOperator.maxBy(Comparator.comparingInt(str -> str.length())));
        //Optional<String> longest = stream.max((s1, s2) -> s1.length()-s2.length());
        System.out.println(longest.get());
    }
    //reduce()擅长的是生成一个值，如果想要从Stream生成一个集合或者Map等复杂的对象该怎么办呢？可以考虑collect()
    private static void showReduce2() {
        // 求单词长度之和
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Integer lengthSum = stream.reduce(0,// 初始值　// (1)
        (sum, str) -> sum+str.length(), // 累加器 // (2)
            (a, b) -> a+b);// 部分和拼接器，并行执行时才会用到 // (3)
        // int lengthSum = stream.mapToInt(str -> str.length()).sum();
        System.out.println(lengthSum);
    }

    private static void showCollect() {
        // 将Stream转换成容器或Map
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        List<String> list = stream.collect(Collectors.toList()); // (1)
        // Set<String> set = stream.collect(Collectors.toSet()); // (2)
        // Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length)); // (3)

        Stream<String> stream1 = Stream.of("I", "love", "you", "too");
        List<String> list1 = stream1.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
