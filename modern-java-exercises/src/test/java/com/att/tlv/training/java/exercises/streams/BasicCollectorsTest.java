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
        Person alice = new Person(1000, "Alice", 1);
        Person bob = new Person(2000, "Bob", 2);
        Person jim = new Person(3000, "Jim", 3);
        List<Person> persons = List.of(alice, bob, jim);

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
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        List<Person> persons = List.of(alice, bob, jim);

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
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        List<Person> persons = List.of(alice, bob, jim);

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
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(1000, "Bob", 11);
        List<Person> persons = List.of(alice, bob);

        // Boom
        assertThatIllegalStateException().isThrownBy(() -> BasicCollectors.mapIdToPerson(persons));
    }

    @Test
    void testMapAgeToNames() {
        int duplicateAge = 18;
        Person alice = new Person(1000, "Alice", duplicateAge);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", duplicateAge);
        List<Person> persons = List.of(alice, bob, jim);

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
        Person alice = new Person(1000, ALICE, 18);
        Person bob = new Person(2000, "Bob", 11);
        Person alice2 = new Person(3000, ALICE, 10);
        List<Person> persons = List.of(alice, bob, alice2);

        Map<String, Long> nameToCount = BasicCollectors.mapNameToCount(persons);

        assertThat(nameToCount).containsOnly(entry(ALICE, 2L), entry(bob.name(), 1L));
    }

    @Test
    void testMapNameToCountEmptyInput() {
        Map<String, Long> nameToCount = BasicCollectors.mapNameToCount(Collections.emptyList());

        assertThat(nameToCount).isEmpty();
    }
}
