package com.att.tlv.training.java.exercises.lambdas;

import com.att.tlv.training.java.exercises.data.Person;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class MethodReferencesTest {

    @Test
    void testIsEmpty() {
        ImmutableList<String> strings = ImmutableList.of("Hello", "", "   ", "");

        List<String> filteredStrings = strings.stream()
                .filter(MethodReferences.buildIsEmpty())
                .collect(toList());

        assertThat(filteredStrings).containsExactly("", "");
    }

    @Test
    void testIsEmptyWithEmptyResult() {
        ImmutableList<String> strings = ImmutableList.of("Hello", "World");

        List<String> filteredStrings = strings.stream()
                .filter(MethodReferences.buildIsEmpty())
                .collect(toList());

        assertThat(filteredStrings).isEmpty();
    }

    @Test
    void testIsAMinor() {
        Person alice = new Person(1, "Alice", MethodReferences.AGE_OF_MAJORITY + 3);
        Person bob = new Person(2, "Bob", MethodReferences.AGE_OF_MAJORITY);
        Person jim = new Person(3, "Jim", MethodReferences.AGE_OF_MAJORITY - 1);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        List<Person> filteredPersons = persons.stream()
                .filter(MethodReferences.buildIsAMinor())
                .collect(toList());

        assertThat(filteredPersons).containsExactly(jim);
    }

    @Test
    void testIsAMinorWithEmptyResult() {
        Person alice = new Person(1, "Alice", MethodReferences.AGE_OF_MAJORITY + 3);
        Person bob = new Person(2, "Bob", MethodReferences.AGE_OF_MAJORITY + 20);
        Person jim = new Person(3, "Jim", MethodReferences.AGE_OF_MAJORITY);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        List<Person> filteredPersons = persons.stream()
                .filter(MethodReferences.buildIsAMinor())
                .collect(toList());

        assertThat(filteredPersons).isEmpty();
    }

    @Test
    void testIsAMinorWithMultipleValues() {
        Person alice = new Person(1, "Alice", MethodReferences.AGE_OF_MAJORITY - 1);
        Person bob = new Person(2, "Bob", MethodReferences.AGE_OF_MAJORITY - 10);
        Person jim = new Person(3, "Jim", MethodReferences.AGE_OF_MAJORITY - 5);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        List<Person> filteredPersons = persons.stream()
                .filter(MethodReferences.buildIsAMinor())
                .collect(toList());

        assertThat(filteredPersons).containsExactly(alice, bob, jim);
    }
}
