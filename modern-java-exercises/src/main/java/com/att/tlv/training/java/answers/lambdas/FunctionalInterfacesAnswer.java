package com.att.tlv.training.java.answers.lambdas;

import com.att.tlv.training.java.exercises.data.Person;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class FunctionalInterfacesAnswer {

    private final Random random = new Random();

    // Runnable 
    
    public Runnable writeHelloToStdout() {
        return () -> System.out.println("Hello");
    }
    
    // Consumer

    public Consumer<String> writeToStdout() {
        return System.out::println;
    }

    public DoubleConsumer writeCosineToStdout() {
        return d -> System.out.println(Math.cos(d));
    }
    
    // Supplier

    public Supplier<Thread> buildThread() {
        return Thread::new;
    }

    public IntSupplier getRandomInt() {
        return random::nextInt;
    }
    
    // Function

    public Function<Person, String> getPersonName() {
        return Person::name;
    }

    public LongFunction<String> numAsString() {
        return String::valueOf;
    }

    public ToIntFunction<Person> getPersonAge() {
        return Person::age;
    }

    public LongToDoubleFunction divideByTwoPointFive() {
        return l -> l / 2.5;
    }
}
