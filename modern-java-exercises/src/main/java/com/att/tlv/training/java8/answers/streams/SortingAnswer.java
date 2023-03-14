package com.att.tlv.training.java8.answers.streams;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.toList;

import java.util.List;

import com.att.tlv.training.java8.exercises.data.Person;

/**
 * Ascending sort order is implied when not stated otherwise.
 */
public class SortingAnswer {
    
    public static List<String> sortNames(List<Person> persons) {
        return persons.stream()
                .map(Person::getName)
                .sorted()
                .collect(toList());
    }
    
    public static List<Person> sortByAge(List<Person> persons) {
        return persons.stream()
                .sorted(comparingInt(Person::getAge))
                .collect(toList());
    }
    
    public static List<Person> sortByIdDescending(List<Person> persons) {
        return persons.stream()
                .sorted(comparingLong(Person::getId).reversed())
                .collect(toList());
    }
    
    public static List<Person> sortByNameAndThenId(List<Person> persons) {
        return persons.stream()
                .sorted(comparing(Person::getName).thenComparingLong(Person::getId))
                .collect(toList());
    }
    
    public static List<Person> sortByAgeDescendingAndThenId(List<Person> persons) {
        return persons.stream()
                .sorted(comparingInt(Person::getAge).reversed().thenComparingLong(Person::getId))
                .collect(toList());
    }
    
    public static List<Person> sortByNameAndThenIdDescending(List<Person> persons) {
        return persons.stream()
                .sorted(comparing(Person::getName).thenComparing(comparingLong(Person::getId).reversed()))
                .collect(toList());
    }
    
    public static List<Person> sortByNameWithCaseInsensitiveOrder(List<Person> persons) {
        return persons.stream()
                .sorted(comparing(Person::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(toList());
    }
}