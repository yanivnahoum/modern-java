package com.att.tlv.training.java.exercises.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultAndStaticMethodsTest {

    private final String ALICE = "Alice";
    private final String BOB = "Bob";
    private final String DYLAN = "Dylan";
    private StringList names;

    @BeforeEach
    void setup() {
        names = new StringList()
                .add(ALICE)
                .add(BOB)
                .add(DYLAN);
    }

    @Test
    void testRemoveIf() {
        names.removeIf(s -> s.length() == 5);
        assertThat(names).containsExactly(BOB);
    }

    @Test
    void testJoinAll() {
        String joined = names.joinAll();

        StringBuilder expected = new StringBuilder();
        for (String name : names) {
            expected.append(name);
        }

        assertThat(joined).isEqualTo(expected.toString());
    }

    @Test
    void testMerge() {
        String jack = "Jack";
        String jill = "Jill";
        StringList moreNames = new StringList()
                .add(jack)
                .add(jill);

        StringCollection.merge(names, moreNames);

        assertThat(names).containsExactly(ALICE, BOB, DYLAN, jack, jill);
    }   
}
