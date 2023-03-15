package com.att.tlv.training.java.data;

import java.util.List;

public record Player(long id,
                     String firstName,
                     String lastName,
                     int age,
                     double salary,
                     String teamName,
                     List<String> nicknames) {

    public Player {
        nicknames = List.copyOf(nicknames);
    }

    public Player(long id, String firstName, String lastName, int age, double salary, String teamName) {
        this(id, firstName, lastName, age, salary, teamName, List.of());
    }

    public Player(long id, String firstName, String lastName, int age, double salary, String teamName, String... nicknames) {
        this(id, firstName, lastName, age, salary, teamName, List.of(nicknames));
    }

    @Override
    public String firstName() {
//        System.out.println("getting firstName for: " + firstName);
        return firstName;
    }

    @Override
    public int age() {
        //System.out.println("getting age for: " + firstName);
        return age;
    }

    @Override
    public double salary() {
        //System.out.println("getting salary for: " + firstName);
        //Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        return salary;
    }
}