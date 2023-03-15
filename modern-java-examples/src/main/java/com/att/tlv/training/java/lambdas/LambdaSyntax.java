package com.att.tlv.training.java.lambdas;

import java.util.List;
import java.util.function.Consumer;

public class LambdaSyntax {
    
    public void iteration() {

        var numbers = List.of(1, 2, 3, 4, 5, 6);

        // External
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        
        
        // External
        for (int num : numbers) {
            System.out.println(num);
        }
        
        
        
        
        

        // Internal
        numbers.forEach(new Consumer<Integer>() {

            @Override
            public void accept(Integer value) {
                System.out.println(value);
            }

        });
        
        
        
        

        numbers.forEach((Integer value) -> {
            System.out.println(value);
        });

        
        
        
        
        numbers.forEach((value) -> System.out.println(value));
        
        
        
        

        numbers.forEach(v -> System.out.println(v));


        numbers.forEach(System.out::println);
    }

    private final List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Allen");
    public void demo() {

        // Main syntax: params -> body
        names.forEach((String str) -> System.out.println(str));

        // Declaring the types of the parameters is optional.
        names.forEach((str) -> System.out.println(str));

        // Using parentheses around the parameter is optional
        // if you have only one parameter:
        // 1 parameter
        names.forEach(str -> System.out.println(str));
        // 0 parameters
        new Thread(() -> System.out.println());
        // 2 parameters
        names.sort((s1, s2) -> {
            return s1.compareTo(s2);
        });

        // Using curly braces and semicolon is optional
        // (unless you need multiple statements).
        names.sort((s1, s2) -> s1.compareTo(s2));

        // The return keyword is optional only if you have a
        // single expression that returns a value.
        names.sort((s1, s2) -> {
            System.out.println("In comparator!");
            return s1.compareTo(s2);
        });

    }
    
    public static void main(String[] args) {
        new LambdaSyntax().anonymousClassScope();
    }
    
    public void anonymousClassScope() {
        // Anonymous class scope:
        names.forEach(new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(toString());
                System.out.println(this);
            }
        });        
    }
    
    public void lambdaScope() {
        names.forEach(s -> System.out.println(toString()));
        names.forEach(s -> System.out.println(this));
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}