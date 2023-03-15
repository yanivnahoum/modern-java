package com.att.tlv.training.java.exercises.streams;

import com.att.tlv.training.java.exercises.data.Person;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class GroupingCollectorsTest {

    @Test
    void testGroupById() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        Person carl = new Person(3000, "Carl", 11);
        List<Person> persons = List.of(alice, bob, jim, carl);

        Map<Long, List<Person>> idToPersons = GroupingCollectors.groupById(persons);

        assertThat(idToPersons).containsOnly(entry(alice.id(), listOf(alice)), entry(bob.id(), listOf(bob)), entry(jim.id(), listOf(jim, carl)));
    }

    @Test
    void testGroupByIdWithEmptyList() {
        Map<Long, List<Person>> idToPersons = GroupingCollectors.groupById(Collections.emptyList());

        assertThat(idToPersons).isEmpty();
    }

    @Test
    void testGroupByNameToIds() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        Person carl = new Person(4000, "Jim", 11);
        List<Person> persons = List.of(alice, bob, jim, carl);

        Map<String, List<Long>> nameToIds = GroupingCollectors.groupByNameToIds(persons);

        assertThat(nameToIds).containsOnly(entry(alice.name(), listOf(alice.id())), entry(bob.name(), listOf(bob.id())), entry(jim.name(), listOf(jim.id(), carl.id())));
    }

    @Test
    void testGroupByNameToIdsWithEmptyList() {
        Map<String, List<Long>> nameToIds = GroupingCollectors.groupByNameToIds(Collections.emptyList());

        assertThat(nameToIds).isEmpty();
    }

    @Test
    void testGroupByNameToDistinctAges() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person alice2 = new Person(3000, "Alice", 10);
        Person bob2 = new Person(4000, "Bob", 11);
        Person jim = new Person(5000, "Jim", 10);
        List<Person> persons = List.of(alice, bob, alice2, bob2, jim);

        Map<String, Set<Integer>> nameToAges = GroupingCollectors.groupByNameToDistinctAges(persons);

        assertThat(nameToAges).containsOnly(entry(alice.name(), setOf(alice.age(), alice2.age())), entry(bob.name(), setOf(bob.age())), entry(jim.name(), setOf(jim.age())));
    }

    @Test
    void testGroupByNameToDistinctAgesWithEmptyList() {
        Map<String, Set<Integer>> nameToAges = GroupingCollectors.groupByNameToDistinctAges(Collections.emptyList());

        assertThat(nameToAges).isEmpty();
    }

    @Test
    void testGroupByNameToSumOfAges() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person alice2 = new Person(3000, "Alice", 10);
        List<Person> persons = List.of(alice, bob, alice2);

        Map<String, Integer> nameToSum = GroupingCollectors.groupByNameToSumOfAges(persons);

        assertThat(nameToSum).containsOnly(entry(alice.name(), alice.age() + alice2.age()), entry(bob.name(), bob.age()));
    }

    @Test
    void testGroupByNameToSumOfAgesWithEmptyList() {
        Map<String, Integer> nameToSum = GroupingCollectors.groupByNameToSumOfAges(Collections.emptyList());

        assertThat(nameToSum).isEmpty();
    }

    @Test
    void testGroupByAgeToNameToTotal() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person carl = new Person(3000, "Carl", 11);
        Person bob2 = new Person(4000, "Bob", 11);
        List<Person> persons = List.of(alice, bob, carl, bob2);

        Map<Integer, Map<String, Long>> ageToNameToTotal = GroupingCollectors.groupByAgeToNameToCount(persons);

        assertThat(ageToNameToTotal).containsOnlyKeys(alice.age(), bob.age());
        assertThat(ageToNameToTotal.get(alice.age())).containsOnly(entry(alice.name(), 1L));
        assertThat(ageToNameToTotal.get(bob.age())).containsOnly(entry(bob.name(), 2L), entry(carl.name(), 1L));
    }

    @Test
    void testGroupByAgeToNameToTotalWithEmptyList() {
        Map<Integer, Map<String, Long>> ageToNameToTotal = GroupingCollectors.groupByAgeToNameToCount(Collections.emptyList());

        assertThat(ageToNameToTotal).isEmpty();
    }

    @Test
    void testPartitionByIsAllowedToVote() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 21);
        Person jim = new Person(3000, "Jim", 10);
        Person carl = new Person(4000, "Carl", 11);
        List<Person> persons = List.of(alice, bob, jim, carl);

        Map<Boolean, List<Person>> voters = GroupingCollectors.partitionByIsAllowedToVote(persons);

        assertThat(voters).containsOnly(entry(true, listOf(alice, bob)), entry(false, listOf(jim, carl)));
    }

    @Test
    void testPartitionByIsAllowedToVoteWithEmptyList() {
        Map<Boolean, List<Person>> voters = GroupingCollectors.partitionByIsAllowedToVote(Collections.emptyList());

        assertThat(voters).containsOnly(entry(true, Collections.emptyList()), entry(false, Collections.emptyList()));
    }

    @SafeVarargs
    private static <T> List<T> listOf(T... items) {
        return List.of(items);
    }
    
    @SafeVarargs
    private static <T> Set<T> setOf(T... items) {
        return Set.of(items);
    }
}
