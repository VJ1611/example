package com.examples;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamIterate {

    public static void main(String args[]) {

       // Stream<Long> naturalNo =
                Stream.iterate(1L, n -> n +1).limit(10).forEach(System.out::println);


        //naturalNo.forEach(System.out::println);

        String s = "This is adi";
        String s1[] = {"this",  "is"};
        String s3[] = Stream.iterate(s1.length -1, i -> i -1).limit(s1.length).map(i -> s1[i]).toArray(String[] :: new);
       // Stream.of(s.get()))
        Arrays.stream(s3).forEach(System.out::println);
    }
}
