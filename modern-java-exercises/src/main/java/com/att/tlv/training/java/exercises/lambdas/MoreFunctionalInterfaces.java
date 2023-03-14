package com.att.tlv.training.java.exercises.lambdas;

import com.att.tlv.training.java.exercises.Exercises;
import com.att.tlv.training.java.exercises.data.Person;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;

public class MoreFunctionalInterfaces {

    // Function

    public LongUnaryOperator increment() {
        return Exercises.replaceThisWithSolution();
    }

    // BiConsumer

    public BiConsumer<String, String> writeConcatenationToStdOut() {
        return Exercises.replaceThisWithSolution();
    }

    public ObjIntConsumer<Person> writePersonAgeInXYearsToStdout() {
        return Exercises.replaceThisWithSolution();
    }

    // BiFunction

    public BiFunction<String, Integer, String> substringStartingAtIndex() {
        return Exercises.replaceThisWithSolution();
    }

    public ToIntBiFunction<String, String> indexOfString2InString1() {
        return Exercises.replaceThisWithSolution();
    }

    public IntBinaryOperator add() {
        return Exercises.replaceThisWithSolution();
    }

    /**
     * @return a new runnable that runs the specified runnables one after the other.
     */
    public BinaryOperator<Runnable> compose() {
        return Exercises.replaceThisWithSolution();
    }

    // Predicate

    public Predicate<Person> getIsNameExactlyDan() {
        return Exercises.replaceThisWithSolution();
    }

    public IntPredicate isEven() {
        return Exercises.replaceThisWithSolution();
    }

    public BiPredicate<Person, String> getIsPersonAgeOver40AndIsStringNotNull() {
        return Exercises.replaceThisWithSolution();
    }
}
