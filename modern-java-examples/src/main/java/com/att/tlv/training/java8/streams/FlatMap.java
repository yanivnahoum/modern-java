package com.att.tlv.training.java8.streams;

import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Set;

import com.att.tlv.training.java8.data.Player;
import com.att.tlv.training.java8.data.Players;

public class FlatMap {
    
    public static void main(String[] args) {
        new FlatMap().uniqueListOfPlayerNicknames();
    }
    
    public void uniqueListOfPlayerNicknames() {
        List<Player> players = Players.getAll();
        
        Set<String> nicknames = players.stream()
            .flatMap(p -> p.getNicknames().stream())
            .collect(toSet());
        
        System.out.println(nicknames);
    }
    
    // There's also the apis to avoid boxing: flatMapToInt, flatMapToLong, flatMapToDouble!
}
