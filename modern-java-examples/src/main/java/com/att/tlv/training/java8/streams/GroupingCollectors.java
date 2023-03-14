package com.att.tlv.training.java8.streams;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summingLong;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

import com.att.tlv.training.java8.data.Player;
import com.att.tlv.training.java8.data.Players;

public class GroupingCollectors {

    public static void main(String[] args) {
        new GroupingCollectors().classicGroupBy();
    }

    public void classicGroupBy() {
        List<Player> players = Players.getAll();
        System.out.println(players);

        // teamName -> list of Players in team
        Map<String, List<Player>> map = players.stream()
                .collect(groupingBy(Player::getTeamName));

        System.out.println(map);

        // The toList() collector is the default collector used for the Map values
        map = players.stream()
                .collect(groupingBy(Player::getTeamName, toList()));
    }

    public void groupByLengthOfFirstName() {
        List<Player> players = Players.getAll();
        System.out.println(players);

        // length(firstName) -> list of Players
        Map<Integer, List<Player>> map = players.stream()
                .collect(groupingBy(p -> p.getFirstName().length()));

        System.out.println(map);
    }

    public void groupByTeamToFirstNames() {
        List<Player> players = Players.getAll();
        System.out.println(players);

        // teamName -> list of first names
        Map<String, List<String>> map = players.stream()
                .collect(groupingBy(Player::getTeamName, mapping(Player::getFirstName, toList())));

        System.out.println(map);
    }

    public void groupByTeamToDistinctAges() {
        List<Player> players = Players.getAll();
        System.out.println(players);

        // teamName -> list of distinct ages
        Map<String, List<Integer>> map = players.stream()
                .collect(groupingBy(Player::getTeamName, mapping(Player::getAge, toList())));

        System.out.println(map);

        // FIXME make distinct
    }

    public void groupByTeamAndThenByLengthOfFirstNameToPlayer() {
        List<Player> players = Players.getAll();
        System.out.println(players);

        // teamName -> map: length(firstName)-> list of Players
        Map<String, Map<Integer, List<Player>>> map = players.stream()
                .collect(groupingBy(Player::getTeamName, groupingBy(p -> p.getFirstName().length())));

        System.out.println(map);
    }

    public void groupByTeamAndThenByLengthOfFirstNameToLastName() {

        List<Player> players = Players.getAll();
        System.out.println(players);

        // teamName -> map: length(firstName)-> list of last names
        Map<String, Map<Integer, List<String>>> map = players.stream()
                .collect(groupingBy(Player::getTeamName, 
                        groupingBy(p -> p.getFirstName().length(), mapping(Player::getLastName, toList()))));

        System.out.println(map);
    }
    
    public void partitionByIsAWarrior() {
        List<Player> players = Players.getAll();
        System.out.println(players);     
        
        Map<Boolean, List<Player>> map = players.stream()
            .collect(partitioningBy(GroupingCollectors::isAWarrior));
        
        System.out.println(map);
    }
    
    private static boolean isAWarrior(Player player) {
        return Players.WARRIORS.equals(player.getTeamName());
    }
    
    public void partitionByIsAWarriorToSumOfIds() {
        List<Player> players = Players.getAll();
        System.out.println(players);     
        
        Map<Boolean, Long> map = players.stream()
                .collect(partitioningBy(GroupingCollectors::isAWarrior, summingLong(Player::getId)));
        
        System.out.println(map);
    }
}
