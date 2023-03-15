package com.att.tlv.training.java.exercises.data;

import java.util.List;

import static java.util.Collections.emptyList;

public record Person(long id, String name, int age, List<Person> children) {
    public Person(long id, String name, int age) {
        this(id, name, age, emptyList());
    }
}