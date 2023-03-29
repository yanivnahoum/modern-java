package com.att.tlv.training.java.switches;

import java.time.DayOfWeek;

public class SwitchExpressions {

    // The current design of Java's switch statement follows closely languages such as C and C++,
    // and supports fall through semantics by default. Whilst this traditional control flow is often
    // useful for writing low-level code (such as parsers for binary encodings), as switch is used in
    // higher-level contexts, its error-prone nature starts to outweigh its flexibility.
    // For example, in the following code, the many break statements make it unnecessarily verbose,
    // and this visual noise often masks hard to debug errors, where missing break statements would
    // mean accidental fall through.
    void printNumOfLetters(DayOfWeek day) {
        // Switch statement with good ol' colon case labels
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println(6);
                break;
            case TUESDAY:
                System.out.println(7);
                break;
            case THURSDAY:
            case SATURDAY:
                System.out.println(8);
                break;
            case WEDNESDAY:
                System.out.println(9);
                break;
        }
    }

    void printNumOfLettersWithArrowCaseLabels(DayOfWeek day) {
        // Switch statement with arrow case label
        // No fallthrough!
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY -> System.out.println(7);
            case THURSDAY, SATURDAY -> System.out.println(8);
            case WEDNESDAY -> System.out.println(9);
        }
    }


    int getNumOfLetters(DayOfWeek day) {
        // Switch statement behaving like an expression
        int numOfLetters;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numOfLetters = 6;
                break;
            case TUESDAY:
                numOfLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numOfLetters = 8;
                break;
            case WEDNESDAY:
                numOfLetters = 9;
                break;
            default:
                // We're forced to define a default branch (or value), even though the compiler knows
                // that we've covered all options
                throw new IllegalArgumentException("Unkown: " + day);
        }
        return numOfLetters;
    }

    int getNumOfLettersWithSwitchExpression(DayOfWeek day) {
        // Switch expressions!
        return switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };
    }

    int getNumOfLettersWithSwitchExpressionAndYield(DayOfWeek day) {
        // Switch expressions!
        return switch (day) {
            case MONDAY -> 6;
            case TUESDAY -> 7;
            default -> {
                // The fact that we MUST have a block here solves the scoping issues
                // that we run into in colon case labels
                int length = day.toString().length();
                System.out.println("Got: " + length);
                // In switch expressions, block statements have to yield a result:
                yield length;
            }
        };
    }

    int getNumOfLettersWithSwitchExpressionInColonLabels(DayOfWeek day) {
        // Switch expressions yield (arrow/colon case labels)
        return switch (day) {
            case MONDAY, FRIDAY, SUNDAY:
                yield 6;
            case TUESDAY:
                yield 7;
            case THURSDAY, SATURDAY:
                yield 8;
            case WEDNESDAY:
                System.out.println("It's Wednesday!");
                yield 9;
        };
    }
}
