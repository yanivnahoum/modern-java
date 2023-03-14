package com.att.tlv.training.java.exercises.optional;

import com.att.tlv.training.java.exercises.Exercises;
import com.att.tlv.training.java.exercises.data.Person;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Random;
import java.util.logging.Logger;

public class Optionals {
    
    public static OptionalInt findLengthOfLongestName(List<Person> persons) {
        return Exercises.replaceThisWithSolution();     
    }
    
    public static OptionalDouble findAverageId(List<Person> persons) {
        return Exercises.replaceThisWithSolution();     
    }
    
    public static Optional<Person> findFirstCentenarian(List<Person> persons) {
        return Exercises.replaceThisWithSolution();     
    }
    
    /**
     * Example:
     * 1. Optional.of("Hello World") -> "Hello World"
     * 2. Optional.of("Hello world") -> "Hello world"
     * 3. Optional.of("Hello there") -> Optional.empty()
     * 3. Optional.empty() -> Optional.empty()
     */
    public static Optional<String> getStringIfItContainsTheLetterW(Optional<String> str) {
        return Exercises.replaceThisWithSolution();     
    }
    
    public static long getNumberOrThrowIllegalArgumentException(OptionalLong number) {
        return Exercises.replaceThisWithSolution();     
    }
    
    /**
     * Use the specified {@code Random } only if the specified number is empty.
     */
    public static double getNumberOrRandom(OptionalDouble number, Random random) {
        return Exercises.replaceThisWithSolution();     
    }
    
    /**
     * If the specified dateTime is not empty, log its string representation at info level (logger.info())
     */
    public static void logInfoIfPresent(Optional<LocalDateTime> dateTime, Logger logger) {
        Exercises.replaceThisWithSolution();     
    }
}
