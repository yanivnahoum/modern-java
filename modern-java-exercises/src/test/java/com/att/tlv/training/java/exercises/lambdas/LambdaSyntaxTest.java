package com.att.tlv.training.java.exercises.lambdas;

import com.att.tlv.training.java.exercises.data.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LambdaSyntaxTest {

    @Test
    void testBuildIdEquals() {
        var alice = new Person(1, "Alice", 20);
        var bob = new Person(2, "Bob", 25);
        var jim = new Person(3, "Jim", 30);

        var persons = List.of(alice, bob, jim);

        var filteredPersons = persons.stream()
                .filter(LambdaSyntax.buildIdEquals(bob.id()))
                .toList();

        assertThat(filteredPersons).containsExactly(bob);
    }

    @Test
    void testBuildIdEqualsWithEmptyResult() {
        long baseId = 10L;
        var alice = new Person(baseId + 1, "Alice", 20);
        var bob = new Person(baseId + 2, "Bob", 25);
        Person jim = new Person(baseId + 3, "Jim", 30);

        var persons = List.of(alice, bob, jim);

        var filteredPersons = persons.stream()
                .filter(LambdaSyntax.buildIdEquals(baseId))
                .toList();

        assertThat(filteredPersons).isEmpty();
    }

    @Test
    void testBuildIdEqualsWithMultipleValues() {
        long id = 1L;
        var alice = new Person(id, "Alice", 20);
        var bob = new Person(id, "Bob", 25);
        var jim = new Person(3, "Jim", 30);

        var persons = List.of(alice, bob, jim);

        var filteredPersons = persons.stream()
                .filter(LambdaSyntax.buildIdEquals(id))
                .toList();

        assertThat(filteredPersons).containsExactly(alice, bob);
    }

    @Test
    void testBuildNameStartsWith() {
        var alice = new Person(1, "Alice", 20);
        var bob = new Person(2, "Bob", 25);
        var jim = new Person(3, "Jim", 30);

        var persons = List.of(alice, bob, jim);

        String prefix = alice.name()
                .substring(0, 2);
        var filteredPersons = persons.stream()
                .filter(LambdaSyntax.buildNameStartsWith(prefix))
                .toList();

        assertThat(filteredPersons).containsExactly(alice);
    }

    @Test
    void testBuildNameStartsWithWithEmptyResult() {
        var alice = new Person(1, "Alice", 20);
        var bob = new Person(2, "Bob", 25);
        var jim = new Person(3, "Jim", 30);

        var persons = List.of(alice, bob, jim);

        String prefix = alice.name() + "In Wonderland";
        var filteredPersons = persons.stream()
                .filter(LambdaSyntax.buildNameStartsWith(prefix))
                .toList();

        assertThat(filteredPersons).isEmpty();
    }

    @Test
    void testBuildNameStartsWithWithMultipleValues() {
        var aliceSmith = new Person(1, "Alice Smith", 20);
        var bob = new Person(2, "Bob", 25);
        var aliceAnderson = new Person(3, "Alice Anderson", 30);

        var persons = List.of(aliceSmith, bob, aliceAnderson);

        String prefix = aliceSmith.name()
                .substring(0, 2);
        var filteredPersons = persons.stream()
                .filter(LambdaSyntax.buildNameStartsWith(prefix))
                .toList();

        assertThat(filteredPersons).containsExactly(aliceSmith, aliceAnderson);
    }
}
