package com.att.tlv.training.java.streams;

import com.att.tlv.training.java.data.Player;
import com.att.tlv.training.java.data.Players;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class FlatMap {
    
    public static void main(String[] args) {
        new FlatMap().uniqueListOfPlayerNicknames();
    }
    
    public void uniqueListOfPlayerNicknames() {
        List<Player> players = Players.getAll();
        
        Set<String> nicknames = players.stream()
                .flatMap(p -> p.nicknames().stream())
            .collect(toSet());
        
        System.out.println(nicknames);
    }
    
    // There's also the apis to avoid boxing: flatMapToInt, flatMapToLong, flatMapToDouble!
}
