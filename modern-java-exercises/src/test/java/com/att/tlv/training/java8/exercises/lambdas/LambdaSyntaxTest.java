package com.att.tlv.training.java8.exercises.lambdas;

import static com.att.tlv.training.java8.exercises.lambdas.LambdaSyntax.*;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.att.tlv.training.java8.exercises.data.Person;
import com.google.common.collect.ImmutableList;

public class LambdaSyntaxTest {

    @Test
    public void testBuildIdEquals() {
        Person alice = new Person(1, "Alice", 20);
        Person bob = new Person(2, "Bob", 25);
        Person jim = new Person(3, "Jim", 30);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        List<Person> filteredPersons = persons.stream()
                .filter(buildIdEquals(bob.getId()))
                .collect(toList());

        assertThat(filteredPersons).containsExactly(bob);
    }

    @Test
    public void testBuildIdEqualsWithEmptyResult() {
        long baseId = 10L;
        Person alice = new Person(baseId + 1, "Alice", 20);
        Person bob = new Person(baseId + 2, "Bob", 25);
        Person jim = new Person(baseId + 3, "Jim", 30);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        List<Person> filteredPersons = persons.stream()
                .filter(buildIdEquals(baseId))
                .collect(toList());

        assertThat(filteredPersons).isEmpty();
    }

    @Test
    public void testBuildIdEqualsWithMultipleValues() {
        long id = 1L;
        Person alice = new Person(id, "Alice", 20);
        Person bob = new Person(id, "Bob", 25);
        Person jim = new Person(3, "Jim", 30);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        List<Person> filteredPersons = persons.stream()
                .filter(buildIdEquals(id))
                .collect(toList());

        assertThat(filteredPersons).containsExactly(alice, bob);
    }

    @Test
    public void testBuildNameStartsWith() {
        Person alice = new Person(1, "Alice", 20);
        Person bob = new Person(2, "Bob", 25);
        Person jim = new Person(3, "Jim", 30);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        String prefix = alice.getName()
                .substring(0, 2);
        List<Person> filteredPersons = persons.stream()
                .filter(buildNameStartsWith(prefix))
                .collect(toList());

        assertThat(filteredPersons).containsExactly(alice);
    }

    @Test
    public void testBuildNameStartsWithWithEmptyResult() {
        Person alice = new Person(1, "Alice", 20);
        Person bob = new Person(2, "Bob", 25);
        Person jim = new Person(3, "Jim", 30);

        List<Person> persons = ImmutableList.of(alice, bob, jim);

        String prefix = alice.getName() + "In Wonderland";
        List<Person> filteredPersons = persons.stream()
                .filter(buildNameStartsWith(prefix))
                .collect(toList());
                
        assertThat(filteredPersons).isEmpty();
    }

    @Test
    public void testBuildNameStartsWithWithMultipleValues() {
        Person aliceSmith = new Person(1, "Alice Smith", 20);
        Person bob = new Person(2, "Bob", 25);
        Person aliceAnderson = new Person(3, "Alice Anderson", 30);

        List<Person> persons = ImmutableList.of(aliceSmith, bob, aliceAnderson);

        String prefix = aliceSmith.getName()
                .substring(0, 2);
        List<Person> filteredPersons = persons.stream()
                .filter(buildNameStartsWith(prefix))
                .collect(toList());

        assertThat(filteredPersons).containsExactly(aliceSmith, aliceAnderson);
    }
}
