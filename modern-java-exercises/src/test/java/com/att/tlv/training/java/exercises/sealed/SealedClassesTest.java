package com.att.tlv.training.java.exercises.sealed;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SealedClassesTest {
    @ParameterizedTest
    @MethodSource
    void shapeAreaIsCalculatedCorrectly(Shape shape, double area) {
        assertThat(shape.getArea()).isEqualTo(area);
    }

    static Stream<Arguments> shapeAreaIsCalculatedCorrectly() {
        return Stream.of(
                arguments(new Circle(5), 78.53981633974483),
                arguments(new Square(4), 16D),
                arguments(new Triangle(3, 6), 9D)
        );
    }
}
