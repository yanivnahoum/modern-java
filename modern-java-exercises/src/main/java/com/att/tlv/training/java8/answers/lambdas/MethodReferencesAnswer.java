package com.att.tlv.training.java8.answers.lambdas;

import java.util.function.Predicate;

import com.att.tlv.training.java8.exercises.data.Person;

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
        return person.getAge() < AGE_OF_MAJORITY;
    }
}
