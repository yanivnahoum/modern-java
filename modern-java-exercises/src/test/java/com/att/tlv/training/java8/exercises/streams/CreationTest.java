package com.att.tlv.training.java8.exercises.streams;

import static com.att.tlv.training.java8.exercises.streams.Creation.*;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class CreationTest {

    @Test
    public void testGetOddNumbers() {
        int[] oddNumbers = getOddNumbers(3, 4).toArray();

        assertThat(oddNumbers).containsExactly(7, 9, 11, 13);
    }
    
    @Test
    public void testGetOddNumbersSkipZero() {
        int[] oddNumbers = getOddNumbers(0, 3).toArray();
        
        assertThat(oddNumbers).containsExactly(1, 3, 5);
    }
    
    @Test
    public void testGetOddNumbersTakeNone() {
        int[] oddNumbers = getOddNumbers(5, 0).toArray();
        
        assertThat(oddNumbers).isEmpty();
    }

    @Test
    public void testGetInfiniteHelloStream() {
        int size = 1000;
        List<String> hellos = getInfiniteHelloStream().limit(size)
                .collect(toList());
        
        assertThat(hellos).hasSize(size);        
        assertThat(hellos).allMatch(s -> "Hello".equals(s));
    }
    
    @Test
    public void testGetInfiniteHelloStreamTakeNone() {
        List<String> hellos = getInfiniteHelloStream().limit(0)
                .collect(toList());
        
        assertThat(hellos).isEmpty();
    }

    @Test
    public void testGetRange() {
        long[] sequence = getRange(10, 16).toArray();
        assertThat(sequence).containsExactly(10, 11, 12, 13, 14, 15);
    }
    
    @Test
    public void testGetRangeEndIndexEqualToStart() {
        long[] sequence = getRange(10, 10).toArray();
        assertThat(sequence).isEmpty();
    }
    
    @Test
    public void testGetRangeEndIndexLessThanStart() {
        long[] sequence = getRange(10, 9).toArray();
        assertThat(sequence).isEmpty();
    }

    @Test
    public void testToDoubleStream() {
        double v1 = 10.5d;
        double v2 = 11.1234d;
        double[] doubles = toDoubleStream(v1, v2).toArray();
        
        assertThat(doubles).containsExactly(v1, v2);
    }

    @Test
    public void testToStream() {
        String[] input = "How are you".split(" ");
        Object[] actual = toStream(input).toArray();
        
        assertThat(actual).isEqualTo(input);
    }
    
    @Test
    public void testToStreamEmpty() {
        Object[] actual = toStream().toArray();
        
        assertThat(actual).isEmpty();
    }
}