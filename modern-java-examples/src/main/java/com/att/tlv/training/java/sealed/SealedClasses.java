package com.att.tlv.training.java.sealed;

class NoSealedClasses {

    // The object-oriented data model of inheritance hierarchies of classes and interfaces has proven to be
    // highly effective in modeling the real-world data processed by modern applications.
    // This expressiveness is an important aspect of the Java language.
    // There are, however, cases where such expressiveness can usefully be tamed.
    // For example, Java supports enum classes to model the situation where a given class
    // has only a fixed number of instances.
    // In the following code, an enum class lists a fixed set of directions.
    // They are the only values of the class, therefore you can switch over them exhaustively —
    // without having to write a default clause:
    enum Direction {
        NORTH, EAST, SOUTH, WEST;
    }


    int directionToAzimuth(Direction direction) {
        return switch (direction) {
            case NORTH -> 0;
            case EAST -> 90;
            case SOUTH -> 180;
            case WEST -> 270;
        };
    }


// Using enum classes to model fixed sets of values is often helpful, but sometimes we want to model a fixed
// set of kinds of values. We can do this by using a class hierarchy not as a mechanism for code inheritance
// and reuse but, rather, as a way to list kinds of values.
// This hierarchy does not, however, reflect the important domain knowledge that there are only three kinds of
// shapes in our model. In these situations, restricting the set of subclasses or subinterfaces
// can streamline the modeling.

    abstract class Shape {}

    final class Circle extends Shape {}

    final class Triangle extends Shape {}

    final class Square extends Shape {}
}

// We have very limited options: either make a class final so it has 0 sub-classes, or make the base class or its
// c'tor package-private so it can have an unlimited number of sub-classes, but only in its package.
// The package-private approach is useful where the goal is code reuse. See AbstractStringBuilder
// However, the approach is useless when the goal is modeling alternatives, since user code cannot access
// the key abstraction — the superclass — in order to switch over it.
// Allowing users to access the superclass without also allowing them to extend it cannot be specified
// without resorting to brittle tricks involving non-public constructors — which do not work for interfaces.
// Accessibility & extensibility are coupled!


public class SealedClasses {
    // A sealed class or interface can be extended or implemented only by those classes and interfaces permitted to do so.
    // A class is sealed by applying the sealed modifier to its declaration.
    // Then, after any extends and implements clauses, the permits clause specifies the classes that are permitted
    // to extend the sealed class. For example, the following declaration of Shape specifies three permitted subclasses:
    abstract sealed class Shape permits Circle, Triangle, Square {}

    final class Circle extends Shape {}

    final class Triangle extends Shape {}

    final class Square extends Shape {}
}

class SealedClassWithoutPermitsClause {

    // When the permitted subclasses are small in size and number, it may be convenient to declare them in the
    // same source file as the sealed class. When they are declared in this way, the sealed class may omit the
    // permits clause and the Java compiler will infer the permitted subclasses from the declarations in the
    // source file. The subclasses may be auxiliary or nested classes.
    abstract sealed class Shape {
        final class Circle extends Shape {}

        final class Triangle extends Shape {}

        final class Square extends Shape {}

    }
}

class SealedClassHierarchies {
    // A sealed class imposes three constraints on its permitted subclasses:
    // 1. The sealed class or interface and its permitted subclasses must belong to the same module, and, if declared in an
    //    unnamed module, to the same package.
    // 2. Every permitted subclass must directly extend the sealed class.
    sealed interface Shape
            permits Circle, Triangle, Square {}

    // 3. Every permitted subclass must use a modifier to describe how it propagates the sealing initiated by its superclass:
    //   a. A permitted subclass may be declared final to prevent its part of the class hierarchy from being
    //      extended further. Record classes are implicitly declared final.
    final class Circle implements Shape {}

    //   b. A permitted subclass may be declared sealed to allow its part of the hierarchy to be extended further
    //      than envisaged by its sealed superclass, but in a restricted fashion.
    sealed interface Triangle extends Shape
            permits EquilateralTriangle, IsoscelesTriangle {}

    final class EquilateralTriangle implements Triangle {}

    final class IsoscelesTriangle implements Triangle {}


    //   c. A permitted subclass may be declared non-sealed so that its part of the hierarchy reverts to being open
    //      for extension by unknown subclasses. A sealed class cannot prevent its permitted subclasses from doing this.
    non-sealed class Square implements Shape {}
}
