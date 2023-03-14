package com.att.tlv.training.java.exercises.streams;

import com.att.tlv.training.java.exercises.data.Person;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class FlatMapTest {

    private static final List<Person> PERSONS_WITH_NO_CHILDREN;

    static {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        PERSONS_WITH_NO_CHILDREN = ImmutableList.of(alice, bob, jim);
    }

    @Test
    void testGetUniqueChildrenNames() {
        final String ANDY = "Andy";
        Person andy = new Person(1002, ANDY, 3);
        Person anna = new Person(1001, "Anna", 5);
        Person alice = new Person(1000, "Alice", 35, anna, andy);

        Person bill = new Person(2001, "Bill", 11);
        Person bob = new Person(2000, "Bob", 41, bill);

        Person andy2 = new Person(3001, ANDY, 10);
        Person jim = new Person(3000, "Jim", 39, andy2);
        List<Person> persons = ImmutableList.of(alice, bob, jim);

        Set<String> names = FlatMap.getUniqueChildrenNames(persons);

        assertThat(names).containsOnly(ANDY, anna.getName(), bill.getName());
    }

    @Test
    void testGetUniqueChildrenNamesWithEmptyInput() {
        Set<String> names = FlatMap.getUniqueChildrenNames(Collections.emptyList());

        assertThat(names).isEmpty();
    }

    @Test
    void testGetUniqueChildrenNamesWithNoChildren() {
        Set<String> names = FlatMap.getUniqueChildrenNames(PERSONS_WITH_NO_CHILDREN);

        assertThat(names).isEmpty();
    }

    @Test
    void testGetSumOfGrandChildrenAges() {
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

        int sum = FlatMap.getSumOfGrandChildrenAges(persons);

        assertThat(sum).isEqualTo(alvin.getAge() + gerard.getAge() + jonah.getAge());
    }

    @Test
    void testGetSumOfGrandChildrenAgesWithEmptyInput() {
        int sum = FlatMap.getSumOfGrandChildrenAges(Collections.emptyList());

        assertThat(sum).isZero();
    }

    @Test
    void testGetSumOfGrandChildrenAgesWithNoChildren() {
        int sum = FlatMap.getSumOfGrandChildrenAges(PERSONS_WITH_NO_CHILDREN);

        assertThat(sum).isZero();
    }

    @Test
    void testGetSumOfGrandChildrenAgesWithNoGrandChildren() {
        Person andy = new Person(1002, "Andy", 21);
        Person anna = new Person(1001, "Anna", 25);
        Person alice = new Person(1000, "Alice", 55, anna, andy);

        Person bill = new Person(2001, "Bill", 11);
        Person bob = new Person(2000, "Bob", 41, bill);

        Person james = new Person(3001, "James", 22);
        Person jim = new Person(3000, "Jim", 49, james);
        List<Person> persons = ImmutableList.of(alice, bob, jim);

        int sum = FlatMap.getSumOfGrandChildrenAges(persons);

        assertThat(sum).isZero();
    }

    @Test
    void testGetIdsOfChildrenOver21() {
        Person andy = new Person(1002, "Andy", 21);
        Person anna = new Person(1001, "Anna", 25);
        Person alice = new Person(1000, "Alice", 55, anna, andy);

        Person bill = new Person(2001, "Bill", 11);
        Person bob = new Person(2000, "Bob", 41, bill);

        Person james = new Person(3001, "James", 22);
        Person jim = new Person(3000, "Jim", 49, james);
        List<Person> persons = ImmutableList.of(alice, bob, jim);

        long[] ids = FlatMap.getIdsOfChildrenOver21(persons);

        assertThat(ids).containsExactly(anna.getId(), james.getId());
    }

    @Test
    void testGetIdsOfChildrenOver21WithEmptyInput() {
        long[] ids = FlatMap.getIdsOfChildrenOver21(Collections.emptyList());

        assertThat(ids).isEmpty();
    }

    @Test
    void testGetIdsOfChildrenOver21WithNoChildren() {
        long[] ids = FlatMap.getIdsOfChildrenOver21(PERSONS_WITH_NO_CHILDREN);

        assertThat(ids).isEmpty();
    }
}
