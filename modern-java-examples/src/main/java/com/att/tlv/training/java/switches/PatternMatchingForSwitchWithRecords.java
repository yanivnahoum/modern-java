package com.att.tlv.training.java.switches;

class PatternMatchingForSwitchWithRecords {
    record Point(int x, int y) {}
    enum Color {RED, GREEN, BLUE}
    record ColoredPoint(Point point, Color color) {}
    record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}

    // All together now - pattern matching for switch with records and the unnamed pattern
    void withSwitch(Rectangle rectangle) {
        switch (rectangle) {
            case Rectangle(ColoredPoint(Point(int x, int y), _), _)
                    when x == 0 && y == 0 -> System.out.println("Upper left point is in the origin");
            case Rectangle(_, ColoredPoint(Point(int x, int y), _)) when x == 0 && y == 0 ->
                    System.out.println("Lower right point is in the origin");
            case Rectangle(ColoredPoint(_, var upperLeftColor), ColoredPoint(_, var lowerRightColor))
                    when upperLeftColor == lowerRightColor -> System.out.println("Colors are the same!");
            default -> System.out.println("no");
        }
    }
}
