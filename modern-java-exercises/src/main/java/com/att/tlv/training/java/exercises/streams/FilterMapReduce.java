package com.att.tlv.training.java.exercises.streams;

import com.att.tlv.training.java.exercises.Exercises;
import com.att.tlv.training.java.exercises.data.Person;

import java.util.List;

/**
 * Use filter(), map() and reduce() (or specific reductions like max())
 */
public class FilterMapReduce {

    /**
     * Example:
     * [1, 2, 3] => 6
     */    
    public static int addUp(int[] numbers) {
        return Exercises.replaceThisWithSolution();
    }

    /**
     * Example:
     * p1 { id: 1006, age: 3 }, p2 { id: 1007, age: 4 }, 
     * p3 { id: 1001, age: 2 }, p4 { id: 1010, age: 5 } => 3 x 4 x 5 = 60  
     */
    public static int getProductOfAgesWhereIdIsGreaterThan1005(List<Person> persons) {
        return Exercises.replaceThisWithSolution();
    }
    
    /**
     * Examples:
     * p1 { name: "Alice", id: 3300 }, p2 { name: "Dan", id: 2400 }, p3 { name: "Bob", id: 1500 } => 2400
     * p1 { name: "Ron", id: 3300 }, p2 { name: "Bob", id: 1500 } => -1  
     * Note: Look for names containing 'A 'or 'a' 
     */
    public static long getMinIdWhereNameHasAnAOrMinus1(List<Person> persons) {
        return Exercises.replaceThisWithSolution();
    }
}