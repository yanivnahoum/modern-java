package com.att.tlv.training.java.exercises.streams;

import com.att.tlv.training.java.exercises.data.Person;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

class FlatMapTest {

    private static final List<Person> PERSONS_WITH_NO_CHILDREN;

    static {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", 10);
        PERSONS_WITH_NO_CHILDREN = List.of(alice, bob, jim);
    }

    @Test
    void testGetUniqueChildrenNames() {
        final String ANDY = "Andy";
        Person andy = new Person(1002, ANDY, 3);
        Person anna = new Person(1001, "Anna", 5);
        var alice = new Person(1000, "Alice", 35, anna, andy);

        Person bill = new Person(2001, "Bill", 11);
        var bob = new Person(2000, "Bob", 41, bill);

        Person andy2 = new Person(3001, ANDY, 10);
        var jim = new Person(3000, "Jim", 39, andy2);
        var persons = List.of(alice, bob, jim);

        Set<String> names = FlatMap.getUniqueChildrenNames(persons);

        assertThat(names).containsOnly(ANDY, anna.name(), bill.name());
    }

    @Test
    void testGetUniqueChildrenNamesWithEmptyInput() {
        Set<String> names = FlatMap.getUniqueChildrenNames(emptyList());

        assertThat(names).isEmpty();
    }

    @Test
    void testGetUniqueChildrenNamesWithNoChildren() {
        Set<String> names = FlatMap.getUniqueChildrenNames(PERSONS_WITH_NO_CHILDREN);

        assertThat(names).isEmpty();
    }

    @Test
    void testGetSumOfGrandChildrenAges() {
        var alvin = new Person(1003, "Alvin", 10);
        var andy = new Person(1002, "Andy", 41, List.of(alvin));
        var anna = new Person(1001, "Anna", 45);
        var alice = new Person(1000, "Alice", 60, List.of(anna, andy));

        var bill = new Person(2001, "Bill", 11);
        var bob = new Person(2000, "Bob", 41, List.of(bill));

        var gerard = new Person(3001, "Gerard", 1);
        var jonah = new Person(3001, "Jonah", 1);
        var james = new Person(3001, "James", 22, List.of(jonah, gerard));
        var jim = new Person(3000, "Jim", 49, List.of(james));
        var persons = List.of(alice, bob, jim);

        int sum = FlatMap.getSumOfGrandChildrenAges(persons);

        assertThat(sum).isEqualTo(alvin.age() + gerard.age() + jonah.age());
    }

    @Test
    void testGetSumOfGrandChildrenAgesWithEmptyInput() {
        int sum = FlatMap.getSumOfGrandChildrenAges(emptyList());

        assertThat(sum).isZero();
    }

    @Test
    void testGetSumOfGrandChildrenAgesWithNoChildren() {
        int sum = FlatMap.getSumOfGrandChildrenAges(PERSONS_WITH_NO_CHILDREN);

        assertThat(sum).isZero();
    }

    @Test
    void testGetSumOfGrandChildrenAgesWithNoGrandChildren() {
        var andy = new Person(1002, "Andy", 21);
        var anna = new Person(1001, "Anna", 25);
        var alice = new Person(1000, "Alice", 55, List.of(anna, andy));

        var bill = new Person(2001, "Bill", 11);
        var bob = new Person(2000, "Bob", 41, List.of(bill));

        var james = new Person(3001, "James", 22);
        var jim = new Person(3000, "Jim", 49, List.of(james));
        var persons = List.of(alice, bob, jim);

        int sum = FlatMap.getSumOfGrandChildrenAges(persons);

        assertThat(sum).isZero();
    }

    @Test
    void testGetIdsOfChildrenOver21() {
        var andy = new Person(1002, "Andy", 21);
        var anna = new Person(1001, "Anna", 25);
        var alice = new Person(1000, "Alice", 55, List.of(anna, andy));

        var bill = new Person(2001, "Bill", 11);
        var bob = new Person(2000, "Bob", 41, List.of(bill));

        var james = new Person(3001, "James", 22);
        var jim = new Person(3000, "Jim", 49, List.of(james));
        var persons = List.of(alice, bob, jim);

        long[] ids = FlatMap.getIdsOfChildrenOver21(persons);

        assertThat(ids).containsExactly(anna.id(), james.id());
    }

    @Test
    void testGetIdsOfChildrenOver21WithEmptyInput() {
        long[] ids = FlatMap.getIdsOfChildrenOver21(emptyList());

        assertThat(ids).isEmpty();
    }

    @Test
    void testGetIdsOfChildrenOver21WithNoChildren() {
        long[] ids = FlatMap.getIdsOfChildrenOver21(PERSONS_WITH_NO_CHILDREN);

        assertThat(ids).isEmpty();
    }
}
