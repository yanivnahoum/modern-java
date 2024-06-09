package com.att.tlv.training.java.patternmatching;

public class InstanceOf {

    // Here's a typical java idiom:
    void printInUpperCaseBefore(Object obj) {
        if (obj instanceof String) {
            // It's obvious that obj is a string here, but we have to perform an explicit cast nonetheless
            String s = (String) obj;
            System.out.println(s.toUpperCase());
        }
    }

    // The instanceof operator is extended to take a type pattern instead of just a type:
    void printInUpperCaseAfter(Object obj) {
        if (obj instanceof String str) {
            System.out.println(str.toUpperCase());
        }
    }

    // The scope of the pattern variable grows as needed
    void printInUpperCaseIfNotEmpty(Object obj) {
        // This works with && but not with || of course
        if (obj instanceof String str && !str.isEmpty()) {
            System.out.println(str.toUpperCase());
        }
    }

    // The flow scoping analysis for pattern variables is sensitive to the notion of whether a statement
    // can complete normally.
    public void onlyForStrings(Object o) {
        if (!(o instanceof String s)) {
            throw new IllegalArgumentException();
        }
        // s is in scope
        System.out.println(s.trim());
    }
}
