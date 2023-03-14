package com.att.tlv.training.java.exercises.streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class CreationTest {

    @Test
    void testGetOddNumbers() {
        int[] oddNumbers = Creation.getOddNumbers(3, 4).toArray();

        assertThat(oddNumbers).containsExactly(7, 9, 11, 13);
    }

    @Test
    void testGetOddNumbersSkipZero() {
        int[] oddNumbers = Creation.getOddNumbers(0, 3).toArray();

        assertThat(oddNumbers).containsExactly(1, 3, 5);
    }

    @Test
    void testGetOddNumbersTakeNone() {
        int[] oddNumbers = Creation.getOddNumbers(5, 0).toArray();

        assertThat(oddNumbers).isEmpty();
    }

    @Test
    void testGetInfiniteHelloStream() {
        int size = 1000;
        List<String> hellos = Creation.getInfiniteHelloStream().limit(size)
                .collect(toList());

        assertThat(hellos).hasSize(size);
        assertThat(hellos).allMatch(s -> "Hello".equals(s));
    }

    @Test
    void testGetInfiniteHelloStreamTakeNone() {
        List<String> hellos = Creation.getInfiniteHelloStream().limit(0)
                .collect(toList());

        assertThat(hellos).isEmpty();
    }

    @Test
    void testGetRange() {
        long[] sequence = Creation.getRange(10, 16).toArray();
        assertThat(sequence).containsExactly(10, 11, 12, 13, 14, 15);
    }

    @Test
    void testGetRangeEndIndexEqualToStart() {
        long[] sequence = Creation.getRange(10, 10).toArray();
        assertThat(sequence).isEmpty();
    }

    @Test
    void testGetRangeEndIndexLessThanStart() {
        long[] sequence = Creation.getRange(10, 9).toArray();
        assertThat(sequence).isEmpty();
    }

    @Test
    void testToDoubleStream() {
        double v1 = 10.5d;
        double v2 = 11.1234d;
        double[] doubles = Creation.toDoubleStream(v1, v2).toArray();

        assertThat(doubles).containsExactly(v1, v2);
    }

    @Test
    void testToStream() {
        String[] input = "How are you".split(" ");
        Object[] actual = Creation.toStream(input).toArray();

        assertThat(actual).isEqualTo(input);
    }

    @Test
    void testToStreamEmpty() {
        Object[] actual = Creation.toStream().toArray();

        assertThat(actual).isEmpty();
    }
}