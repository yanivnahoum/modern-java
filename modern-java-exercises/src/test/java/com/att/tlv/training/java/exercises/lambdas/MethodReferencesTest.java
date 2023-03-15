package com.att.tlv.training.java.exercises.lambdas;

import com.att.tlv.training.java.exercises.data.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MethodReferencesTest {

    @Test
    void testIsEmpty() {
        var strings = List.of("Hello", "", "   ", "");

        var filteredStrings = strings.stream()
                .filter(MethodReferences.buildIsEmpty())
                .toList();

        assertThat(filteredStrings).containsExactly("", "");
    }

    @Test
    void testIsEmptyWithEmptyResult() {
        var strings = List.of("Hello", "World");

        var filteredStrings = strings.stream()
                .filter(MethodReferences.buildIsEmpty())
                .toList();

        assertThat(filteredStrings).isEmpty();
    }

    @Test
    void testIsAMinor() {
        var alice = new Person(1, "Alice", MethodReferences.AGE_OF_MAJORITY + 3);
        var bob = new Person(2, "Bob", MethodReferences.AGE_OF_MAJORITY);
        var jim = new Person(3, "Jim", MethodReferences.AGE_OF_MAJORITY - 1);

        var persons = List.of(alice, bob, jim);

        var filteredPersons = persons.stream()
                .filter(MethodReferences.buildIsAMinor())
                .toList();

        assertThat(filteredPersons).containsExactly(jim);
    }

    @Test
    void testIsAMinorWithEmptyResult() {
        var alice = new Person(1, "Alice", MethodReferences.AGE_OF_MAJORITY + 3);
        Person bob = new Person(2, "Bob", MethodReferences.AGE_OF_MAJORITY + 20);
        Person jim = new Person(3, "Jim", MethodReferences.AGE_OF_MAJORITY);

        List<Person> persons = List.of(alice, bob, jim);

        List<Person> filteredPersons = persons.stream()
                .filter(MethodReferences.buildIsAMinor())
                .toList();

        assertThat(filteredPersons).isEmpty();
    }

    @Test
    void testIsAMinorWithMultipleValues() {
        var alice = new Person(1, "Alice", MethodReferences.AGE_OF_MAJORITY - 1);
        var bob = new Person(2, "Bob", MethodReferences.AGE_OF_MAJORITY - 10);
        var jim = new Person(3, "Jim", MethodReferences.AGE_OF_MAJORITY - 5);

        var persons = List.of(alice, bob, jim);

        var filteredPersons = persons.stream()
                .filter(MethodReferences.buildIsAMinor())
                .toList();

        assertThat(filteredPersons).containsExactly(alice, bob, jim);
    }
}
