package com.att.tlv.training.java.records;

import com.att.tlv.training.java.data.Player;
import com.att.tlv.training.java.data.Players;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Month;
import java.util.List;
import java.util.Objects;

import static java.util.Comparator.comparingDouble;

final class Point {
    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Point) obj;
        return this.x == that.x &&
                this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point[" +
                "x=" + x + ", " +
                "y=" + y + ']';
    }

    // A record includes:
    // 1. A canonical c'tor (whose signature is the same as the header)
    // 2. For each header component - a private final field and a public accessor method
    // 3. equals and hashCode methods
    // 4. A toString method
}

// The record class is imlicitly final, and cannot be abstract.
// It can't inherit from another class (similar to Enum).
// These restrictions emphasize that the API of a record class is defined solely by its state description,
// and cannot be enhanced later by another class.
record Range(long start, long end) {
    private static long DEFAULT_END = Long.MAX_VALUE;

    // Instance fields are not allowed!
//    private int size;

    // Explicit canonical c'tor. Params must match the record header!
    Range(long start, long end) {
        if (start > end) {
            throw new IllegalArgumentException("(%d,%d)".formatted(start, end));
        }
        this.start = start;
        this.end = end;
    }

    // Non-canonical c'tor. Must delegate to another c'tor
    Range(long start) {
        this(start, DEFAULT_END);
    }

    // Compact c'tor. Parameters are declared implicitly, and the private fields corresponding to record
    // cannot be assigned in the body but are automatically assigned to the corresponding formal parameter (this.x = x;)
    // at the end of the constructor.
    // The compact form helps developers focus on validating and normalizing parameters without the tedious work of
    // assigning parameters to fields.
//    Range {
//        // referring here to the implicit constructor parameters
//        if (start > end) {
//            throw new IllegalArgumentException("(%d,%d)".formatted(start, end));
//        }
//    }

    // We can add additional methods, both static and instance. No native methods though.
    static Range of(long start, long end) {
        return new Range(start, end);
    }

    long size() {
        return end - start;
    }

    // We can override accessors
    @Override
    public long start() {
        System.out.println("In start accessor method!");
        return start;
    }
}

// Records can be generic
record Box<T>(T value) {}

// Records can implement interfaces (like Enums)
record Id(long id) implements Comparable<Id> {
    @Override
    public int compareTo(Id other) {
        return Long.compare(id, other.id);
    }
}

// Annotations are propagated to fields/c'tor params/accessor methods
// according to the annotations' TARGET value (FIELD/METHOD/PARAMETER_TYPE)
record Person(
        long id,
        @JsonProperty("first-name") String firstName,
        @JsonProperty("last-name") String lastName
) {}

public class Records {

    // Nested classes are implicitly static. This avoids an immediately enclosing instance
    // which would silently add state to the record class.
    record NestedPoint(int x, int y) {}

    // Records are great for intermediate computations
    List<Player> findPlayersByMonthlyRevenue(Month month) {
        return Players.getAll()
                .stream()
                .map(player -> new PlayerRevenue(player, getMonthlyRevenue(month)))
                .sorted(comparingDouble(PlayerRevenue::revenue).reversed())
                .map(PlayerRevenue::player)
                .toList();
    }

    // This record can be made local to the method using it!
    record PlayerRevenue(Player player, double revenue) {}

    private double getMonthlyRevenue(Month month) {
        // Compute...
        return 0d;
    }

    public static void main(String[] args) {
        var point = new Point(1, 2);
        System.out.println(point);
    }
}