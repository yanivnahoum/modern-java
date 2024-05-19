package com.att.tlv.training.java.exercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Run this test class and make sure you see a message in the console. <br/>
 * Intellij: Ctrl+Shift+F10 (Win) / Cmd+Shift+R (Mac) <br/>
 */
class HelloJavaTest {
    @Test
    void makeSureProjectIsSetUpCorrectly() {
        String javaSpecificationVersion = System.getProperty("java.specification.version");
        assertThat(javaSpecificationVersion).isEqualTo("21");
    }
}