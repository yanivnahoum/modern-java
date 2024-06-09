package com.att.tlv.training.java.switches;

class PatternMatchingForSwitchWithSealedTypesAndRefinements {
    sealed interface Animal {}

    static final class Cat implements Animal {
        String meow() {
            return "meow";
        }
    }

    record Dog(int barksPerMinute) implements Animal {
        String bark() {
            return "woof";
        }
    }

    static final class Bird implements Animal {
        String chirp() {
            return "chirp";
        }
    }

    String communicateWithSealedTypes(Animal animal) {
        return switch (animal) {
            case Cat cat -> cat.meow();
            case Dog dog -> dog.bark();
            case Bird bird -> bird.chirp();
        };
    }

    String communicateWithSealedTypesAndMultipleLabels(Animal animal) {
        return switch (animal) {
            // Multiple labels only make sense without the pattern variables
            case Cat _, Dog _ -> "pet";
            case Bird bird -> bird.chirp();
        };
    }

    // Let's refine our cases:
    String caseRefinementWithIf(Animal animal) {
        return switch (animal) {
            case Cat cat -> cat.meow();
            case Dog dog -> {
                String bark = dog.bark();
                // Back to if statements again :-(
                if (dog.barksPerMinute() >= 10) {
                    bark = bark.toUpperCase();
                } else if (dog.barksPerMinute() > 3) {
                    bark = capitalize(bark);
                }
                yield bark;
            }
            case Bird bird -> bird.chirp();
        };
    }

    // Guarded case labels to the rescue!
    String communicate(Animal animal) {
        return switch (animal) {
            case Cat cat -> cat.meow();
            // This is a guarded case label
            case Dog dog when dog.barksPerMinute() >= 10 -> dog.bark().toUpperCase();
            case Dog dog when dog.barksPerMinute() > 3 -> capitalize(dog.bark());
            // The compiler checks for dominance of case labels
            case Dog dog -> dog.bark();
            case Bird bird -> bird.chirp();
        };
    }

    private static String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}

