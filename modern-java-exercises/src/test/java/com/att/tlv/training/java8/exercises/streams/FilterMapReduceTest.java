package com.att.tlv.training.java8.exercises.streams;

import static com.att.tlv.training.java8.exercises.streams.FilterMapReduce.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.att.tlv.training.java8.exercises.data.Person;
import com.google.common.collect.ImmutableList;

public class FilterMapReduceTest {
    
    @Test
    public void testAddUp() {
        int[] numbers = new int[] { 1, 2, 3, 4 };
        int actual = addUp(numbers);
        int expected = 1 + 2 + 3 + 4;
        assertThat(actual).isEqualTo(expected);
    }
    
    @Test
    public void testAddUpNoArgs() {
        int[] numbers = new int[] { };
        int actual = addUp(numbers);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void testGetProductOfAgesWhereIdIsGreaterThan1005() {
        Person alice = new Person(1000, "Alice", 1);
        Person bob = new Person(2000, "Bob", 2);
        Person jim = new Person(3000, "Jim", 3);
        List<Person> persons = ImmutableList.of(alice, bob, jim);
        
        int product = getProductOfAgesWhereIdIsGreaterThan1005(persons);
        
        assertThat(product).isEqualTo(bob.getAge() * jim.getAge());
    }
    
    @Test
    public void testGetProductOfAgesWhereIdIsGreaterThan1005_EmptySet() {
        Person alice = new Person(1000, "Alice", 1);
        Person bob = new Person(200, "Bob", 2);
        Person jim = new Person(300, "Jim", 3);
        List<Person> persons = ImmutableList.of(alice, bob, jim);
        
        int product = getProductOfAgesWhereIdIsGreaterThan1005(persons);
        
        assertThat(product).isEqualTo(1);
    }
    
    @Test
    public void testGetMinIdWhereNameHasAnAOrMinus1() {
        Person alice = new Person(1000, "Alice", 1);
        Person bob = new Person(2000, "Bob", 2);
        Person jim = new Person(100, "Jim", 3);
        Person dan = new Person(300, "Dan", 4);
        List<Person> persons = ImmutableList.of(alice, bob, jim, dan);   
        
        long minId = getMinIdWhereNameHasAnAOrMinus1(persons);
        
        assertThat(minId).isEqualTo(dan.getId());        
    }
    
    @Test
    public void testGetMinIdWhereNameHasAnAOrMinus1_EmptySet() {
        Person henry = new Person(1000, "Henry", 1);
        Person bob = new Person(2000, "Bob", 2);
        Person jim = new Person(100, "Jim", 3);
        Person don = new Person(300, "Don", 4);
        List<Person> persons = ImmutableList.of(henry, bob, jim, don);   
        
        long minId = getMinIdWhereNameHasAnAOrMinus1(persons);
        
        assertThat(minId).isEqualTo(-1);        
    }
}
