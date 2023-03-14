package com.att.tlv.training.java8.exercises.streams;

import static com.att.tlv.training.java8.exercises.streams.BasicCollectors.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.att.tlv.training.java8.exercises.data.Person;
import com.google.common.collect.ImmutableList;

public class BasicCollectorsTest {

    @Test
    public void testGetNames() {
        Person alice = new Person(1000, "Alice", 1);
        Person bob = new Person(2000, "Bob", 2);
        Person jim = new Person(3000, "Jim", 3);
        List<Person> persons = ImmutableList.of(alice, bob, jim);

        List<String> names = getNames(persons);

        assertThat(names).containsExactly(alice.getName(), bob.getName(), jim.getName());
    }
    
    @Test
    public void testGetNamesEmptyInput() {
        List<String> names = getNames(Collections.emptyList());
        
        assertThat(names).isEmpty();
    }

    @Test
    public void testGetMinorsOnly() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        List<Person> persons = ImmutableList.of(alice, bob, jim);

        LinkedList<Person> minors = getMinorsOnly(persons);

        assertThat(minors).containsExactly(bob, jim);
    }
    
    @Test
    public void testGetMinorsOnlyEmptyInput() {
        LinkedList<Person> minors = getMinorsOnly(Collections.emptyList());
        
        assertThat(minors).isEmpty();
    }

    @Test
    public void testMapIdToPerson() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        List<Person> persons = ImmutableList.of(alice, bob, jim);

        Map<Long, Person> idToPerson = mapIdToPerson(persons);

        assertThat(idToPerson).containsOnly(entry(alice.getId(), alice), entry(bob.getId(), bob), entry(jim.getId(), jim)); 
    }
    
    @Test
    public void testMapIdToPersonEmptyInput() {
        Map<Long, Person> idToPerson = mapIdToPerson(Collections.emptyList());
        
        assertThat(idToPerson).isEmpty(); 
    }
    
    @Test(expected = IllegalStateException.class)
    public void testMapIdToPersonWithDuplicate() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(1000, "Bob", 11);
        List<Person> persons = ImmutableList.of(alice, bob);
        
        // Boom
        mapIdToPerson(persons);
    }

    @Test
    public void testMapAgeToNames() {
        int duplicateAge = 18;
        Person alice = new Person(1000, "Alice", duplicateAge);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", duplicateAge);
        List<Person> persons = ImmutableList.of(alice, bob, jim);

        Map<Integer, String> ageToNames = mapAgeToNames(persons);

        assertThat(ageToNames).containsOnly(entry(duplicateAge, alice.getName() + jim.getName()), entry(bob.getAge(), bob.getName())); 
    }
    
    @Test
    public void testMapAgeToNamesEmptyInput() {
        Map<Integer, String> ageToNames = mapAgeToNames(Collections.emptyList());
        
        assertThat(ageToNames).isEmpty(); 
    }

    @Test
    public void testMapNameToCount() {
        final String ALICE = "Alice";
        Person alice = new Person(1000, ALICE, 18);
        Person bob = new Person(2000, "Bob", 11);
        Person alice2 = new Person(3000, ALICE, 10);
        List<Person> persons = ImmutableList.of(alice, bob, alice2);

        Map<String, Long> nameToCount = mapNameToCount(persons);
        
        assertThat(nameToCount).containsOnly(entry(ALICE, 2L), entry(bob.getName(), 1L)); 
    }
    
    @Test
    public void testMapNameToCountEmptyInput() {
        Map<String, Long> nameToCount = mapNameToCount(Collections.emptyList());
        
        assertThat(nameToCount).isEmpty(); 
    }
}
