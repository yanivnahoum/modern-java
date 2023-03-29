package com.att.tlv.training.java.exercises.text;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TextBlocksTest {

    @Test
    void textBlock() {
        String actual = TextBlocks.textBlock();
        assertThat(actual).isEqualTo("a\nb\nc\n");
    }

    @Test
    void textBlockWithMargin() {
        String actual = TextBlocks.textBlockWithMargin();
        assertThat(actual).isEqualTo("    a\n  b\n    c\n");
    }

    @Test
    void textBlockWithQuotes() {
        String actual = TextBlocks.textBlockWithQuotes();
        assertThat(actual).isEqualTo("'a'\n''b''\n'''c'''\n".replace("'", "\""));
    }

    @Test
    void textBlockNoTrailingNewLine() {
        String actual = TextBlocks.textBlockNoTrailingNewLine();
        assertThat(actual).isEqualTo("a\nb\nc");
    }

    @Test
    void textBlockWithTrailingSpaces() {
        String actual = TextBlocks.textBlockWithTrailingSpaces();
        assertThat(actual).isEqualTo("abc\nab \na  \n");
    }
}