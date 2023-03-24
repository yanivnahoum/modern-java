package com.att.tlv.training.java.exercises.streams;

import com.att.tlv.training.java.exercises.data.Person;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class SortingTest {

    @Test
    void testSortNames() {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", 10);
        List<Person> persons = newArrayList(alice, bob, jim);
        Collections.reverse(persons);

        List<String> sortedNames = Sorting.sortNames(persons);

        assertThat(sortedNames).containsExactly(alice.name(), bob.name(), jim.name());
    }

    @Test
    void testSortByAge() {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", 10);
        List<Person> persons = newArrayList(alice, bob, jim);

        List<Person> sortedPersons = Sorting.sortByAge(persons);

        assertThat(sortedPersons).containsExactly(jim, bob, alice);
    }

    @Test
    void testSortByIdDescending() {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", 10);
        List<Person> persons = newArrayList(alice, bob, jim);

        List<Person> sortedPersons = Sorting.sortByIdDescending(persons);

        assertThat(sortedPersons).containsExactly(jim, bob, alice);
    }

    @Test
    void testSortByNameAndThenId() {
        var alice = new Person(1000, "Alice", 18);
        Person alice2 = new Person(1001, "Alice", 36);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", 10);
        Person jim2 = new Person(3001, "Jim", 20);
        List<Person> persons = newArrayList(alice, alice2, bob, jim, jim2);
        Collections.reverse(persons);

        List<Person> sortedPersons = Sorting.sortByNameAndThenId(persons);

        assertThat(sortedPersons).containsExactly(alice, alice2, bob, jim, jim2);
    }

    @Test
    void testSortByAgeDescendingAndThenId() {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", 10);
        Person carl = new Person(1001, "Carl", 18);
        Person george = new Person(2001, "George", 11);

        List<Person> persons = newArrayList(alice, bob, jim, carl, george);

        List<Person> sortedPersons = Sorting.sortByAgeDescendingAndThenId(persons);

        assertThat(sortedPersons).containsExactly(alice, carl, bob, george, jim);
    }

    @Test
    void testSortByNameAndThenIdDescending() {
        var alice = new Person(1000, "Alice", 18);
        Person alice2 = new Person(1001, "Alice", 36);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", 10);
        Person jim2 = new Person(3001, "Jim", 20);
        List<Person> persons = newArrayList(alice, alice2, bob, jim, jim2);
        Collections.reverse(persons);

        List<Person> sortedPersons = Sorting.sortByNameAndThenIdDescending(persons);

        assertThat(sortedPersons).containsExactly(alice2, alice, bob, jim2, jim);
    }

    @Test
    void testSortByNameWithCaseInsensitiveOrder() {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(2000, "bob", 11);
        Person carl = new Person(3000, "Carl", 11);
        var jim = new Person(4000, "jim", 10);
        List<Person> persons = newArrayList(alice, bob, carl, jim);
        Collections.reverse(persons);

        List<Person> sortedPersons = Sorting.sortByNameWithCaseInsensitiveOrder(persons);

        assertThat(sortedPersons).containsExactly(alice, bob, carl, jim);
    }
}