package com.att.tlv.training.java.lambdas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static java.util.function.Predicate.isEqual;
import static java.util.function.Predicate.not;

public class FunctionalInterfaces {
    
    public void runnable() {
        // Lambda
        Runnable runnable = () -> System.out.println("Hello!");
        
        // Reference to an instance method in "this"
        runnable = this::sayHello;
        
        // Execute it
        runnable.run();
    }
    
    private void sayHello() {
        System.out.println("Hello!");
    }
    
    public void consumer() {
        // Lambda
        Consumer<String> consumer = s -> System.out.println(s);
        
        // Reference to a static method
        consumer = FunctionalInterfaces::sayIt;
        
        // Execute it
        consumer.accept("Hello!");    
        
        // Specialized types to avoid boxing costs
        IntConsumer intConsumer = (int v) -> System.out.println(v * v);
        intConsumer.accept(10);
        
        LongConsumer longConsumer = v -> System.out.println(v * v);
        longConsumer.accept(10L);

        DoubleConsumer doubleConsumer = v -> System.out.println(v * v);
        doubleConsumer.accept(10.5d);
    }
    
    private static void sayIt(String it) {
        System.out.println(it);
    }
    
    public void supplier() {
        // Define
        Supplier<LocalDate> supplier = () -> LocalDate.now();

        // Execute
        LocalDate now = supplier.get();
        
        // Specialized types to avoid boxing costs (LongSupplier, DoubleSupplier, BooleanSupplier)
        IntSupplier intSupplier = () -> 42;
        int theAnswer = intSupplier.getAsInt();
    }
    
    public void function() {
        // Define
        Function<LocalDateTime, String> dateTimetoString = ldt -> ldt.toString();
        
        // Execute 
        String now = dateTimetoString.apply(LocalDateTime.now());
        
        // Now we can understand the 4th method reference type better! The missing argument is added by the compiler (ldt -> ldt.toString())
        dateTimetoString = LocalDateTime::toString;
        
        // 3 specialized family types to avoid boxing costs:
        // 1. Primitive type to reference type (IntFunction, DoubleFunction)
        LongFunction<String> longToString = val -> String.valueOf(val);
        String longAsString = longToString.apply(10L);
        
        // 2. Reference type to primitive type (ToLongFunction, ToDoubleFunction)
        ToIntFunction<String> calculateLength = s -> s.length();
        int length = calculateLength.applyAsInt("Hello!");

        // 3. Primitive type to primitive type:
        //      IntToLongFunction, IntToDoubleFunction
        //      LongToIntFunction, LongToDoubleFunction
        //      DoubleToIntFunction, DoubleToLongFunction)
        IntToDoubleFunction half = v -> v / 2d;
        double result = half.applyAsDouble(5);
    }

    public static void defaultConsumerMethods() {
        Consumer<String> sayIt = FunctionalInterfaces::sayIt;
        Consumer<String> sayItTwice = sayIt.andThen(FunctionalInterfaces::sayIt);

        sayItTwice.accept("Hello!");
    }

    public static void defaultFunctionMethods() {
        Function<Integer, String> intToString = val -> Integer.toString(val);
//        Function<String, Integer> stringLength = String::length;

        Function<Integer, Integer> intToNumOfDigits = intToString.andThen(String::length);
        var value = 12345;
        System.out.println(value + " => " + intToNumOfDigits.apply(value));

        Function<String, String> stringToLengthAsString = intToString.compose(String::length);
        var str = "A string of 25 characters";
        System.out.printf(str + " => " + stringToLengthAsString.apply(str));
    }

    public static void defaultPredicateMethods() {
        var names = List.of("Alice", "", "Bob", "", "Carl");
        var names1 = new ArrayList<>(names);
        names1.removeIf(String::isEmpty);
        // [Alice, Bob, Carl]

        var names2 = new ArrayList<>(names);
        names2.removeIf(not(String::isEmpty));
        // [, ]

        var names3 = new ArrayList<>(names);
        names3.removeIf(isEqual("Bob"));
        // [Alice, , , Carl]

        var names4 = new ArrayList<>(names);
        names4.removeIf(isEqual("Bob").negate());
        // [Bob]

        var names5 = new ArrayList<>(names);
        names5.removeIf(isEqual("Bob").or(isEqual("Carl")));
        // [Alice, , ]

        var names6 = new ArrayList<>(names);
        names6.removeIf(not(FunctionalInterfaces::startsWithA).and(s -> s.length() > 3));
        // [Alice, , Bob, ]
    }

    private static boolean startsWithA(String str) {
        return str.startsWith("A");
    }

    public static void main(String[] args) {
        FunctionalInterfaces.defaultPredicateMethods();
    }
}
