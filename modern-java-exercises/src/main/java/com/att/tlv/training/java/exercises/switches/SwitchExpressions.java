package com.att.tlv.training.java.exercises.switches;

import com.att.tlv.training.java.exercises.Exercises;

import java.util.logging.Logger;

public class SwitchExpressions {
    /**
     * Maps an instance of {@code Direction} to its corresponding azimuth (0, 90, 180, 270)
     *
     * @param direction
     * @return the azimuth corresponding to the specified direction
     */
    static int directionToAzimuth(Direction direction) {
        return Exercises.replaceThisWithSolution();
    }

    /**
     * Maps an integer to its English name:
     * <ul>
     * <li>10: "ten"</li>
     * <li>20: "twenty"</li>
     * <li>30: "thirty"</li>
     * <li>other: "unexpected", and log the following at info level (assuming value=50): "Unexpected value: 50"</li>
     * </ul>
     *
     * @param value  the value
     * @param logger the logger
     * @return the English name of the integer specified or "unexpected"
     */
    static String toName(int value, Logger logger) {
        return Exercises.replaceThisWithSolution();
    }
}

enum Direction {
    NORTH, EAST, SOUTH, WEST;
}

