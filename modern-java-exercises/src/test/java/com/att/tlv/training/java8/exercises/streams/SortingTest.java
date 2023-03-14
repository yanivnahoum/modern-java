package com.att.tlv.training.java8.exercises.streams;

import static com.att.tlv.training.java8.exercises.streams.Sorting.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.att.tlv.training.java8.exercises.data.Person;

public class SortingTest {

    @Test
    public void testSortNames() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        List<Person> persons = newArrayList(alice, bob, jim);       
        Collections.reverse(persons);
        
        List<String> sortedNames = sortNames(persons);
        
        assertThat(sortedNames).containsExactly(alice.getName(), bob.getName(), jim.getName());
    }
    
    @Test
    public void testSortByAge() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        List<Person> persons = newArrayList(alice, bob, jim);       
        
        List<Person> sortedPersons = sortByAge(persons);
        
        assertThat(sortedPersons).containsExactly(jim, bob, alice);
    }
    
    @Test
    public void testSortByIdDescending() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        List<Person> persons = newArrayList(alice, bob, jim);       
        
        List<Person> sortedPersons = sortByIdDescending(persons);
        
        assertThat(sortedPersons).containsExactly(jim, bob, alice);
    }
    
    @Test
    public void testSortByNameAndThenId() {
        Person alice = new Person(1000, "Alice", 18);
        Person alice2 = new Person(1001, "Alice", 36);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        Person jim2 = new Person(3001, "Jim", 20);
        List<Person> persons = newArrayList(alice, alice2, bob, jim, jim2);
        Collections.reverse(persons);
        
        List<Person> sortedPersons = sortByNameAndThenId(persons);
        
        assertThat(sortedPersons).containsExactly(alice, alice2, bob, jim, jim2);
    }
    
    @Test
    public void testSortByAgeDescendingAndThenId() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        Person carl = new Person(1001, "Carl", 18);
        Person george = new Person(2001, "George", 11);
        
        List<Person> persons = newArrayList(alice, bob, jim, carl, george);    
        
        List<Person> sortedPersons = sortByAgeDescendingAndThenId(persons);
        
        assertThat(sortedPersons).containsExactly(alice, carl, bob, george, jim);
    }
    
    @Test
    public void testSortByNameAndThenIdDescending() {
        Person alice = new Person(1000, "Alice", 18);
        Person alice2 = new Person(1001, "Alice", 36);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        Person jim2 = new Person(3001, "Jim", 20);
        List<Person> persons = newArrayList(alice, alice2, bob, jim, jim2);
        Collections.reverse(persons);
        
        List<Person> sortedPersons = sortByNameAndThenIdDescending(persons);
        
        assertThat(sortedPersons).containsExactly(alice2, alice, bob, jim2, jim);        
    }
    
    @Test
    public void testSortByNameWithCaseInsensitiveOrder() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "bob", 11);
        Person carl = new Person(3000, "Carl", 11);
        Person jim = new Person(4000, "jim", 10);
        List<Person> persons = newArrayList(alice, bob, carl, jim);    
        Collections.reverse(persons);
        
        List<Person> sortedPersons = sortByNameWithCaseInsensitiveOrder(persons);
        
        assertThat(sortedPersons).containsExactly(alice, bob, carl, jim);        
    }
}