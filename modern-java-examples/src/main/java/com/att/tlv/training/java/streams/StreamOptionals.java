package com.att.tlv.training.java.streams;

import com.att.tlv.training.java.data.Player;
import com.att.tlv.training.java.data.Players;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamOptionals {

    public static void main(String[] args) {
        new StreamOptionals().printAnyOddNumberGreaterThanFour();
    }

    public void findOldestPlayerUsingReduce() {
        OptionalInt oldestPlayer = Players.getAll()
                .stream()
                .mapToInt(Player::age)
                .reduce(Integer::max);
    }

    public void findOldestPlayerUsingMax() {
        OptionalInt oldestPlayer = Players.getAll()
                .stream()
                .mapToInt(Player::age)
                .max();
    }

    public void findYoungestPlayer() {
        OptionalInt youngestPlayer = Players.getAll()
                .stream()
                .mapToInt(Player::age)
                .min();
    }

    public void printFirstOddNumberGreaterThanFour() {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        IntStream.of(numbers)
                .filter(n -> n > 4)
                .filter(n -> n % 2 == 1)
                .findFirst()
                .ifPresent(System.out::println);
    }

    public void printAnyOddNumberGreaterThanFour() {
        IntStream.rangeClosed(1, 10)
                .filter(n -> n > 4)
                .filter(n -> n % 2 == 1)
                .findAny()
                .ifPresent(System.out::println);
        
        // Same result as findFirst() in sequential ordered streams.
        // May be differnt when adding parallel()
    }
}
