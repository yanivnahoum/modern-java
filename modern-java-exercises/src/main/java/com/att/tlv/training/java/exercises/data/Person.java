package com.att.tlv.training.java.exercises.data;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;

public class Person {

    private final long id;
    private final String name;
    private final int age;
    private final List<Person> children;

    public Person(long id, String name, int age, Person... children) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.age = age;
        this.children = ImmutableList.copyOf(children);
    }
    
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Person> getChildren() {
        return children;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("age", age)
                .add("children", children)
                .toString();
    }
}