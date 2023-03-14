package com.att.tlv.training.java8.answers.optional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Random;
import java.util.logging.Logger;

import com.att.tlv.training.java8.exercises.data.Person;

public class OptionalsAnswer {
    
    public static OptionalInt findLengthOfLongestName(List<Person> persons) {
        return persons.stream()
            .mapToInt(p -> p.getName().length())
            .max();          
    }
    
    public static OptionalDouble findAverageId(List<Person> persons) {
        return persons.stream()
                .mapToLong(Person::getId)
                .average();          
    }
    
    public static Optional<Person> findFirstCentenarian(List<Person> persons) {
        return persons.stream()
                .filter(p -> p.getAge() >= 100)
                .findFirst();          
    }
    
    /**
     * Example:
     * 1. Optional.of("Hello World") -> "Hello World"
     * 2. Optional.of("Hello world") -> "Hello world"
     * 3. Optional.of("Hello there") -> Optional.empty()
     * 3. Optional.empty() -> Optional.empty()
     */
    public static Optional<String> getStringIfItContainsTheLetterW(Optional<String> str) {
        return str.filter(OptionalsAnswer::containsW);      
    }
    
    private static boolean containsW(String s) {
        return s.toLowerCase().contains("w");
    }
    
    public static long getNumberOrThrowIllegalArgumentException(OptionalLong number) {
        return number.orElseThrow(IllegalArgumentException::new);   
    }
    
    
    /**
     * Use the specified {@code Random } only if the specified number is empty.
     */
    public static double getNumberOrRandom(OptionalDouble number, Random random) {
        return number.orElseGet(() -> random.nextDouble());   
    }
    
    /**
     * If the specified dateTime is not empty, log its string representation at info level (logger.info())
     */
    public static void logInfoIfPresent(Optional<LocalDateTime> dateTime, Logger logger) {
        dateTime.ifPresent(dt -> logger.info(dt.toString()));
    }
}
