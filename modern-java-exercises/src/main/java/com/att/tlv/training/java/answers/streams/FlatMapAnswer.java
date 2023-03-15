package com.att.tlv.training.java.answers.streams;

import com.att.tlv.training.java.exercises.data.Person;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class FlatMapAnswer {
    
    /**
     * Example:
     * p1 { name: "Alice", children: [ { name: "Adam" }, { name: "Anna" } ] }, 
     * p2 { name: "Dan", children: [ { name: "David" }, { name: "Donna" } ] },
     * p3 { name: "Bob", children: [ { name: "Adam" } ] } =>
     * Set { "Adam", "Anna", "David", "Donna" }
     */  
    public static Set<String> getUniqueChildrenNames(List<Person> persons) {
        return persons.stream()
                .flatMap(p -> p.children().stream())
                .map(Person::name)
                .collect(toSet());
    }
    
    /**
     * Example:
     * p1 { name: "Alice", children: [ { name: "Adam", children: [ { name: "Adam", age: 20 } ] }, { name: "Anna", children: [] } ] }, 
     * p2 { name: "Dan", children: [ { name: "David", children: [] }, { name: "Donna", children: [ { name: "Adam", age: 30 } ] } ] },
     * p3 { name: "Bob", children: [ { name: "Adam", children: [ { name: "Adam", age: 10 } ] } ] } => 60
     */     
    public static int getSumOfGrandChildrenAges(List<Person> persons) {
        return persons.stream()
                .flatMap(p -> p.children().stream())
                .flatMap(p -> p.children().stream())
                .mapToInt(Person::age)
                .sum();
    }
    
    /**
     * Example:
     * p1 { name: "Alice", children: [ { id: 1000, name: "Adam", age: 30 }, { id: 1001, name: "Anna", age: 10 } ] }, 
     * p2 { name: "Dan", children: [ { id: 2000, name: "David", age: 22 }, { id: 2001, name: "Donna", age: 15 } ] },
     * p3 { name: "Bob", children: [ { id: 3000, name: "Adam", age: 29 } ] } =>
     * [1000, 2000, 3000]
     */     
    public static long[] getIdsOfChildrenOver21(List<Person> persons) {
        return persons.stream()
                .flatMap(p -> p.children().stream())
                .filter(FlatMapAnswer::isOver21)
                .mapToLong(Person::id)
                    .toArray();
    }
    
    private static boolean isOver21(Person person) {
        return person.age() > 21;
    }
}
