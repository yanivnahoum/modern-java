package com.att.tlv.training.java.exercises.streams;

import com.att.tlv.training.java.exercises.data.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FilterMapReduceTest {

    @Test
    void testAddUp() {
        int[] numbers = new int[]{ 1, 2, 3, 4 };
        int actual = FilterMapReduce.addUp(numbers);
        int expected = 1 + 2 + 3 + 4;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testAddUpNoArgs() {
        int[] numbers = new int[]{};
        int actual = FilterMapReduce.addUp(numbers);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void testGetProductOfAgesWhereIdIsGreaterThan1005() {
        Person alice = new Person(1000, "Alice", 1);
        Person bob = new Person(2000, "Bob", 2);
        Person jim = new Person(3000, "Jim", 3);
        List<Person> persons = List.of(alice, bob, jim);

        int product = FilterMapReduce.getProductOfAgesWhereIdIsGreaterThan1005(persons);

        assertThat(product).isEqualTo(bob.age() * jim.age());
    }

    @Test
    void testGetProductOfAgesWhereIdIsGreaterThan1005_EmptySet() {
        Person alice = new Person(1000, "Alice", 1);
        Person bob = new Person(200, "Bob", 2);
        Person jim = new Person(300, "Jim", 3);
        List<Person> persons = List.of(alice, bob, jim);

        int product = FilterMapReduce.getProductOfAgesWhereIdIsGreaterThan1005(persons);

        assertThat(product).isEqualTo(1);
    }

    @Test
    void testGetMinIdWhereNameHasAnAOrMinus1() {
        Person alice = new Person(1000, "Alice", 1);
        Person bob = new Person(2000, "Bob", 2);
        Person jim = new Person(100, "Jim", 3);
        Person dan = new Person(300, "Dan", 4);
        List<Person> persons = List.of(alice, bob, jim, dan);

        long minId = FilterMapReduce.getMinIdWhereNameHasAnAOrMinus1(persons);

        assertThat(minId).isEqualTo(dan.id());
    }

    @Test
    void testGetMinIdWhereNameHasAnAOrMinus1_EmptySet() {
        Person henry = new Person(1000, "Henry", 1);
        Person bob = new Person(2000, "Bob", 2);
        Person jim = new Person(100, "Jim", 3);
        Person don = new Person(300, "Don", 4);
        List<Person> persons = List.of(henry, bob, jim, don);

        long minId = FilterMapReduce.getMinIdWhereNameHasAnAOrMinus1(persons);

        assertThat(minId).isEqualTo(-1);
    }
}
