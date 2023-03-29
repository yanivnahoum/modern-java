package com.att.tlv.training.java.answers.switches;

import java.util.logging.Logger;

public class SwitchExpressionsAnswer {
    /**
     * Maps an instance of {@code Direction} to its corresponding azimuth (0, 90, 180, 270)
     *
     * @param direction
     * @return the azimuth corresponding to the specified direction
     */
    static int directionToAzimuth(Direction direction) {
        return switch (direction) {
            case NORTH -> 0;
            case EAST -> 90;
            case SOUTH -> 180;
            case WEST -> 270;
        };
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
        return switch (value) {
            case 10 -> "ten";
            case 20 -> "twenty";
            case 30 -> "thirty";
            default -> {
                logger.info("Unexpected value: " + value);
                yield "unexpected";
            }
        };
    }
}

enum Direction {
    NORTH, EAST, SOUTH, WEST;
}


