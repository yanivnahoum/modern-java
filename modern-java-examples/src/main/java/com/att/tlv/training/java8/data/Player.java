package com.att.tlv.training.java8.data;

import java.util.List;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

public class Player {
    
    private final long id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final double salary;
    private final String teamName;
    private final List<String> nicknames;

    public Player(long id, String firstName, String lastName, int age, double salary, String teamName, String... nicknames) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.teamName = teamName;
        this.nicknames = ImmutableList.copyOf(nicknames);
    }
    
    public long getId() {
        return id;
    }    

    public String getFirstName() {
//        System.out.println("getting firstName for: " + firstName);
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        //System.out.println("getting age for: " + firstName);
        return age;
    }

    public double getSalary() {
        //System.out.println("getting salary for: " + firstName);
        //Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        return salary;
    }

    public String getTeamName() {
        return teamName;
    }
    
    public List<String> getNicknames() {
        return nicknames;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("age", age)
                .add("salary", salary)
                .add("teamName", teamName)
                .add("nicknames", nicknames)
                .toString();
    }
}