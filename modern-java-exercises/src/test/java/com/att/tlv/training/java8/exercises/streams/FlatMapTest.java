package com.att.tlv.training.java8.exercises.streams;

import static com.att.tlv.training.java8.exercises.streams.FlatMap.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.att.tlv.training.java8.exercises.data.Person;
import com.google.common.collect.ImmutableList;

public class FlatMapTest {
    
    private static final List<Person> PERSONS_WITH_NO_CHILDREN;
    
    static {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        PERSONS_WITH_NO_CHILDREN = ImmutableList.of(alice, bob, jim);         
    }
    
    @Test
    public void testGetUniqueChildrenNames() {
        final String ANDY = "Andy";
        Person andy = new Person(1002, ANDY, 3);
        Person anna = new Person(1001, "Anna", 5);
        Person alice = new Person(1000, "Alice", 35, anna, andy);
        
        Person bill = new Person(2001, "Bill", 11);
        Person bob = new Person(2000, "Bob", 41, bill);
        
        Person andy2 = new Person(3001, ANDY, 10);
        Person jim = new Person(3000, "Jim", 39, andy2);
        List<Person> persons = ImmutableList.of(alice, bob, jim);         
        
        Set<String> names = getUniqueChildrenNames(persons);
        
        assertThat(names).containsOnly(ANDY, anna.getName(), bill.getName());
    }
    
    @Test
    public void testGetUniqueChildrenNamesWithEmptyInput() {
        Set<String> names = getUniqueChildrenNames(Collections.emptyList());
        
        assertThat(names).isEmpty();
    }
    
    @Test
    public void testGetUniqueChildrenNamesWithNoChildren() {
        Set<String> names = getUniqueChildrenNames(PERSONS_WITH_NO_CHILDREN);
        
        assertThat(names).isEmpty();
    }
    
    @Test
    public void testGetSumOfGrandChildrenAges() {
        Person alvin = new Person(1003, "Alvin", 10);
        Person andy = new Person(1002, "Andy", 41, alvin);
        Person anna = new Person(1001, "Anna", 45);
        Person alice = new Person(1000, "Alice", 60, anna, andy);
        
        Person bill = new Person(2001, "Bill", 11);
        Person bob = new Person(2000, "Bob", 41, bill);
        
        Person gerard = new Person(3001, "Gerard", 1);
        Person jonah = new Person(3001, "Jonah", 1);
        Person james = new Person(3001, "James", 22, jonah, gerard);
        Person jim = new Person(3000, "Jim", 49, james);
        List<Person> persons = ImmutableList.of(alice, bob, jim);         
        
        int sum = getSumOfGrandChildrenAges(persons);
        
        assertThat(sum).isEqualTo(alvin.getAge() + gerard.getAge() + jonah.getAge());
    }
    
    @Test
    public void testGetSumOfGrandChildrenAgesWithEmptyInput() {
        int sum = getSumOfGrandChildrenAges(Collections.emptyList());
        
        assertThat(sum).isZero();
    }
    
    @Test
    public void testGetSumOfGrandChildrenAgesWithNoChildren() {
        int sum = getSumOfGrandChildrenAges(PERSONS_WITH_NO_CHILDREN);
        
        assertThat(sum).isZero();
    }
    
    @Test
    public void testGetSumOfGrandChildrenAgesWithNoGrandChildren() {
        Person andy = new Person(1002, "Andy", 21);
        Person anna = new Person(1001, "Anna", 25);
        Person alice = new Person(1000, "Alice", 55, anna, andy);
        
        Person bill = new Person(2001, "Bill", 11);
        Person bob = new Person(2000, "Bob", 41, bill);
        
        Person james = new Person(3001, "James", 22);
        Person jim = new Person(3000, "Jim", 49, james);
        List<Person> persons = ImmutableList.of(alice, bob, jim);
        
        int sum = getSumOfGrandChildrenAges(persons);
        
        assertThat(sum).isZero();
    }
    
    @Test
    public void testGetIdsOfChildrenOver21() {
        Person andy = new Person(1002, "Andy", 21);
        Person anna = new Person(1001, "Anna", 25);
        Person alice = new Person(1000, "Alice", 55, anna, andy);
        
        Person bill = new Person(2001, "Bill", 11);
        Person bob = new Person(2000, "Bob", 41, bill);
        
        Person james = new Person(3001, "James", 22);
        Person jim = new Person(3000, "Jim", 49, james);
        List<Person> persons = ImmutableList.of(alice, bob, jim);         
        
        long[] ids = getIdsOfChildrenOver21(persons);
        
        assertThat(ids).containsExactly(anna.getId(), james.getId());
    }
    
    @Test
    public void testGetIdsOfChildrenOver21WithEmptyInput() {
        long[] ids = getIdsOfChildrenOver21(Collections.emptyList());
        
        assertThat(ids).isEmpty();
    }
    
    @Test
    public void testGetIdsOfChildrenOver21WithNoChildren() {
        long[] ids = getIdsOfChildrenOver21(PERSONS_WITH_NO_CHILDREN);
        
        assertThat(ids).isEmpty();
    }
}
