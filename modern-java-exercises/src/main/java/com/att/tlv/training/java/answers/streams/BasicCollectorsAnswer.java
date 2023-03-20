package com.att.tlv.training.java.answers.streams;

import com.att.tlv.training.java.exercises.data.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toMap;

public class BasicCollectorsAnswer {

    /**
     * Example:
     * p1 { name: "Alice", id: 3300 }, p2 { name: "Dan", id: 2400 }, p3 { name: "Bob", id: 1500 } =>
     * ArrayList { "Alice", "Dan", "Bob" }
     */
    public static List<String> getNames(List<Person> persons) {
        return persons.stream()
                .map(Person::name)
                .toList();
    }

    /**
     * Example:
     * p1 { id: 1001, age: 18 }, p2 { id: 1002, age: 10 },
     * p3 { id: 1003, age: 16 }, p4 { id: 1014, age: 35 } =>
     * LinkedList { p2, p3 }
     */
    public static LinkedList<Person> getMinorsOnly(List<Person> persons) {
        return persons.stream()
                .filter(p -> p.age() < 18)
                .collect(toCollection(LinkedList::new));
    }

    /**
     * Example:
     * p1 { id: 1001, age: 18 }, p2 { id: 1002, age: 10 } => 
     * HashMap { 1001=>p1, 1002=>p2 }
     */
    public static Map<Long, Person> mapIdToPerson(List<Person> persons) {
        return persons.stream()
                .collect(toMap(Person::id, Function.identity()));
    }

    /**
     * Example:
     * p1 { name: "Alice", age: 33 }, p2 { name: "Dan", age: 25 }, p3 { name: "Bob", age: 33 } =>
     * HashMap { 33=>AliceBob, 25=>Dan }
     */
    public static Map<Integer, String> mapAgeToNames(List<Person> persons) {
        return persons.stream()
                .collect(toMap(Person::age, Person::name, String::concat));
    }

    /**
     * Example:
     * p1 { name: "Alice", id: 1001 }, p2 { name: "Dan", id: 1002 }, p3 { name: "Alice", id: 1003 } =>
     * HashMap { Alice=>2, Dan=>1 }
     */
    public static Map<String, Long> mapNameToCount(List<Person> persons) {
        return persons.stream()
                .collect(toMap(Person::name, p -> 1L, Long::sum));
    }
}
