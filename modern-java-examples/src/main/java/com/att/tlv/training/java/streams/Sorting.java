package com.att.tlv.training.java.streams;

import com.att.tlv.training.java.data.Player;
import com.att.tlv.training.java.data.Players;

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
        List<Employee> employees = List.of(alice, bob, jim);
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
                .sorted(comparing(Player::firstName))
                .collect(toList());

        System.out.println(sortedPlayers);
    }

    public void sortByFirstNameDescending() {
        List<Player> players = Players.getAll();
        Collections.shuffle(players);
        System.out.println(players);

        List<Player> sortedPlayers = players.stream()
                .sorted(comparing(Player::firstName).reversed())
                .collect(toList());

        System.out.println(sortedPlayers);
    }

    public void sortById() {
        List<Player> players = Players.getAll();
        Collections.shuffle(players);
        System.out.println(players);

        List<Player> sortedPlayers = players.stream()
                .sorted(comparingLong(Player::id))
                .collect(toList());

        System.out.println(sortedPlayers);
    }

    public void sortByTeamNameAndThenSalary() {
        List<Player> players = Players.getAll();
        Collections.shuffle(players);
        System.out.println(players);

        List<Player> sortedPlayers = players.stream()
                .sorted(comparing(Player::teamName).thenComparingDouble(Player::salary))
                .collect(toList());

        System.out.println(sortedPlayers);
    }

    public void sortByTeamNameAndThenSalaryDescending() {
        List<Player> players = Players.getAll();
        Collections.shuffle(players);
        System.out.println(players);

        List<Player> sortedPlayers = players.stream()
                .sorted(comparing(Player::teamName).thenComparing(comparingDouble(Player::salary).reversed()))
                .collect(toList());

        System.out.println(sortedPlayers);
    }
    
    public void sortByLengthOfLastName() {
        List<Player> players = Players.getAll();
        Collections.shuffle(players);
        System.out.println(players);

        Comparator<Player> byLengthOfLastName =
                (p1, p2) -> Integer.compare(p1.lastName().length(), p2.lastName().length());
        
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
                .sorted(comparing(Player::lastName, comparingInt(String::length)))
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
                .sorted(comparing(p -> p, comparing(Player::firstName)))
                .collect(toList());
        
        System.out.println(sortedPlayers);
    }
}

record Employee(long id, String name) implements Comparable<Employee> {
    @Override
    public int compareTo(Employee other) {
        return Long.compare(this.id, other.id);
    }
}