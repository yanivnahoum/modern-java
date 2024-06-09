package com.att.tlv.training.java.switches;

class PatternMatchingForSwitch {
    interface Animal {}

    final class Cat implements Animal {
        String meow() {
            return "meow";
        }
    }

    final class Dog implements Animal {
        String bark() {
            return "woof";
        }
    }

    final class Bird implements Animal {
        String chirp() {
            return "chirp";
        }
    }

    String classicCommunicate(Animal animal) {
        String message = null;
        if (animal instanceof Dog) {
            var dog = (Dog) animal;
            message = dog.bark();
        } else if (animal instanceof Cat) {
            var cat = (Cat) animal;
            message = cat.meow();
        } else if (animal instanceof Bird) {
            var bird = (Bird) animal;
            message = bird.chirp();
        }
        return message;
    }

    String java17Communicate(Animal animal) {
        String message = null;
        if (animal instanceof Dog dog) {
            message = dog.bark();
        } else if (animal instanceof Cat cat) {
            message = cat.meow();
        } else if (animal instanceof Bird bird) {
            message = bird.chirp();
        }

        if (message == null) {
            throw new IllegalArgumentException("Unknown");
        }
        return message;
    }

    String communicate(Animal animal) {
        return switch (animal) {
            case Cat cat -> cat.meow();
            case Dog dog -> dog.bark();
            case Bird bird -> bird.chirp();
            default -> throw new IllegalArgumentException("Unknown");
        };
    }
}

