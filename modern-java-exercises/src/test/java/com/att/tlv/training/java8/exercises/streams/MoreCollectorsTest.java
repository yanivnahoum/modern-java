package com.att.tlv.training.java8.exercises.streams;

import static com.att.tlv.training.java8.exercises.streams.MoreCollectors.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.att.tlv.training.java8.exercises.data.Person;
import com.google.common.collect.ImmutableList;

public class MoreCollectorsTest {

    @Test
    public void testGetNamesAsString() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        List<Person> persons = ImmutableList.of(alice, bob, jim);

        String names = getNamesAsString(persons);

        assertThat(names).isEqualTo("[ a b j ]");
    }

    @Test
    public void testGetNamesAsStringEmptyInput() {
        String names = getNamesAsString(Collections.emptyList());

        assertThat(names).isEqualTo("[  ]");
    }

    @Test
    public void testGetSumofIds() {
        Person alice = new Person(200, "Alice", 18);
        Person bob = new Person(300, "Bob", 11);
        Person jim = new Person(100, "Jim", 10);
        List<Person> persons = ImmutableList.of(alice, bob, jim);

        long sumOfIds = getSumofIds(persons);

        assertThat(sumOfIds).isEqualTo(alice.getId() + bob.getId() + jim.getId());
    }

    @Test
    public void testGetSumofIdsEmptyList() {
        long sumOfIds = getSumofIds(Collections.emptyList());

        assertThat(sumOfIds).isEqualTo(0);
    }

    @Test
    public void testGetNumOfPersonsOlderThanX() {
        Person alice = new Person(200, "Alice", 18);
        Person bob = new Person(300, "Bob", 11);
        Person jim = new Person(100, "Jim", 10);
        List<Person> persons = ImmutableList.of(alice, bob, jim);

        long count = getNumOfPersonsOlderThanX(persons, 10);

        assertThat(count).isEqualTo(2);
    }

    @Test
    public void testGetNumOfPersonsOlderThanXNoMatch() {
        Person alice = new Person(200, "Alice", 18);
        Person bob = new Person(300, "Bob", 11);
        Person jim = new Person(100, "Jim", 10);
        List<Person> persons = ImmutableList.of(alice, bob, jim);

        long count = getNumOfPersonsOlderThanX(persons, 18);

        assertThat(count).isEqualTo(0);
    }

    @Test
    public void testGetNumOfPersonsOlderThanXEmptyList() {
        long count = getNumOfPersonsOlderThanX(Collections.emptyList(), 18);

        assertThat(count).isEqualTo(0);
    }

    /**
     * Examples:
     * p1 { name: "Alice" }, p2 { name: "Dan" }, p3 { name: "Bob"} => "Alice"
     * p1 { name: "Alice" }, p2 { name: "Dan" }, p3 { name: "Bobby"} => "Alice"
     * {} => ""
     */
    @Test
    public void testGetLongestNameOrEmptyString() {
        Person alice = new Person(200, "Alice", 18);
        Person bob = new Person(300, "Bob", 11);
        Person jim = new Person(100, "Jim", 10);
        List<Person> persons = ImmutableList.of(alice, bob, jim);
        
        String longestName = getLongestNameOrEmptyString(persons);
        
        assertThat(longestName).isEqualTo(alice.getName());
    }
    
    @Test
    public void testGetLongestNameOrEmptyStringTwoWithMaxLength() {
        Person alice = new Person(200, "Alice", 18);
        Person bob = new Person(300, "Bob", 11);
        Person jim = new Person(100, "Jimmy", 10);
        List<Person> persons = ImmutableList.of(alice, bob, jim);
        
        String longestName = getLongestNameOrEmptyString(persons);
        
        assertThat(longestName).isEqualTo(alice.getName());
    }
    
    @Test
    public void testGetLongestNameOrEmptyStringWithSingleEntry() {
        Person alice = new Person(200, "Alice", 18);
        List<Person> persons = ImmutableList.of(alice);
        
        String longestName = getLongestNameOrEmptyString(persons);
        
        assertThat(longestName).isEqualTo(alice.getName());
    }
    
    @Test
    public void testGetLongestNameOrEmptyStringWithEmptyList() {
        String longestName = getLongestNameOrEmptyString(Collections.emptyList());
        
        assertThat(longestName).isEqualTo("");
    }

    @Test
    public void testGetSumOfEvenAges() {
        Person alice = new Person(20, "Alice", 18);
        Person bob = new Person(31, "Bob", 11);
        Person jim = new Person(40, "Jimmy", 10);
        List<Person> persons = ImmutableList.of(alice, bob, jim);
        
        int sumOfEvenAges = getSumOfEvenAges(persons);
        
        assertThat(sumOfEvenAges).isEqualTo(alice.getAge() + jim.getAge());
    }
    
    @Test
    public void testGetSumOfEvenAgesWithSingleEntry() {
        Person alice = new Person(20, "Alice", 18);
        List<Person> persons = ImmutableList.of(alice);
        
        int sumOfEvenAges = getSumOfEvenAges(persons);
        
        assertThat(sumOfEvenAges).isEqualTo(alice.getAge());
    }
    
    @Test
    public void testGetSumOfEvenAgesWithEmptyList() {
        int sumOfEvenAges = getSumOfEvenAges(Collections.emptyList());
        
        assertThat(sumOfEvenAges).isEqualTo(0);
    }
}
