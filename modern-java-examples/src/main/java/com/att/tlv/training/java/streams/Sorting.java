package com.att.tlv.training.java.streams;

import com.att.tlv.training.java.data.Player;
import com.att.tlv.training.java.data.Players;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingDouble;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.toList;

public class Sorting {

    public static void main(String[] args) {
        new Sorting().sortInNaturalOrder();
    }

    public void sortInNaturalOrder() {
        Employee alice = new Employee(1001, "Alice");
        Employee bob = new Employee(1002, "Bob");
        Employee jim = new Employee(1000, "Jim");
        List<Employee> employees = ImmutableList.of(alice, bob, jim);
        System.out.println(employees);

        // Employee implements Comparable<Employee>
        List<Employee> sortedEmployees = employees.stream()
                .sorted()
                .collect(toList());

        System.out.println(sortedEmployees);
    }

    public void trySortInNaturalOrder() {
        List<Player> players = Players.getAll();
        System.out.println(players);

        // Player doesn't implement Comparable
        List<Player> sortedPlayers = players.stream()
                .sorted()
                // Boom!
                .collect(toList());

        System.out.println(sortedPlayers);
    }

    public void sortByFirstName() {
        List<Player> players = Players.getAll();
        Collections.shuffle(players);
        System.out.println(players);

        List<Player> sortedPlayers = players.stream()
                .sorted(comparing(Player::getFirstName))
                .collect(toList());

        System.out.println(sortedPlayers);
    }

    public void sortByFirstNameDescending() {
        List<Player> players = Players.getAll();
        Collections.shuffle(players);
        System.out.println(players);

        List<Player> sortedPlayers = players.stream()
                .sorted(comparing(Player::getFirstName).reversed())
                .collect(toList());

        System.out.println(sortedPlayers);
    }

    public void sortById() {
        List<Player> players = Players.getAll();
        Collections.shuffle(players);
        System.out.println(players);

        List<Player> sortedPlayers = players.stream()
                .sorted(comparingLong(Player::getId))
                .collect(toList());

        System.out.println(sortedPlayers);
    }

    public void sortByTeamNameAndThenSalary() {
        List<Player> players = Players.getAll();
        Collections.shuffle(players);
        System.out.println(players);

        List<Player> sortedPlayers = players.stream()
                .sorted(comparing(Player::getTeamName).thenComparingDouble(Player::getSalary))
                .collect(toList());

        System.out.println(sortedPlayers);
    }

    public void sortByTeamNameAndThenSalaryDescending() {
        List<Player> players = Players.getAll();
        Collections.shuffle(players);
        System.out.println(players);

        List<Player> sortedPlayers = players.stream()
                .sorted(comparing(Player::getTeamName).thenComparing(comparingDouble(Player::getSalary).reversed()))
                .collect(toList());

        System.out.println(sortedPlayers);
    }
    
    public void sortByLengthOfLastName() {
        List<Player> players = Players.getAll();
        Collections.shuffle(players);
        System.out.println(players);
        
        Comparator<Player> byLengthOfLastName = 
                (p1, p2) -> Integer.compare(p1.getLastName().length(), p2.getLastName().length());
        
        List<Player> sortedPlayers = players.stream()
                .sorted(byLengthOfLastName)
                .collect(toList());
        
        System.out.println(sortedPlayers);
        
        // And now descending order:
        sortedPlayers = players.stream()
                .sorted(byLengthOfLastName.reversed())
                .collect(toList());
        System.out.println(sortedPlayers);
    }
    
    public void sortByLengthOfLastName2() {
        List<Player> players = Players.getAll();
        Collections.shuffle(players);
        System.out.println(players);
        
        List<Player> sortedPlayers = players.stream()
                .sorted(comparing(Player::getLastName, comparingInt(String::length)))
                .collect(toList());
        
        System.out.println(sortedPlayers);
    }
    
    public void sortByFirstNameAgain() {
        List<Player> players = Players.getAll();
        Collections.shuffle(players);
        System.out.println(players);
        
        // The purpose of this example is to highlight the difference between the two overloads of Comparator.comparing().
        // The overload that takes one argument requires a keyExtractor that returns a Comparable<T>, 
        // while the overload that takes two argument does not need a comparable key since a comparator for the key
        // is provided as the second argument.
        List<Player> sortedPlayers = players.stream()
                .sorted(comparing(p -> p, comparing(Player::getFirstName)))
                .collect(toList());
        
        System.out.println(sortedPlayers);
    }
}

class Employee implements Comparable<Employee> {

    private final long id;
    private final String name;

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Employee other) {
        return Long.compare(this.id, other.id);
    }
    
    

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }
}