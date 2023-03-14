package com.att.tlv.training.java.streams;

import com.att.tlv.training.java.data.Player;
import com.att.tlv.training.java.data.Players;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

public class CollectorOptionals {

    public static void main(String[] args) {
        new CollectorOptionals().groupByTeamToPlayerWithShortestLastName();
    }
    
    public void groupByTeamToOldestPlayer() {
        List<Player> players = Players.getAll();
        System.out.println(players);

        // teamName -> oldest player in team (if any)
        Map<String, Optional<Player>> map = players.stream()
                .collect(groupingBy(Player::getTeamName, maxBy(comparingInt(Player::getAge))));

        System.out.println(map);
    }
    
    public void groupByTeamToPlayerWithShortestLastName() {
        List<Player> players = Players.getAll();
        System.out.println(players);
        
        // teamName -> player with shortest last name (if any)
        Map<String, Optional<Player>> map = players.stream()
                .collect(groupingBy(Player::getTeamName, minBy(comparing(Player::getLastName, comparingInt(String::length)))));
        
        System.out.println(map);
    }

}
