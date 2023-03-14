package com.att.tlv.training.java8.lambdas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class MoreFunctionalInterfaces {
    
    public void more() {
        BiConsumer<String, String> printFormatted = 
                (format, arg) -> System.out.println(String.format(format, arg));
        // + specialized types: ObjIntConsumer, ObjLongConsumer, ObjDoubleConsumer
        
        BiFunction<LocalDate, LocalTime, LocalDateTime> dateAtTime = 
                (date, time) -> date.atTime(time);
        dateAtTime = LocalDate::atTime;
        // + specialized type ToIntBiFunction, ToLongBiFunction, ToDoubleBiFunction
        
        Predicate<String> isEmpty = String::isEmpty;
        boolean empty = isEmpty.test("");
        // + specialized types: IntPredicate, LongPredicate, DoublePredicate 
        
        
        // Same input & return values:
        Function<String, String> echo = s -> s;
        echo = Function.identity();
        
        // Otherwise know as:
        UnaryOperator<String> op = s -> s;
        op = UnaryOperator.identity();
        // + specialized type IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator
        
        
        // Same TWO input args & return values:
        BiFunction<String, String, String> concat = (s1, s2) -> s1 + s2;
        concat = String::concat;
        
        BinaryOperator<String> biOp = String::concat;
        // + specialized type IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator
    }
}
