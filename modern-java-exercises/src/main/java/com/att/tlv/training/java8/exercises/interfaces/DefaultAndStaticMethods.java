package com.att.tlv.training.java8.exercises.interfaces;

import java.util.function.Predicate;

import com.att.tlv.training.java8.exercises.Exercises;

/**
 * TODO implement methods {@code removeIf}, {@code joinAll}, and {@code merge}
 */
interface StringCollection extends Iterable<String> {

    /**
     * Adds an element to this collection.
     * 
     * @param s element to be added to this collection.
     * @return
     */
    StringCollection add(String s);

    /**
     * Removes a single instance of the specified element from this
     * collection, if it is present (optional operation). More formally,
     * removes an element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>, if
     * this collection contains one or more such elements. Returns
     * <tt>true</tt> if this collection contained the specified element (or
     * equivalently, if this collection changed as a result of the call).
     *
     * @param s element to be removed from this collection, if present
     * @return <tt>true</tt> if an element was removed as a result of this call
     */
    boolean remove(String s);

    /**
     * Removes all of the elements of this collection that satisfy the given
     * predicate.
     * 
     * @param filter a predicate which returns {@code true} for elements to be removed.
     */
    default void removeIf(Predicate<? super String> filter) {
        Exercises.replaceThisWithSolution();
    }

    /**
     * Joins all this collection's elements, returning a single concatenated {@code String}.
     */
    default String joinAll() {
        return Exercises.replaceThisWithSolution();
    }

    /**
     * Merges the two specified collections by appending c2 to c1.
     * 
     * @param c1
     * @param c2
     */
    static void merge(StringCollection c1, StringCollection c2) {
        Exercises.replaceThisWithSolution();
    }
}

public class DefaultAndStaticMethods {
}