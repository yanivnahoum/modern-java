package com.att.tlv.training.java.data;

import java.util.Arrays;
import java.util.List;

public class Players {
    
    public static final String BULLS = "Bulls";
    public static final String WARRIORS = "Warriors";
    
    public static List<Player> getAll() {
        
        return Arrays.asList(new Player(1001, "Michael", "Jordan", 51, 100_000, BULLS, "MJ", "His Airness", "Air Jordan"),
                             new Player(1002, "Toni", "Kukoc", 52, 75_000, BULLS, "Croatian Sensation", "The Waiter", "Euro-Magic"),
                             new Player(1003, "Scottie", "Pippen", 49, 81_000, BULLS, "No Tippin' Pippen", "Pip", "Pipsi Cola"),
                             new Player(1004, "Steve", "Kerr", 50, 50_000, BULLS),
                             new Player(1005, "Stephen", "Curry", 25, 90_000, WARRIORS, "Basketball Magician", "Steph", "Chef Curry", "The Golden Boy", "The Baby-Faced Assassin", "Splash Brothers"),
                             new Player(1006, "Klay", "Thompson", 29, 80_000, WARRIORS, "Splash Brothers"),
                             new Player(1007, "Andre", "Iguodala", 29, 70_000, WARRIORS));
    }
}