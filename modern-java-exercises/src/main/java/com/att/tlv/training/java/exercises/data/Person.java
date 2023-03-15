package com.att.tlv.training.java.exercises.data;

import java.util.List;

public record Person(long id, String name, int age, List<Person> children) {

    public Person {
        children = List.copyOf(children);
    }

    public Person(long id, String name, int age) {
        this(id, name, age, List.of());
    }

    public Person(long id, String name, int age, Person... children) {
        this(id, name, age, List.of(children));
    }
}