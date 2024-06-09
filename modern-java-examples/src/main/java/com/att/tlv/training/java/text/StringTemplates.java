package com.att.tlv.training.java.text;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.SneakyThrows;

import java.util.List;

import static java.lang.StringTemplate.RAW;
import static java.util.FormatProcessor.FMT;

public class StringTemplates {
    static void concatenateWithValues(List<String> names) {
        int x = 2, y = 3;
        // Confusing
        //          2     +     3     =         5
        String str = x + " + " + y + " = " + (x + y);

        // Verbose!
        str = new StringBuilder()
                .append(x)
                .append(" + ")
                .append(y)
                .append(" = ")
                .append(x + y)
                .toString();

        // With format - placeholders and values are separated. Error-prone and hard to read.
        // Static method:
        str = String.format("%d + %d = %d", x, y, x + y);

        // Or instance method:
        str = "%d + %d = %d".formatted(x, y, x + y);

        // As of Java 21 we have String Templates (preview feature)!
        str = STR."\{x} + \{y} = \{x + y}";

        // Expressions may call methods returning objects
        str = STR."\{x} + \{y} = \{Math.addExact(x, y)}";

        // The embedded expression can span multiple lines:
        str = STR."The sum of the name lengths is \{
                names.stream()
                        .mapToInt(String::length)
                        .sum()
                } exactly";
        System.out.println(str);

        // Text blocks work as expected:
        String name = "John Doe";
        String phone = "555-123-4567";
        String address = "1 Maple Drive, Anytown";
        String json = STR."""
            {
                "name": "\{name}",
                "phone": "\{phone}",
                "address": "\{address}"
            }
            """;

        // String Templates can be assigned to a variable using the RAW StringTemplate Processor
        StringTemplate st = RAW."\{x} + \{y} = \{x + y}";
        // This uses the interpolate method to replace the placeholders with the values, just like the STR processor
        str = st.interpolate();
        // You can specify any processor available
        str = st.process(STR);
        // You can also call process on the Processor, passing in the StringTemplate
        str = STR.process(st);

        // Compiler error: illegal escape character
        // str = "This is x: \{x}";
    }

    record KV(String key, int value) {}

    private static final KV[] items = new KV[]{new KV("one", 1), new KV("two", 2), new KV("three", 3)};

    static void freeFormat() {
        var table = STR."""
                Key      Value
                \{items[0].key()} \{items[0].value()}
                \{items[1].key()} \{items[1].value()}
                \{items[2].key()} \{items[2].value()}
                """;
        System.out.println(table);
    }

    static void tableFormat() {
        var table = FMT."""
                Key      Value
                %-8s\{items[0].key()} \{items[0].value()}
                %-8s\{items[1].key()} \{items[1].value()}
                %-8s\{items[2].key()} \{items[2].value()}
                """;
        System.out.println(table);
    }

    void customStringTemplateProcessor() throws JsonProcessingException {
        String name = "John Doe";
        String phone = "555-123-4567";
        String address = "1 Maple Drive, Anytown";
        String json = STR."""
            {
                "name": "\{name}",
                "phone": "\{phone}",
                "address": "\{address}"
            }
            """;

        // To obtain a JsonNode, we need to create the json, and then parse it using a JsonMapper
        JsonNode node = jsonMapper.readTree(json);

        // We can encapsulate this logic in a custom Processor:
        JsonNode jsonNode = JSON."""
            {
                "name": "\{name}",
                "phone": "\{phone}",
                "address": "\{address}"
            }
            """;
        System.out.println(jsonNode);
    }

    private static final JsonMapper jsonMapper = JsonMapper.builder().build();
    StringTemplate.Processor<JsonNode, RuntimeException> JSON = StringTemplate.Processor.of(this::toJsonNode);

    @SneakyThrows(JsonProcessingException.class)
    JsonNode toJsonNode(StringTemplate stringTemplate) {
        return jsonMapper.readTree(stringTemplate.interpolate());
    }

    public static void main(String[] args) {
        concatenateWithValues(List.of("Alice", "Bob", "Charlie"));
    }
}
