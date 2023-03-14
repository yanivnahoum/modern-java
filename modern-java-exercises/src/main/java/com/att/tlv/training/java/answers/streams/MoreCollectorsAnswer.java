package com.att.tlv.training.java.answers.streams;

import com.att.tlv.training.java.exercises.data.Person;

import java.util.List;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingLong;

/**
 * Use collect() in all exercises.
 */
public class MoreCollectorsAnswer {
    /**
     * Example:
     * p1 { name: "Alice" }, p2 { name: "Dan" }, p3 { name: "Bob"} => "[ a d b ]"
     * 
     * @return A {@code String} consisting of a space separated list of the first letter
     *         of the name, in lower case, of each person in the specified list of {@code Person}s.
     */
    public static String getNamesAsString(List<Person> persons) {
        return persons.stream()
                .map(MoreCollectorsAnswer::getFirstLetterOfNameInLowerCase)
                .collect(joining(" ", "[ ", " ]"));
    }

    private static String getFirstLetterOfNameInLowerCase(Person person) {
        return person.getName()
                .substring(0, 1)
                .toLowerCase();
    }

    /**
     * Example:
     * p1 { name: "Alice", id: 100 }, p2 { name: "Dan", id: 200 }, p3 { name: "Bob", id: 300 } => 600
     */
    public static long getSumofIds(List<Person> persons) {
        return persons.stream()
                .collect(summingLong(Person::getId));
    }

    /**
     * Example:
     * p1 ({ name: "Alice", age: 20 }, p2 { name: "Dan", age: 30 }, p3 { name: "Bob", age: 40 } , x = 25) => 2
     */
    public static long getNumOfPersonsOlderThanX(List<Person> persons, int x) {
        return persons.stream()
                .filter(p -> p.getAge() > x)
                .collect(counting());
    }

    /**
     * Examples:
     * p1 { name: "Alice" }, p2 { name: "Dan" }, p3 { name: "Bob"} => "Alice"
     * p1 { name: "Alice" }, p2 { name: "Dan" }, p3 { name: "Bobby"} => "Alice"
     * {} => ""
     */
    public static String getLongestNameOrEmptyString(List<Person> persons) {
        return persons.stream()
                .map(Person::getName)
                .collect(reducing("", (n1, n2) -> n2.length() > n1.length() ? n2 : n1));
    }

    /**
     * Example:
     * p1 { name: "Alice", age: 20 }, p2 { name: "Dan", age: 31 }, p3 { name: "Bob", age: 40 } => 60
     * Note: do not use filter()
     */
    public static int getSumOfEvenAges(List<Person> persons) {
        return persons.stream()
                .collect(reducing(0, Person::getAge, (res, e) -> e % 2 == 0 ? res + e : res));
    }
}
