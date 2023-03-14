package com.att.tlv.training.java8.answers.lambdas;

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

import com.att.tlv.training.java8.exercises.data.Person;

public class MoreFunctionalInterfacesAnswer {

    // Function

    public LongUnaryOperator increment() {
        return Math::incrementExact;
    }
    
    // BiConsumer
    
    public BiConsumer<String, String> writeConcatenationToStdOut() {
        return (s1, s2) -> System.out.println(s1.concat(s2));
    }

    public ObjIntConsumer<Person> writePersonAgeInXYearsToStdout() {
        return (p, v) -> System.out.println(p.getAge() + v);
    }
    
    // BiFunction
    
    public BiFunction<String, Integer, String> substringStartingAtIndex() {
        return String::substring;
    }
    
    public ToIntBiFunction<String, String> indexOfString2InString1() {
        return String::indexOf;
    }
    
    public IntBinaryOperator add() {
        return Math::addExact;
    }

    /**
     * @return a new runnable that runs the specified runnables one after the other.
     */
    public BinaryOperator<Runnable> compose() {
        return (r1, r2) -> () -> {
            r1.run();
            r2.run();
        };
    }
    
    // Predicate
    
    public Predicate<Person> getIsNameExactlyDan() {
        return p -> "Dan".equals(p.getName());
    }
    
    public IntPredicate isEven() {
        return i -> i % 2 == 0;
    }
    
    public BiPredicate<Person, String> getIsPersonAgeOver40AndIsStringNotNull() {
        return (p, s) -> p.getAge() > 40 && s != null;
    }
}