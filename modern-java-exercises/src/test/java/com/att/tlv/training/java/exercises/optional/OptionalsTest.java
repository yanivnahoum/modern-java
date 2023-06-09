package com.att.tlv.training.java.exercises.optional;

import com.att.tlv.training.java.exercises.data.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Random;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OptionalsTest {

    @Mock
    private Random random;
    @Mock
    private Logger logger;

    @Test
    void testFindLengthOfLongestName() {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", 10);
        var persons = List.of(alice, bob, jim);

        OptionalInt length = Optionals.findLengthOfLongestName(persons);

        assertThat(length).hasValue(alice.name().length());
    }

    @Test
    void testFindLengthOfLongestNameWithEmptyList() {
        OptionalInt length = Optionals.findLengthOfLongestName(Collections.emptyList());
        assertThat(length).isEmpty();
    }

    @Test
    void testFindAverageId() {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", 10);
        var persons = List.of(alice, bob, jim);

        OptionalDouble averageId = Optionals.findAverageId(persons);

        double expectedAverageId = (alice.id() + bob.id() + jim.id()) / 3d;
        assertThat(averageId).hasValue(expectedAverageId);
    }

    @Test
    void testFindAverageIdWithEmptyList() {
        OptionalDouble averageId = Optionals.findAverageId(Collections.emptyList());
        assertThat(averageId).isEmpty();
    }

    @Test
    void testFindFirstCentenarian() {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(2000, "Bob", 99);
        var jim = new Person(3000, "Jim", 21);
        var john = new Person(4000, "John", 100);
        var jeff = new Person(4000, "Jeff", 101);
        var persons = List.of(alice, bob, jim, john, jeff);

        Optional<Person> firstCentenarian = Optionals.findFirstCentenarian(persons);

        assertThat(firstCentenarian).hasValue(john);
    }

    @Test
    void testFindFirstCentenarianWithNoCentenarians() {
        var alice = new Person(1000, "Alice", 18);
        var bob = new Person(2000, "Bob", 11);
        var jim = new Person(3000, "Jim", 10);
        var persons = List.of(alice, bob, jim);

        Optional<Person> firstCentenarian = Optionals.findFirstCentenarian(persons);

        assertThat(firstCentenarian).isEmpty();
    }

    @Test
    void testFindFirstCentenarianWithEmptyList() {
        Optional<Person> firstCentenarian = Optionals.findFirstCentenarian(Collections.emptyList());
        assertThat(firstCentenarian).isEmpty();
    }

    @Test
    void testGetStringIfItContainsTheLetterWInUppercase() {
        String str = "Hello World";
        Optional<String> filtered = Optionals.getStringIfItContainsTheLetterW(Optional.of(str));
        assertThat(filtered).contains(str);
    }

    @Test
    void testGetStringIfItContainsTheLetterWInLowercase() {
        String str = "Hello my world";
        Optional<String> filtered = Optionals.getStringIfItContainsTheLetterW(Optional.of(str));
        assertThat(filtered).contains(str);
    }

    @Test
    void testGetStringIfItContainsTheLetterWWithoutW() {
        String str = "Hello there";
        Optional<String> filtered = Optionals.getStringIfItContainsTheLetterW(Optional.of(str));
        assertThat(filtered).isEmpty();
    }

    @Test
    void testGetStringIfItContainsTheLetterWWithEmptyOptional() {
        Optional<String> filtered = Optionals.getStringIfItContainsTheLetterW(Optional.empty());
        assertThat(filtered).isEmpty();
    }

    @Test
    void testGetNumberOrThrowIllegalArgumentException() {
        long number = 1001L;
        long result = Optionals.getNumberOrThrowIllegalArgumentException(OptionalLong.of(number));
        assertThat(result).isEqualTo(number);
    }

    @Test
    void testGetNumberOrThrowIllegalArgumentExceptionWithEmptyOptional() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Optionals.getNumberOrThrowIllegalArgumentException(OptionalLong.empty()));
    }

    @Test
    void testGetNumberOrRandom() {
        double number = 123.5;
        double result = Optionals.getNumberOrRandom(OptionalDouble.of(number), random);
        assertThat(result).isEqualTo(number);
        verifyNoInteractions(random);
    }

    @Test
    void testGetNumberOrRandomWithEmptyOptional() {
        double number = 123.5;
        when(random.nextDouble()).thenReturn(number);
        double result = Optionals.getNumberOrRandom(OptionalDouble.empty(), random);
        assertThat(result).isEqualTo(number);
    }

    @Test
    void testLogInfoIfPresent() {
        LocalDateTime now = LocalDateTime.now();
        Optionals.logInfoIfPresent(Optional.of(now), logger);
        verify(logger).info(now.toString());
    }

    @Test
    void testLogInfoIfPresentWithEmptyOptional() {
        Optionals.logInfoIfPresent(Optional.empty(), logger);
        verifyNoInteractions(logger);
    }

    @Test
    void testGetAllChildrenUnderTheAgeOfThree() {
        var anna = new Person(1001, "Anna", 3);
        var ari = new Person(1002, "Ari", 2);
        var aldo = new Person(1003, "Aldo", 1);
        var alice = new Person(1000, "Alice", 40, List.of(anna, ari, aldo));

        var bob = new Person(2000, "Bob", 18);

        var john = new Person(1001, "John", 1);
        var jane = new Person(1002, "Jane", 6);
        var jim = new Person(3000, "Jim", 30, List.of(john, jane));
        List<Optional<Person>> parents = List.of(
                Optional.of(alice), Optional.empty(), Optional.of(bob), Optional.empty(), Optional.of(jim)
        );

        var babies = Optionals.getAllChildrenUnderTheAgeOfThree(parents);

        assertThat(babies).containsExactly(ari, aldo, john);
    }
}
