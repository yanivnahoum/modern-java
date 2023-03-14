package com.att.tlv.training.java.exercises.lambdas;

import com.att.tlv.training.java.exercises.Exercises;
import com.att.tlv.training.java.exercises.data.Person;
import com.google.common.base.Function;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntSupplier;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class FunctionalInterfaces {

    // Runnable

    public Runnable writeHelloToStdout() {
        return Exercises.replaceThisWithSolution();
    }

    // Consumer

    public Consumer<String> writeToStdout() {
        return Exercises.replaceThisWithSolution();
    }

    public DoubleConsumer writeCosineToStdOut() {
        return Exercises.replaceThisWithSolution();
    }

    // Supplier

    public Supplier<Thread> buildThread() {
        return Exercises.replaceThisWithSolution();
    }

    public IntSupplier getRandomInt() {
        return Exercises.replaceThisWithSolution();
    }

    // Function

    public Function<Person, String> getPersonName() {
        return Exercises.replaceThisWithSolution();
    }

    public LongFunction<String> numAsString() {
        return Exercises.replaceThisWithSolution();
    }

    public ToIntFunction<Person> getPersonAge() {
        return Exercises.replaceThisWithSolution();
    }

    public LongToDoubleFunction divideByTwoPointFive() {
        return Exercises.replaceThisWithSolution();
    }
}
