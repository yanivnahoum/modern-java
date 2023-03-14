package com.att.tlv.training.java8.exercises;

public class ExerciseNotCompletedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExerciseNotCompletedException() {
        super("Please remove this line of code and implement the exercise");
    }

}
