package com.att.tlv.training.java.exercises.lambdas;

import com.att.tlv.training.java.exercises.data.Person;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class LambdaSyntaxTest {

    @Test
    void testBuildIdEquals() {
        Person alice = new Person(1, "Alice", 20);
        Person bob = new Person(2, "Bob", 25);
        Person jim = new Person(3, "Jim", 30);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        List<Person> filteredPersons = persons.stream()
                .filter(LambdaSyntax.buildIdEquals(bob.getId()))
                .collect(toList());

        assertThat(filteredPersons).containsExactly(bob);
    }

    @Test
    void testBuildIdEqualsWithEmptyResult() {
        long baseId = 10L;
        Person alice = new Person(baseId + 1, "Alice", 20);
        Person bob = new Person(baseId + 2, "Bob", 25);
        Person jim = new Person(baseId + 3, "Jim", 30);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        List<Person> filteredPersons = persons.stream()
                .filter(LambdaSyntax.buildIdEquals(baseId))
                .collect(toList());

        assertThat(filteredPersons).isEmpty();
    }

    @Test
    void testBuildIdEqualsWithMultipleValues() {
        long id = 1L;
        Person alice = new Person(id, "Alice", 20);
        Person bob = new Person(id, "Bob", 25);
        Person jim = new Person(3, "Jim", 30);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        List<Person> filteredPersons = persons.stream()
                .filter(LambdaSyntax.buildIdEquals(id))
                .collect(toList());

        assertThat(filteredPersons).containsExactly(alice, bob);
    }

    @Test
    void testBuildNameStartsWith() {
        Person alice = new Person(1, "Alice", 20);
        Person bob = new Person(2, "Bob", 25);
        Person jim = new Person(3, "Jim", 30);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        String prefix = alice.getName()
                .substring(0, 2);
        List<Person> filteredPersons = persons.stream()
                .filter(LambdaSyntax.buildNameStartsWith(prefix))
                .collect(toList());

        assertThat(filteredPersons).containsExactly(alice);
    }

    @Test
    void testBuildNameStartsWithWithEmptyResult() {
        Person alice = new Person(1, "Alice", 20);
        Person bob = new Person(2, "Bob", 25);
        Person jim = new Person(3, "Jim", 30);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        String prefix = alice.getName() + "In Wonderland";
        List<Person> filteredPersons = persons.stream()
                .filter(LambdaSyntax.buildNameStartsWith(prefix))
                .collect(toList());
                
        assertThat(filteredPersons).isEmpty();
    }

    @Test
    void testBuildNameStartsWithWithMultipleValues() {
        Person aliceSmith = new Person(1, "Alice Smith", 20);
        Person bob = new Person(2, "Bob", 25);
        Person aliceAnderson = new Person(3, "Alice Anderson", 30);

        List<Person> persons = ImmutableList.of(aliceSmith, bob, aliceAnderson);

        String prefix = aliceSmith.getName()
                .substring(0, 2);
        List<Person> filteredPersons = persons.stream()
                .filter(LambdaSyntax.buildNameStartsWith(prefix))
                .collect(toList());

        assertThat(filteredPersons).containsExactly(aliceSmith, aliceAnderson);
    }
}
