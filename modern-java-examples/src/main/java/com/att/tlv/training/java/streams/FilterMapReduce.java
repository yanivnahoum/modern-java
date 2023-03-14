package com.att.tlv.training.java.streams;

import com.att.tlv.training.java.data.Player;
import com.att.tlv.training.java.data.Players;

import java.util.Arrays;
import java.util.List;

public class FilterMapReduce {
    
    public void sumOfDoubles() {
        // Find the sum of double the values in the list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        
        // Let's do it the imperative way:
        int result = 0;
        for (int e : numbers) {
            result += e * 2;
        }
        System.out.println(result);
        
        
        
        // And now the declarative (fuctional) way:
        result = numbers.stream()
                    .map(e -> e * 2)
                    .reduce(0, (a , b) -> a + b);
        
        // Or this:
        result = numbers.stream()
                .map(e -> e * 2)
                .reduce(0, Integer::sum);
        
        // And even better:
        result = numbers.stream()
                .mapToInt(e -> e * 2)
                .sum();
        
//        System.out.println(result);
    }
    
    public void findOldestPlayer() {
        // Find the age of the oldest player that makes more than $80,000
        // If no such player exists, return -1
        final int DEFAULT = -1;
        final double MIN_SALARY = 80_000d;
        
        
        int oldestAge = DEFAULT;
        for (Player e : Players.getAll()) {
            if (e.getSalary() > MIN_SALARY) {
                oldestAge = Math.max(oldestAge, e.getAge());
            }
        }
        
        
//        oldestAge = Players.getAll()
//                .stream()
//                .filter(e -> e.getSalary() > MIN_SALARY)
//                .map(e -> e.getAge())
//                .reduce(DEFAULT, Math::max);
        
//        long start = System.nanoTime();
        
       // Better yet:
       
//        oldestAge = Players.getAll()
//                .stream()
//                .filter(e -> e.getSalary() > MIN_SALARY)
//                .mapToInt(Player::getAge)
//                .max()
//                .orElse(DEFAULT);

        // But how performant are we? Are we executing more operations?
        // And how can we debug???
        
//      debugging:
//        .peek(System.out::println)        
        
//        long total = System.nanoTime() - start;     
//        System.out.println("Time: " + NANOSECONDS.toMillis(total));
        System.out.println(oldestAge);
    }
    
    public static void main(String[] args) {
        new FilterMapReduce().sumOfDoubles();
    }
}
