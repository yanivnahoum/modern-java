package com.att.tlv.training.java.answers.lambdas;

import com.att.tlv.training.java.exercises.data.Person;

import java.util.function.Predicate;

public class MethodReferencesAnswer {

    public static final int AGE_OF_MAJORITY = 18;

    /**
     * Builds a {@code Predicate} that returns true if the given string is empty.
     */    
    public static Predicate<String> buildIsEmpty() {
        return String::isEmpty;
    } 
    
    /**
     * Builds a {@code Predicate} that returns true if the given person is a minor (the person's
     * age is less than 18), and false otherwise.
     */
    public static Predicate<Person> buildIsAMinor() {
        return MethodReferencesAnswer::isAMinor;
    }
    
    private static boolean isAMinor(Person person) {
        return person.age() < AGE_OF_MAJORITY;
    }
}
