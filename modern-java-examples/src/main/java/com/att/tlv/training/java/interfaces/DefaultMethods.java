package com.att.tlv.training.java.interfaces;

public class DefaultMethods {
    public static void main(String[] args) {
        System.out.println(new SomeClass1().whoAmI());
    }
}

interface First {
    
    default String whoAmI() {
        return "First";
    }
}

interface Second {
    
    default String whoAmI() {
        return "Second";
    }
}

class SomeClass1 implements First {

    // No implementation required!
}

class SomeClass2 implements First, Second {
    
    @Override
    public String whoAmI() {
//         return Second.super.whoAmI();
        return getClass().getSimpleName();
    }
}


@FunctionalInterface
interface Action<T> {
    
    void accept(T t);
    
    default Action<T> andThen(Action<T> after) {
        return (T t) -> { accept(t); after.accept(t); };
    }
    
    @Override
    boolean equals(Object obj);
}
