package com.att.tlv.training.java.streams;

import java.util.IntSummaryStatistics;
import java.util.List;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

public class MoreCollectors {
    
    private final List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Allen");
    
    public static void main(String[] args) {
        new MoreCollectors().join();
    }
    
    public void join() {
        // Join strings specifying a delimiter
        String csv = names.stream()
                .collect(joining(", "));
        
        
        
        System.out.println(csv);
        
        // With prefix & suffix
        csv = names.stream()
                .collect(joining(", ", "{", "}"));
        
        System.out.println(csv);
    }
    
    public void reduceCount() {
        //Count the names with exactly five letters
        long count = names.stream()
                .filter(s -> s.length() == 5)
                .collect(reducing(0L, s -> 1L, Long::sum));

        System.out.println(count);


        // Or for this specific reduction, we can do this:
        count = names.stream()
                .filter(s -> s.length() == 5)
                .collect(counting());

        // Or better yet:
        count = names.stream()
                .filter(s -> s.length() == 5)
                .mapToLong(name -> 1L)
                .sum();

        // Which is better expressed as:
        count = names.stream()
                .filter(s -> s.length() == 5)
                .count();
    }
    
    public void reduceSum() {
        // Total number of letters of names with 5 letters or more
        int sum = names.stream()
                .filter(s -> s.length() >= 5)
                .map(String::length)
                .collect(reducing(0, Integer::sum));
        
        System.out.println(sum);
        
        // The mapping function can be moved into the reduction
        sum = names.stream()
                .filter(s -> s.length() >= 5)
                .collect(reducing(0, String::length, Integer::sum));
        
        System.out.println(sum);     
        
        // Or for this specific reduction, we can do this:
        sum = names.stream()
                .filter(s -> s.length() >= 5)
                .collect(summingInt(String::length));        
        
        // summingDouble, summingLong...
        System.out.println(sum);     
    }
    
    
    public void average() {
        // Average string length
        double average = names.stream()
                .collect(averagingInt(String::length));
        
        // averagingLong, averagingDouble...
        System.out.println(average);  
    }
    
    public void summarize() {
        // statistics of string length
        IntSummaryStatistics stats = names.stream()
                .collect(summarizingInt(String::length));   
        
        // summarizingLong, summarizingDouble...
        System.out.println(stats);
    }
}
