package com.att.tlv.training.java.answers.text;

/**
 * In the following exercises, all strings contain trailing newlines unless stated otherwise,
 * and margins/trailing spaces are expressed using dots.
 */
public class TextBlocksAnswer {

    /**
     * Return the following text:
     * <pre>
     * a
     * b
     * c
     * </pre>
     */
    static String textBlock() {
        return """
                a
                b
                c
                """;
    }

    /**
     * Return the following text:
     * <pre>
     * ....a
     * ..b
     * ....c
     * </pre>
     */
    static String textBlockWithMargin() {
        return """
                    a
                  b
                    c
                """;
    }

    /**
     * Return the following text:
     * <pre>
     * "a"
     * ""b""
     * """c"""
     * </pre>
     */
    static String textBlockWithQuotes() {
        return """
                "a"
                ""b""
                ""\"c""\"
                """;
    }

    /**
     * Return the following text:
     * <pre>
     * a
     * b
     * c (no trailing newline)
     * </pre>
     */
    static String textBlockNoTrailingNewLine() {
        return """
                a
                b
                c\
                """;
    }

    /**
     * Return the following text:
     * <pre>
     * abc
     * ab.
     * a..
     * </pre>
     */
    static String textBlockWithTrailingSpaces() {
        return """
                abc
                ab\s
                a \s
                """;
    }
}

