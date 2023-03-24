package com.att.tlv.training.java.exercises.streams;

import com.att.tlv.training.java.exercises.data.Person;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.entry;

class BasicCollectorsTest {

    @Test
    void testGetNames() {
        var alice = new Person(1000, "Alice", 1);
        var bob = new Person(2000, "Bob", 2);
        var jim = new Person(3000, "Jim", 3);
        var persons = List.of(alice, bob, jim);

        List<String> names = BasicCollectors.getNames(persons);

        assertThat(names).containsExactly(alice.name(), bob.name(), jim.name());
    }

    @Test
    void testGetNamesEmptyInput() {
        List<String> names = BasicCollectors.getNames(Collections.emptyList());

        assertThat(names).isEmpty();
    }

    @Test
    void testGetMinorsOnly() {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", 10);
        var persons = List.of(alice, bob, jim);

        LinkedList<Person> minors = BasicCollectors.getMinorsOnly(persons);

        assertThat(minors).containsExactly(bob, jim);
    }

    @Test
    void testGetMinorsOnlyEmptyInput() {
        LinkedList<Person> minors = BasicCollectors.getMinorsOnly(Collections.emptyList());

        assertThat(minors).isEmpty();
    }

    @Test
    void testMapIdToPerson() {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", 10);
        var persons = List.of(alice, bob, jim);

        Map<Long, Person> idToPerson = BasicCollectors.mapIdToPerson(persons);

        assertThat(idToPerson).containsOnly(entry(alice.id(), alice), entry(bob.id(), bob), entry(jim.id(), jim));
    }

    @Test
    void testMapIdToPersonEmptyInput() {
        Map<Long, Person> idToPerson = BasicCollectors.mapIdToPerson(Collections.emptyList());

        assertThat(idToPerson).isEmpty();
    }

    @Test
    void testMapIdToPersonWithDuplicate() {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(1000, "Bob", 11);
        var persons = List.of(alice, bob);

        // Boom
        assertThatIllegalStateException().isThrownBy(() -> BasicCollectors.mapIdToPerson(persons));
    }

    @Test
    void testMapAgeToNames() {
        int duplicateAge = 18;
        var alice = new Person(1000, "Alice", duplicateAge);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", duplicateAge);
        var persons = List.of(alice, bob, jim);

        Map<Integer, String> ageToNames = BasicCollectors.mapAgeToNames(persons);

        assertThat(ageToNames).containsOnly(entry(duplicateAge, alice.name() + jim.name()), entry(bob.age(), bob.name()));
    }

    @Test
    void testMapAgeToNamesEmptyInput() {
        Map<Integer, String> ageToNames = BasicCollectors.mapAgeToNames(Collections.emptyList());

        assertThat(ageToNames).isEmpty();
    }

    @Test
    void testMapNameToCount() {
        final String ALICE = "Alice";
        var alice = new Person(1000, ALICE, 18);
        var bob = new Person(2000, "Bob", 11);
        Person alice2 = new Person(3000, ALICE, 10);
        var persons = List.of(alice, bob, alice2);

        Map<String, Long> nameToCount = BasicCollectors.mapNameToCount(persons);

        assertThat(nameToCount).containsOnly(entry(ALICE, 2L), entry(bob.name(), 1L));
    }

    @Test
    void testMapNameToCountEmptyInput() {
        Map<String, Long> nameToCount = BasicCollectors.mapNameToCount(Collections.emptyList());

        assertThat(nameToCount).isEmpty();
    }
}
