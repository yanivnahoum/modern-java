package com.att.tlv.training.java.lambdas;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        
        DoubleConsumer doubleConsumer = (double v) -> System.out.println(v * v);
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
        LongFunction<String> longToString = i -> String.valueOf(i);
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
}
