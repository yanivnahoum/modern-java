package com.att.tlv.training.java.exercises.sealed;

public class SealedClasses {}

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
 * Note: The classes below exist only to allow {@link SealedClassesTest} to compile.<br>
 * Remove/replace them when implementing your solution.
 */

interface Shape {
    double getArea();
}

class Circle {
    Circle(double value) {
    }
}

class Triangle {
    Triangle(double value1, double value2) {
    }
}

class Square {
    Square(double value) {
    }
}
