package com.att.tlv.training.java.streams;

import com.att.tlv.training.java.data.Player;
import com.att.tlv.training.java.data.Players;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summingLong;
import static java.util.stream.Collectors.toList;

public class GroupingCollectors {

    public static void main(String[] args) {
        new GroupingCollectors().classicGroupBy();
    }

    public void classicGroupBy() {
        List<Player> players = Players.getAll();
        System.out.println(players);

        // teamName -> list of Players in team
        Map<String, List<Player>> map = players.stream()
                .collect(groupingBy(Player::teamName));

        System.out.println(map);

        // The toList() collector is the default collector used for the Map values
        map = players.stream()
                .collect(groupingBy(Player::teamName, toList()));
    }

    public void groupByLengthOfFirstName() {
        List<Player> players = Players.getAll();
        System.out.println(players);

        // length(firstName) -> list of Players
        Map<Integer, List<Player>> map = players.stream()
                .collect(groupingBy(p -> p.firstName().length()));

        System.out.println(map);
    }

    public void groupByTeamToFirstNames() {
        List<Player> players = Players.getAll();
        System.out.println(players);

        // teamName -> list of first names
        Map<String, List<String>> map = players.stream()
                .collect(groupingBy(Player::teamName, mapping(Player::firstName, toList())));

        System.out.println(map);
    }

    public void groupByTeamToDistinctAges() {
        List<Player> players = Players.getAll();
        System.out.println(players);

        // teamName -> list of distinct ages
        Map<String, List<Integer>> map = players.stream()
                .collect(groupingBy(Player::teamName, mapping(Player::age, toList())));

        System.out.println(map);

        // FIXME make distinct
    }

    public void groupByTeamAndThenByLengthOfFirstNameToPlayer() {
        List<Player> players = Players.getAll();
        System.out.println(players);

        // teamName -> map: length(firstName)-> list of Players
        Map<String, Map<Integer, List<Player>>> map = players.stream()
                .collect(groupingBy(Player::teamName, groupingBy(p -> p.firstName().length())));

        System.out.println(map);
    }

    public void groupByTeamAndThenByLengthOfFirstNameToLastName() {

        List<Player> players = Players.getAll();
        System.out.println(players);

        // teamName -> map: length(firstName)-> list of last names
        Map<String, Map<Integer, List<String>>> map = players.stream()
                .collect(groupingBy(Player::teamName,
                        groupingBy(p -> p.firstName().length(), mapping(Player::lastName, toList()))));

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
        return Players.WARRIORS.equals(player.teamName());
    }
    
    public void partitionByIsAWarriorToSumOfIds() {
        List<Player> players = Players.getAll();
        System.out.println(players);

        Map<Boolean, Long> map = players.stream()
                .collect(partitioningBy(GroupingCollectors::isAWarrior, summingLong(Player::id)));
        
        System.out.println(map);
    }
}
