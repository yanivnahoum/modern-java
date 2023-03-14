package com.att.tlv.training.java8.exercises.optional;

import com.att.tlv.training.java8.exercises.data.Person;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Random;
import java.util.logging.Logger;

import static com.att.tlv.training.java8.exercises.optional.Optionals.findAverageId;
import static com.att.tlv.training.java8.exercises.optional.Optionals.findFirstCentenarian;
import static com.att.tlv.training.java8.exercises.optional.Optionals.findLengthOfLongestName;
import static com.att.tlv.training.java8.exercises.optional.Optionals.getNumberOrRandom;
import static com.att.tlv.training.java8.exercises.optional.Optionals.getNumberOrThrowIllegalArgumentException;
import static com.att.tlv.training.java8.exercises.optional.Optionals.getStringIfItContainsTheLetterW;
import static com.att.tlv.training.java8.exercises.optional.Optionals.logInfoIfPresent;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OptionalsTest {
    
    @Mock
    private Random random;
    @Mock
    private Logger logger;
    
    @Test
    public void testFindLengthOfLongestName() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        List<Person> persons = ImmutableList.of(alice, bob, jim); 
        
        OptionalInt length = findLengthOfLongestName(persons);
        
        assertThat(length).hasValue(alice.getName().length());
    }
    
    @Test
    public void testFindLengthOfLongestNameWithEmptyList() {
        OptionalInt length = findLengthOfLongestName(Collections.emptyList());
        assertThat(length).isEmpty();
    }
    
    @Test
    public void testFindAverageId() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        List<Person> persons = ImmutableList.of(alice, bob, jim); 
        
        OptionalDouble averageId = findAverageId(persons);
        
        double expectedAverageId = (alice.getId() + bob.getId() + jim.getId()) / 3d;
        assertThat(averageId).hasValue(expectedAverageId);
    }
    
    @Test
    public void testFindAverageIdWithEmptyList() {
        OptionalDouble averageId = findAverageId(Collections.emptyList());
        assertThat(averageId).isEmpty();
    }
    
    @Test
    public void testFindFirstCentenarian() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 99);
        Person jim = new Person(3000, "Jim", 21);
        Person john = new Person(4000, "John", 100);
        Person jeff = new Person(4000, "Jeff", 101);
        List<Person> persons = ImmutableList.of(alice, bob, jim, john, jeff); 
        
        Optional<Person> firstCentenarian = findFirstCentenarian(persons);
        
        assertThat(firstCentenarian).hasValue(john);
    }
    
    @Test
    public void testFindFirstCentenarianWithNoCentenarians() {
        Person alice = new Person(1000, "Alice", 18);
        Person bob = new Person(2000, "Bob", 11);
        Person jim = new Person(3000, "Jim", 10);
        List<Person> persons = ImmutableList.of(alice, bob, jim); 
        
        Optional<Person> firstCentenarian = findFirstCentenarian(persons);
        
        assertThat(firstCentenarian).isEmpty();
    }
    
    @Test
    public void testFindFirstCentenarianWithEmptyList() {
        Optional<Person> firstCentenarian = findFirstCentenarian(Collections.emptyList());
        assertThat(firstCentenarian).isEmpty();
    }
    
    @Test
    public void testGetStringIfItContainsTheLetterWInUppercase() {
        String str = "Hello World";
        Optional<String> filtered = getStringIfItContainsTheLetterW(Optional.of(str)); 
        assertThat(filtered).contains(str);
    }
    
    @Test
    public void testGetStringIfItContainsTheLetterWInLowercase() {
        String str = "Hello my world";
        Optional<String> filtered = getStringIfItContainsTheLetterW(Optional.of(str)); 
        assertThat(filtered).contains(str);
    }
    
    @Test
    public void testGetStringIfItContainsTheLetterWWithoutW() {
        String str = "Hello there";
        Optional<String> filtered = getStringIfItContainsTheLetterW(Optional.of(str)); 
        assertThat(filtered).isEmpty();
    }
    
    @Test
    public void testGetStringIfItContainsTheLetterWWithEmptyOptional() {
        Optional<String> filtered = getStringIfItContainsTheLetterW(Optional.empty()); 
        assertThat(filtered).isEmpty();
    }
    
    @Test
    public void testGetNumberOrThrowIllegalArgumentException() {
        long number = 1001L;
        long result = getNumberOrThrowIllegalArgumentException(OptionalLong.of(number)); 
        assertThat(result).isEqualTo(number);
    }
    
    @Test
    public void testGetNumberOrThrowIllegalArgumentExceptionWithEmptyOptional() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> getNumberOrThrowIllegalArgumentException(OptionalLong.empty()));
    }
    
    @Test
    public void testGetNumberOrRandom() {
        double number = 123.5;
        double result = getNumberOrRandom(OptionalDouble.of(number), random); 
        assertThat(result).isEqualTo(number);
        verifyNoInteractions(random);
    }
    
    @Test
    public void testGetNumberOrRandomWithEmptyOptional() {
        double number = 123.5;
        when(random.nextDouble()).thenReturn(number);
        double result = getNumberOrRandom(OptionalDouble.empty(), random); 
        assertThat(result).isEqualTo(number);
    }
    
    @Test
    public void testLogInfoIfPresent() {
        LocalDateTime now = LocalDateTime.now();
        logInfoIfPresent(Optional.of(now), logger); 
        verify(logger).info(now.toString());
    }
    
    @Test
    public void testLogInfoIfPresentWithEmptyOptional() {
        logInfoIfPresent(Optional.empty(), logger);
        verifyNoInteractions(logger);
    }
}
