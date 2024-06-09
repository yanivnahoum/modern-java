package com.att.tlv.training.java.records;

public class RecordPatterns {

    record Point(int x, int y) {}

    // Since Java 17 we have pattern matching for instanceof
    void java17PrintSum(Object obj) {
        if (obj instanceof Point p) {
            int x = p.x();
            int y = p.y();
            System.out.println(x + y);
        }
    }

    // As of Java 21 we have Record Patterns
    void printSum(Object obj) {
        if (obj instanceof Point(int x, int y)) {
            System.out.println(x + y);
        }
    }

    // But where Record Patterns really shine is when we have nested records:
    enum Color {RED, GREEN, BLUE}
    record ColoredPoint(Point point, Color color) {}
    record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}

    // As of Java 21
    void printColorOfUpperLeftPoint(Object r) {
        // Record Patterns - top level (Rectangle)
        if (r instanceof Rectangle(ColoredPoint upperLeft, ColoredPoint lr)) {
            System.out.println(upperLeft.color());
        }

        // Record Patterns - nested (ColoredPoint)
        if (r instanceof Rectangle(ColoredPoint(Point point, Color color), ColoredPoint lr)) {
            System.out.println(color);
        }

        // Reducing clutter by using var
        if (r instanceof Rectangle(ColoredPoint(var point, Color color), var lr)) {
            System.out.println(color);
        }

        // Eliminating noise by using the unnamed pattern
        if (r instanceof Rectangle(ColoredPoint(_, Color color), _)) {
            System.out.println(color);
        }
    }
}
