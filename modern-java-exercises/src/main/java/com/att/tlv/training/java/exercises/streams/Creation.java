package com.att.tlv.training.java.exercises.streams;

import com.att.tlv.training.java.exercises.Exercises;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Creation {

    /**
     * Example:
     * getOddNumbers(3, 4) => { 7, 9, 11, 13 } 
     */
    public static IntStream getOddNumbers(int skip, int count) {
        return Exercises.replaceThisWithSolution();
    }
    
    /**
     * Example:
     * "Hello", "Hello", "Hello"..... 
     */
    public static Stream<String> getInfiniteHelloStream() {
        return Exercises.replaceThisWithSolution();
    }
    
    /**
     * Example:
     * getRange(10, 13) => { 10, 11, 12 }
     */
    public static LongStream getRange(long startInclusive, long endExclusive) {
        return Exercises.replaceThisWithSolution();
    }
    
    /**
     * Example:
     * toDoubleStream(10.5, 5.23) => { 10.5, 5.23 }
     */    
    public static DoubleStream toDoubleStream(double v1, double v2) {
        return Exercises.replaceThisWithSolution();
    }
    
    /**
     * Example:
     * toStream("Java ", "21", "Rules!") => { "Java ", "21", "Rules!" }
     */    
    public static Stream<String> toStream(String... strings) {
        return Exercises.replaceThisWithSolution();
    }
}