package com.att.tlv.training.java8.exercises.streams;

import java.util.List;
import java.util.Set;

import com.att.tlv.training.java8.exercises.Exercises;
import com.att.tlv.training.java8.exercises.data.Person;

public class FlatMap {
    
    /**
     * Example:
     * p1 { name: "Alice", children: [ { name: "Adam" }, { name: "Anna" } ] }, 
     * p2 { name: "Dan", children: [ { name: "David" }, { name: "Donna" } ] },
     * p3 { name: "Bob", children: [ { name: "Adam" } ] } =>
     * Set { "Adam", "Anna", "David", "Donna" }
     */  
    public static Set<String> getUniqueChildrenNames(List<Person> persons) {
        return Exercises.replaceThisWithSolution();
    }
    
    /**
     * Example:
     * p1 { name: "Alice", children: [ { name: "Adam", children: [ { name: "Adam", age: 20 } ] }, { name: "Anna", children: [] } ] }, 
     * p2 { name: "Dan", children: [ { name: "David", children: [] }, { name: "Donna", children: [ { name: "Adam", age: 30 } ] } ] },
     * p3 { name: "Bob", children: [ { name: "Adam", children: [ { name: "Adam", age: 10 } ] } ] } => 60
     */     
    public static int getSumOfGrandChildrenAges(List<Person> persons) {
        return Exercises.replaceThisWithSolution();
    }
    
    /**
     * Example:
     * p1 { name: "Alice", children: [ { id: 1000, name: "Adam", age: 30 }, { id: 1001, name: "Anna", age: 10 } ] }, 
     * p2 { name: "Dan", children: [ { id: 2000, name: "David", age: 22 }, { id: 2001, name: "Donna", age: 15 } ] },
     * p3 { name: "Bob", children: [ { id: 3000, name: "Adam", age: 29 } ] } =>
     * [1000, 2000, 3000]
     */     
    public static long[] getIdsOfChildrenOver21(List<Person> persons) {
        return Exercises.replaceThisWithSolution();
    }
}
