package com.att.tlv.training.java.answers.sealed;

public class SealedClassesAnswer {}

/**
 * Define a sealed interface called Shape that has a method called getArea() that returns a double.<br>
 * Create three concrete records that implement Shape: Circle, Square, and Triangle.<br>
 * In each of the three subclasses, implement the getArea() method to calculate and return the area of that shape.<br>
 * Use the following formulas:
 * <ul>
 * <li>Circle: area = pi * radius^2</li>
 * <li>Square: area = side length^2</li>
 * <li>Triangle: area = (base * height) / 2</li>
 * </ul>
 */
sealed interface Shape {
    double getArea();
}

record Circle(double radius) implements Shape {
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

record Square(double sideLength) implements Shape {
    @Override
    public double getArea() {
        return sideLength * sideLength;
    }
}

record Triangle(double base, double height) implements Shape {
    @Override
    public double getArea() {
        return (base * height) / 2;
    }
}