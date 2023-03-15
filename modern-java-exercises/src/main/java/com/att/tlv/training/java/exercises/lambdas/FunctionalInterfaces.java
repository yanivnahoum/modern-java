package com.att.tlv.training.java.exercises.lambdas;

import com.att.tlv.training.java.exercises.data.Person;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static com.att.tlv.training.java.exercises.Exercises.replaceThisWithSolution;

public class FunctionalInterfaces {

    // Runnable

    public Runnable writeHelloToStdout() {
        return replaceThisWithSolution();
    }

    // Consumer

    public Consumer<String> writeToStdout() {
        return replaceThisWithSolution();
    }

    public DoubleConsumer writeCosineToStdOut() {
        return replaceThisWithSolution();
    }

    // Supplier

    public Supplier<Thread> buildThread() {
        return replaceThisWithSolution();
    }

    public IntSupplier getRandomInt() {
        return replaceThisWithSolution();
    }

    // Function

    public Function<Person, String> getPersonName() {
        return replaceThisWithSolution();
    }

    public LongFunction<String> numAsString() {
        return replaceThisWithSolution();
    }

    public ToIntFunction<Person> getPersonAge() {
        return replaceThisWithSolution();
    }

    public LongToDoubleFunction divideByTwoPointFive() {
        return replaceThisWithSolution();
    }
}
