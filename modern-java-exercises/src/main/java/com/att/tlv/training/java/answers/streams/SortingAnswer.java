package com.att.tlv.training.java.answers.streams;

import com.att.tlv.training.java.exercises.data.Person;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.toList;

/**
 * Ascending sort order is implied when not stated otherwise.
 */
public class SortingAnswer {
    
    public static List<String> sortNames(List<Person> persons) {
        return persons.stream()
                .map(Person::name)
                .sorted()
                .collect(toList());
    }
    
    public static List<Person> sortByAge(List<Person> persons) {
        return persons.stream()
                .sorted(comparingInt(Person::age))
                .collect(toList());
    }
    
    public static List<Person> sortByIdDescending(List<Person> persons) {
        return persons.stream()
                .sorted(comparingLong(Person::id).reversed())
                .collect(toList());
    }
    
    public static List<Person> sortByNameAndThenId(List<Person> persons) {
        return persons.stream()
                .sorted(comparing(Person::name).thenComparingLong(Person::id))
                .collect(toList());
    }
    
    public static List<Person> sortByAgeDescendingAndThenId(List<Person> persons) {
        return persons.stream()
                .sorted(comparingInt(Person::age).reversed().thenComparingLong(Person::id))
                .collect(toList());
    }
    
    public static List<Person> sortByNameAndThenIdDescending(List<Person> persons) {
        return persons.stream()
                .sorted(comparing(Person::name).thenComparing(comparingLong(Person::id).reversed()))
                .collect(toList());
    }
    
    public static List<Person> sortByNameWithCaseInsensitiveOrder(List<Person> persons) {
        return persons.stream()
                .sorted(comparing(Person::name, String.CASE_INSENSITIVE_ORDER))
                .collect(toList());
    }
}