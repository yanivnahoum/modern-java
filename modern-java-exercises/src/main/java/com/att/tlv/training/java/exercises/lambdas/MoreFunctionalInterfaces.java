package com.att.tlv.training.java.exercises.lambdas;

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

import static com.att.tlv.training.java.exercises.Exercises.replaceThisWithSolution;

public class MoreFunctionalInterfaces {

    // Function

    public LongUnaryOperator increment() {
        return replaceThisWithSolution();
    }

    // BiConsumer

    public BiConsumer<String, String> writeConcatenationToStdout() {
        return replaceThisWithSolution();
    }

    public ObjIntConsumer<Person> writePersonAgeInXYearsToStdout() {
        return replaceThisWithSolution();
    }

    // BiFunction

    public BiFunction<String, Integer, String> substringStartingAtIndex() {
        return replaceThisWithSolution();
    }

    public ToIntBiFunction<String, String> indexOfString2InString1() {
        return replaceThisWithSolution();
    }

    public IntBinaryOperator add() {
        return replaceThisWithSolution();
    }

    /**
     * @return a new runnable that runs the specified runnables one after the other.
     */
    public BinaryOperator<Runnable> compose() {
        return replaceThisWithSolution();
    }

    // Predicate

    public Predicate<Person> isNameExactlyDan() {
        return replaceThisWithSolution();
    }

    public IntPredicate isEven() {
        return replaceThisWithSolution();
    }

    public BiPredicate<Person, String> isPersonAgeOver40AndIsStringNotNull() {
        return replaceThisWithSolution();
    }
}
