package com.henry.test.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamCollectDemo {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 5, 7);
        List<Integer> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        list.forEach(System.out::println);
    }
}
