package com.att.tlv.training.java.exercises.streams;

import com.att.tlv.training.java.exercises.Exercises;
import com.att.tlv.training.java.exercises.data.Person;

import java.util.List;

/**
 * Use collect() in all exercises.
 */
public class MoreCollectors {
    /**
     * Example:
     * p1 { name: "Alice" }, p2 { name: "Dan" }, p3 { name: "Bob"} => "[ a d b ]"
     *
     * @return A {@code String} consisting of a space separated list of the first letter
     *         of the name, in lower case, of each person in the specified list of {@code Person}s.
     */
    public static String getNamesAsString(List<Person> persons) {
       return Exercises.replaceThisWithSolution();
    }

    /**
     * Example:
     * p1 { name: "Alice", id: 100 }, p2 { name: "Dan", id: 200 }, p3 { name: "Bob", id: 300 } => 600
     */
    public static long getSumOfIds(List<Person> persons) {
        return Exercises.replaceThisWithSolution();
    }

    /**
     * Example:
     * p1 ({ name: "Alice", age: 20 }, p2 { name: "Dan", age: 30 }, p3 { name: "Bob", age: 40 } , x = 25) => 2
     */
    public static long getNumOfPersonsOlderThanX(List<Person> persons, int x) {
        return Exercises.replaceThisWithSolution();
    }

    /**
     * Examples:
     * p1 { name: "Alice" }, p2 { name: "Dan" }, p3 { name: "Bob"} => "Alice"
     * p1 { name: "Alice" }, p2 { name: "Dan" }, p3 { name: "Bobby"} => "Alice"
     * {} => ""
     */
    public static String getLongestNameOrEmptyString(List<Person> persons) {
        return Exercises.replaceThisWithSolution();
    }

    /**
     * Example:
     * p1 { name: "Alice", age: 20 }, p2 { name: "Dan", age: 31 }, p3 { name: "Bob", age: 40 } => 60
     * Note: do not use filter()
     */
    public static int getSumOfEvenAges(List<Person> persons) {
        return Exercises.replaceThisWithSolution();
    }
}
