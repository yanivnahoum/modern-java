package com.att.tlv.training.java.streams;

import com.att.tlv.training.java.data.Players;

import java.util.List;

public class FilterMapReduce {

    public void sumOfDoubles() {
        // Find the sum of double the values in the list
        var numbers = List.of(1, 2, 3, 4, 5, 6);

        // Let's do it the imperative way:
        int sum = 0;
        for (int e : numbers) {
            sum += e * 2;
        }
        System.out.println(sum);
        
        
        
        // And now the declarative (functional) way:
        sum = numbers.stream()
                .map(e -> e * 2)
                .reduce(0, (result, element) -> result + element);
        
        // Or this:
        sum = numbers.stream()
                .map(e -> e * 2)
                .reduce(0, Integer::sum);
        
        // And even better:
        sum = numbers.stream()
                .mapToInt(e -> e * 2)
                .sum();

//        System.out.println(sum);
    }
    
    public void findOldestPlayer() {
        // Find the age of the oldest player that makes more than $80,000
        // If no such player exists, return -1
        final int DEFAULT = -1;
        final double MIN_SALARY = 80_000d;

        int oldestAge = DEFAULT;
        for (var player : Players.getAll()) {
            if (player.salary() > MIN_SALARY) {
                oldestAge = Math.max(oldestAge, player.age());
            }
        }


//        oldestAge = Players.getAll()
//                .stream()
//                .filter(player -> player.salary() > MIN_SALARY)
//                .map(player -> player.age())
//                .reduce(DEFAULT, Math::max);

//        long start = System.nanoTime();

        // Better yet:

//        oldestAge = Players.getAll()
//                .parallelStream()
//                .filter(e -> e.salary() > MIN_SALARY)
//                .mapToInt(Player::age)
//                .peek(System.out::println)
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
        new FilterMapReduce().findOldestPlayer();
    }
}
