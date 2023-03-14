package com.att.tlv.training.java8.answers.streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreationAnswer {

    /**
     * Example:
     * getOddNumbers(3, 4) => { 7, 9, 11, 13 } 
     */
    public static IntStream getOddNumbers(int skip, int count) {
        return IntStream.iterate(1, n -> n + 2)
                    .skip(skip)
                    .limit(count);
    }
    
    /**
     * Example:
     * "Hello", "Hello", "Hello"..... 
     */
    public static Stream<String> getInfiniteHelloStream() {
        return Stream.generate(() -> "Hello");
    }
    
    /**
     * Example:
     * getRange(10, 13) => { 10, 11, 12 }
     */
    public static LongStream getRange(long startInclusive, long endExclusive) {
        return LongStream.range(startInclusive, endExclusive);
    }
    
    /**
     * Example:
     * toDoubleStream(10.5, 5.23) => { 10.5, 5.23 }
     */    
    public static DoubleStream toDoubleStream(double v1, double v2) {
        return DoubleStream.of(v1, v2);
    }
    
    /**
     * Example:
     * toStream("Java ", "8 ", "Rules!") => { "Java ", "8 ", "Rules!" }
     */    
    public static Stream<String> toStream(String... strings) {
        return Stream.of(strings);
    }
}