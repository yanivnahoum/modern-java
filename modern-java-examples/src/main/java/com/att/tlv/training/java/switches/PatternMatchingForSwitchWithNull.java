package com.att.tlv.training.java.switches;

class PatternMatchingForSwitchWithNull {
    interface Animal {}

    static final class Cat implements Animal {
        String meow() {
            return "meow";
        }
    }

    static final class Dog implements Animal {
        String bark() {
            return "woof";
        }
    }

    static final class Bird implements Animal {
        String chirp() {
            return "chirp";
        }
    }

    String java17Communicate(Animal animal) {
        String message = null;
        if (animal instanceof Dog dog) {
            message = dog.bark();
        } else if (animal instanceof Cat cat) {
            message = cat.meow();
        } else if (animal instanceof Bird bird) {
            message = bird.chirp();
        } else if (animal == null) {
            // We now handle the null case
            message = "N/A";
        }

        if (message == null) {
            throw new IllegalArgumentException("Unknown");
        }
        return message;
    }

    String communicateWithNull(Animal animal) {
        // Traditionally switch would throw NPE if animal is null, so we need to handle it separately
        if (animal == null) {
            return "N/A";
        }
        return switch (animal) {
            case Cat cat -> cat.meow();
            case Dog dog -> dog.bark();
            case Bird bird -> bird.chirp();
            default -> throw new IllegalStateException("Unknown");
        };
    }

    String communicate(Animal animal) {
        return switch (animal) {
            case Cat cat -> cat.meow();
            case Dog dog -> dog.bark();
            case Bird bird -> bird.chirp();
            // As of Java 21, we can now handle the null case inside the switch expression
            case null -> "N/A";
            // Without this, we get a compiler error: 'switch' expression does not cover all possible input values
            default -> throw new IllegalStateException("Unknown");
        };
    }
}

