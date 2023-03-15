package com.att.tlv.training.java.exercises.lambdas;

import com.att.tlv.training.java.exercises.data.Person;

import java.util.function.Predicate;

import static com.att.tlv.training.java.exercises.Exercises.replaceThisWithSolution;

public class MethodReferences {

    static final int AGE_OF_MAJORITY = 18;

    /**
     * Builds a {@code Predicate} that returns true if the given string is empty.
     */    
    public static Predicate<String> buildIsEmpty() {
        // TODO return a method reference here!
        return replaceThisWithSolution();
    }
    
    /**
     * Builds a {@code Predicate} that returns true if the given person is a minor (the person's
     * age is less than 18), and false otherwise.
     */    
    public static Predicate<Person> buildIsAMinor() {
        // TODO Add a private method isAMinor() and return a reference to it.
        return replaceThisWithSolution();
    }
}
  