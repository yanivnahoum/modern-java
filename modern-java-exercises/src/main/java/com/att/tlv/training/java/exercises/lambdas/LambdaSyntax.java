package com.att.tlv.training.java.exercises.lambdas;

import com.att.tlv.training.java.exercises.data.Person;

import java.util.function.Predicate;

import static com.att.tlv.training.java.exercises.Exercises.replaceThisWithSolution;

public class LambdaSyntax {

    /**
     * Builds a {@code Predicate} that returns true if the given string is not empty.
     * Follow this example and solve the subsequent exercises using lambda expressions.
     */
    public static Predicate<String> buildIsNotEmpty() {
        // A Predicate<T> represents a predicate (boolean-valued function) of one argument.
        // This is a functional interface whose functional method is: boolean test(T obj)
        
        // This is how to create an anonymous class that implements Predicate<String>
        Predicate<String> notEmpty = new Predicate<String>() {
            
            @Override
            public boolean test(String str) {
                return !str.isEmpty();
            }
        };
        
        // And here's the same code as lambda expression:
        notEmpty = s -> !s.isEmpty();
                
        return notEmpty;
    }
    
    /**
     * Builds a {@code Predicate} that returns true if the given person's id is equal to the
     * id specified, and false otherwise.
     */    
    public static Predicate<Person> buildIdEquals(long id) {
        return replaceThisWithSolution();
    }
    
    /**
     * Builds a {@code Predicate} that returns true if the given person's name starts with the
     * prefix specified, and false otherwise.
     */    
    public static Predicate<Person> buildNameStartsWith(String prefix) {
        return replaceThisWithSolution();
    }
}
  