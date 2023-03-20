package com.att.tlv.training.java.streams;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {

    // What is a stream? A sequence of elements from a source that supports aggregate operations,
    // like filter, map, reduce, find, match, sorted, and so on.
    // So like an iterator, we get a sequence of elements. Unlike iterators, they are evaluated
    // lazily and support parallel execution.
    // Unlike collections, streams have no storage - they conveys elements from a source such as a
    // data structure, an array, a generator function, or an I/O channel, through a pipeline of
    // computational operations.
    // Streams are functional in nature. An operation on a stream produces a result,
    // but does not modify its source.
    // Streams are possibly unbounded. While collections have a finite size, streams need not.
    // Streams are consumable. The elements of a stream are only visited once during the life
    // of a stream - like an Iterator.
    // Stream operations support pipelining and internal iteration (more on this later on).

    public void collection() {
        var names = List.of("Alice", "Bob", "Charlie", "David", "Eve");
        Stream<String> stream = names.stream();
    }

    public void files(String filename) throws IOException {
        try (var reader = Files.newBufferedReader(Paths.get(filename))) {
            reader.lines()
                    .forEach(System.out::println);
        }

        // Or this:
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            lines.forEach(System.out::println);
        }
    }

    public void directoriesEntries(String root, FileVisitor<Path> visitor) throws IOException {
        try (Stream<Path> entries = Files.list(Paths.get(root))) {
            entries.forEach(System.out::println);
        }
    }

    public void directoriesTree(String root) throws IOException {
        int maxDepth = 3;
        try (Stream<Path> directories = Files.walk(Paths.get(root), maxDepth)) {
            directories.forEach(System.out::println);
        }
    }

    public void infiniteGenerate() {
        // An infinite stream of empty strings
        Stream<String> strings = Stream.generate(String::new);

        // An infinite stream of random numbers
        DoubleStream randomDoubles = DoubleStream.generate(() -> Math.random());

        // ... or better yet:
        randomDoubles = new Random().doubles();
    }

    public void infiniteIterate() {
        // seed, f(seed), f(f(seed))....
        IntStream numbers = IntStream.iterate(0, n -> n + 2);
    }

    public void limit() {
        LongStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(System.out::println);
    }

    public void skip() {
        LongStream.iterate(1, n -> n + 1)
                .skip(2)
                .limit(10)
                .forEach(System.out::println);

        // limit, skip vs skip, limit
        // foreach - Is the order guaranteed?
        // limit & skip - at what price?
    }

    public void ranges() {
        // 1 to 9
        IntStream.range(1, 10)
                .forEach(System.out::println);

        // 1 to 10
        IntStream.rangeClosed(1, 10)
                .forEach(System.out::println);
    }

    public void anything() {
        // You can call this:
        Stream<String> stream = Stream.of("Hello", "World");

        // Which is actually calling this:
        String[] array = { "Hello", "World" };
        stream = Arrays.stream(array);

    }

    public static void main(String[] args) {
        new Streams().skip();
    }
}
