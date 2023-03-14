package com.att.tlv.training.java.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MethodReference {
    
    public void foo() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        // Simple lambda calling an existing method with the correct signature (void run())
        executor.execute(() -> doSomething());
        
        // 1. Reference to an instance method of a specific object
        executor.execute(this::doSomething);
        
        // 2. Reference to a static method
        executor.execute(MethodReference::doSomethingElse);
        
        // cleanup
        shutdown(executor);
    }
    
    private void doSomething() {
        System.out.println(Thread.currentThread().getName() + ": doSomething");
    }
    
    private static void doSomethingElse() {
        System.out.println(Thread.currentThread().getName() + ": doSomethingElse");
    }    
    
    public void moo() {
        List<String> names = Arrays.asList("a", "b", "c");
        
        // Calling the constructor with a lambda
        names.forEach(s -> new Printer(s));
        
        // 3. Reference to a constructor
        names.forEach(Printer::new);
    }
    
    
    public void bar() {
        List<String> names = new ArrayList<>();
        names.add("carl");
        names.add("");
        names.add("alice");
        names.add("");
        names.add("Bob");
        names.add("");
        
//        names.removeIf(s -> s.isEmpty());
        
        // 4. Reference to an instance method of a arbitrary object supplied later
        names.removeIf(String::isEmpty);
        
        System.out.println(names);
    }
    
    public void shutdown(ExecutorService executor) {
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
    
    static class Printer {
        
        public Printer(String text) {
            System.out.println(text);
        }
        public Printer(String text, String text2) {
            System.out.println(text + text2);
        }
    }
    
    public static void main(String[] args) {
        MethodReference methodReference = new MethodReference();
        methodReference.bar();
    }
}
