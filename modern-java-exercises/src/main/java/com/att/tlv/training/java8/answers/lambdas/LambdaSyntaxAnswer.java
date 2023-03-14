package com.att.tlv.training.java8.answers.lambdas;

import java.util.function.Predicate;

import com.att.tlv.training.java8.exercises.data.Person;

public class LambdaSyntaxAnswer {  
    
    /**
     * Builds a {@code Predicate} that returns true if the given person's id is equal to the
     * id specified, and false otherwise.
     */
    public static Predicate<Person> buildIdEquals(long id) {
        return p -> p.getId() == id;
    }

    /**
     * Builds a {@code Predicate} that returns true if the given person's name starts with the
     * prefix specified, and false otherwise.
     */
    public static Predicate<Person> buildNameStartsWith(String prefix) {
        return p -> p.getName().startsWith(prefix);
    }
}
