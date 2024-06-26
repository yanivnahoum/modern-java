package com.att.tlv.training.java.exercises.streams;

import com.att.tlv.training.java.exercises.data.Person;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static com.att.tlv.training.java.exercises.streams.MoreCollectors.getLongestNameOrEmptyString;
import static com.att.tlv.training.java.exercises.streams.MoreCollectors.getNamesAsString;
import static com.att.tlv.training.java.exercises.streams.MoreCollectors.getNumOfPersonsOlderThanX;
import static com.att.tlv.training.java.exercises.streams.MoreCollectors.getSumOfEvenAges;
import static com.att.tlv.training.java.exercises.streams.MoreCollectors.getSumOfIds;
import static org.assertj.core.api.Assertions.assertThat;

class MoreCollectorsTest {

    @Test
    void testGetNamesAsString() {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", 10);
        var persons = List.of(alice, bob, jim);

        String names = getNamesAsString(persons);

        assertThat(names).isEqualTo("[ a b j ]");
    }

    @Test
    void testGetNamesAsStringEmptyInput() {
        String names = getNamesAsString(Collections.emptyList());

        assertThat(names).isEqualTo("[  ]");
    }

    @Test
    void testGetSumOfIds() {
        var alice = new Person(200, "Alice", 18);
        var bob = new Person(300, "Bob", 11);
        var jim = new Person(100, "Jim", 10);
        var persons = List.of(alice, bob, jim);

        long sumOfIds = getSumOfIds(persons);

        assertThat(sumOfIds).isEqualTo(alice.id() + bob.id() + jim.id());
    }

    @Test
    void testGetSumofIdsEmptyList() {
        long sumOfIds = getSumOfIds(Collections.emptyList());

        assertThat(sumOfIds).isEqualTo(0);
    }

    @Test
    void testGetNumOfPersonsOlderThanX() {
        var alice = new Person(200, "Alice", 18);
        var bob = new Person(300, "Bob", 11);
        var jim = new Person(100, "Jim", 10);
        var persons = List.of(alice, bob, jim);

        long count = getNumOfPersonsOlderThanX(persons, 10);

        assertThat(count).isEqualTo(2);
    }

    @Test
    void testGetNumOfPersonsOlderThanXNoMatch() {
        var alice = new Person(200, "Alice", 18);
        var bob = new Person(300, "Bob", 11);
        var jim = new Person(100, "Jim", 10);
        var persons = List.of(alice, bob, jim);

        long count = getNumOfPersonsOlderThanX(persons, 18);

        assertThat(count).isEqualTo(0);
    }

    @Test
    void testGetNumOfPersonsOlderThanXEmptyList() {
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
    void testGetLongestNameOrEmptyString() {
        var alice = new Person(200, "Alice", 18);
        var bob = new Person(300, "Bob", 11);
        var jim = new Person(100, "Jim", 10);
        var persons = List.of(alice, bob, jim);

        String longestName = getLongestNameOrEmptyString(persons);

        assertThat(longestName).isEqualTo(alice.name());
    }

    @Test
    void testGetLongestNameOrEmptyStringTwoWithMaxLength() {
        var alice = new Person(200, "Alice", 18);
        var bob = new Person(300, "Bob", 11);
        var jim = new Person(100, "Jimmy", 10);
        var persons = List.of(alice, bob, jim);

        String longestName = getLongestNameOrEmptyString(persons);

        assertThat(longestName).isEqualTo(alice.name());
    }

    @Test
    void testGetLongestNameOrEmptyStringWithSingleEntry() {
        var alice = new Person(200, "Alice", 18);
        var persons = List.of(alice);

        String longestName = getLongestNameOrEmptyString(persons);

        assertThat(longestName).isEqualTo(alice.name());
    }

    @Test
    void testGetLongestNameOrEmptyStringWithEmptyList() {
        String longestName = getLongestNameOrEmptyString(Collections.emptyList());

        assertThat(longestName).isEqualTo("");
    }

    @Test
    void testGetSumOfEvenAges() {
        var alice = new Person(20, "Alice", 18);
        var bob = new Person(31, "Bob", 11);
        var jim = new Person(40, "Jimmy", 10);
        var persons = List.of(alice, bob, jim);

        int sumOfEvenAges = getSumOfEvenAges(persons);

        assertThat(sumOfEvenAges).isEqualTo(alice.age() + jim.age());
    }

    @Test
    void testGetSumOfEvenAgesWithSingleEntry() {
        var alice = new Person(20, "Alice", 18);
        var persons = List.of(alice);

        int sumOfEvenAges = getSumOfEvenAges(persons);

        assertThat(sumOfEvenAges).isEqualTo(alice.age());
    }

    @Test
    void testGetSumOfEvenAgesWithEmptyList() {
        int sumOfEvenAges = getSumOfEvenAges(Collections.emptyList());

        assertThat(sumOfEvenAges).isEqualTo(0);
    }
}
