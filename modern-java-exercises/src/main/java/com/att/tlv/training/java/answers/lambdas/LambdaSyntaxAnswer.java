package com.att.tlv.training.java.answers.lambdas;

import com.att.tlv.training.java.exercises.data.Person;

import java.util.function.Predicate;

public class LambdaSyntaxAnswer {

    /**
     * Builds a {@code Predicate} that returns true if the given person's id is equal to the
     * id specified, and false otherwise.
     */
    public static Predicate<Person> buildIdEquals(long id) {
        return p -> p.id() == id;
    }

    /**
     * Builds a {@code Predicate} that returns true if the given person's name starts with the
     * prefix specified, and false otherwise.
     */
    public static Predicate<Person> buildNameStartsWith(String prefix) {
        return p -> p.name().startsWith(prefix);
    }
}
