package com.att.tlv.training.java8.exercises.interfaces;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class DefaultAndStaticMethodsTest {

    private final String ALICE = "Alice";
    private final String BOB = "Bob";
    private final String DYLAN = "Dylan";
    private StringList names;
    
    @Before
    public void setup() {
        names = new StringList()
                .add(ALICE)
                .add(BOB)
                .add(DYLAN);
    }
    
    @Test
    public void testRemoveIf() {
        names.removeIf(s -> s.length() == 5);
        assertThat(names).containsExactly(BOB);
    }
    
    @Test
    public void testJoinAll() {
        String joined = names.joinAll();

        StringBuilder expected = new StringBuilder();
        for (String name : names) {
            expected.append(name);
        }
        
        assertThat(joined).isEqualTo(expected.toString());
    }
    
    @Test
    public void testMerge() {
        String jack = "Jack";
        String jill = "Jill";
        StringList moreNames = new StringList()
                .add(jack)
                .add(jill);
        
        StringCollection.merge(names, moreNames);
        
        assertThat(names).containsExactly(ALICE, BOB, DYLAN, jack, jill);
    }   
}
