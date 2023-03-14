package com.att.tlv.training.java8.exercises.lambdas;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static com.att.tlv.training.java8.exercises.lambdas.MethodReferences.*;

import java.util.List;

import org.junit.Test;

import com.att.tlv.training.java8.exercises.data.Person;
import com.google.common.collect.ImmutableList;

public class MethodReferencesTest {
    
    @Test
    public void testIsEmpty() {
        ImmutableList<String> strings = ImmutableList.of("Hello", "", "   ", "");
        
        List<String> filteredStrings = strings.stream()
                .filter(buildIsEmpty())
                .collect(toList());
        
        assertThat(filteredStrings).containsExactly("", "");
    }
    
    @Test
    public void testIsEmptyWithEmptyResult() {
        ImmutableList<String> strings = ImmutableList.of("Hello", "World");
        
        List<String> filteredStrings = strings.stream()
                .filter(buildIsEmpty())
                .collect(toList());
        
        assertThat(filteredStrings).isEmpty();
    }

    @Test
    public void testIsAMinor() {
        Person alice = new Person(1, "Alice", AGE_OF_MAJORITY + 3);
        Person bob = new Person(2, "Bob", AGE_OF_MAJORITY);
        Person jim = new Person(3, "Jim", AGE_OF_MAJORITY - 1);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        List<Person> filteredPersons = persons.stream()
                .filter(buildIsAMinor())
                .collect(toList());

        assertThat(filteredPersons).containsExactly(jim);
    }

    @Test
    public void testIsAMinorWithEmptyResult() {
        Person alice = new Person(1, "Alice", AGE_OF_MAJORITY + 3);
        Person bob = new Person(2, "Bob", AGE_OF_MAJORITY + 20);
        Person jim = new Person(3, "Jim", AGE_OF_MAJORITY);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        List<Person> filteredPersons = persons.stream()
                .filter(buildIsAMinor())
                .collect(toList());

        assertThat(filteredPersons).isEmpty();
    }

    @Test
    public void testIsAMinorWithMultipleValues() {
        Person alice = new Person(1, "Alice", AGE_OF_MAJORITY - 1);
        Person bob = new Person(2, "Bob", AGE_OF_MAJORITY - 10);
        Person jim = new Person(3, "Jim", AGE_OF_MAJORITY - 5);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        List<Person> filteredPersons = persons.stream()
                .filter(buildIsAMinor())
                .collect(toList());

        assertThat(filteredPersons).containsExactly(alice, bob, jim);
    }
}
