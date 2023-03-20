package com.att.tlv.training.java.streams;

import com.att.tlv.training.java.data.Player;
import com.att.tlv.training.java.data.Players;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

public class BasicCollectors {
    
    public static void main(String[] args) {
        new BasicCollectors().list();
    }

    public void list() {
        var names = List.of("Alice", "Bob", "Charlie", "David", "Allen");
        System.out.println(names);

        // Find the names that have exactly five letters
        List<String> filteredNames = names.stream()
                .filter(BasicCollectors::hasFiveLetters)
                .collect(toList());

        System.out.println(filteredNames.getClass().getSimpleName() + ": " + filteredNames);

        // Java 16 immutable list collector:
        filteredNames = names.stream()
                .filter(BasicCollectors::hasFiveLetters)
                .toList();

        System.out.println(filteredNames.getClass().getSimpleName() + ": " + filteredNames);

        // How about if we need a special kind of list?
        filteredNames = names.stream()
                .filter(BasicCollectors::hasFiveLetters)
                .collect(toCollection(LinkedList::new));

        System.out.println(filteredNames.getClass().getSimpleName() + ": " + filteredNames);

        // Don't do this!
        List<String> list = new ArrayList<>();
        filteredNames.stream()
            .filter(BasicCollectors::hasFiveLetters)
            .forEach(list::add);
    }
    
    private static boolean hasFiveLetters(String s) {
        return s.length() == 5;
    }
    
    public void set() {
        var names = List.of("Alice", "Bob", "Charlie", "David", "Allen");
        System.out.println(names);
        
        // Find all the distinct name lengths in the list
        Set<Integer> lengths = names.stream()
                .map(String::length)
                .collect(toSet());
        
        System.out.println(lengths.getClass().getSimpleName() + ": " + lengths);
        
        // How about if we need a special kind of set?
        lengths = names.stream()
                .map(String::length)
                .collect(toCollection(TreeSet::new));
        
        System.out.println(lengths.getClass().getSimpleName() + ": " + lengths);
    }
    
    public void map() {
        List<Player> players = Players.getAll();
        System.out.println(players);
        
        // id -> player
        Map<Long, Player> map = players.stream()
                .collect(toMap(Player::id, Function.identity()));
        
        System.out.println(map.getClass().getSimpleName() + ": " + map);
        
        // How about this: length(firstName) -> lastName     
//        Map<Integer, String> nameLengths = players.stream()
//                .collect(toMap(p -> p.firstName().length(), Player::lastName));
//        
//        System.out.println(nameLengths);
        
        // Boom!
        // We can fix this by specifying a mergeFunction - BinaryOperator<U> where U is the type of values in the map
    }
}
