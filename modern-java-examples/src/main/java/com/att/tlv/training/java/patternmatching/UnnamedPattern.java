package com.att.tlv.training.java.patternmatching;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnnamedPattern {
    boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException _) {
            return false;
        }
    }

    void lambdas(String name, Map<Integer, List<String>> lengthToNames) {
        // A common scenario with maps is implementing a multimap, where you map a key to a list of values.
        int length = name.length();
        List<String> names = lengthToNames.get(length);
        if (names == null) {
            names = new ArrayList<String>();
            lengthToNames.put(length, names);
        }
        names.add(name);

        // Better expressed as:
        lengthToNames.computeIfAbsent(name.length(), key -> new ArrayList<>())
                .add(name);

        // Or even better as:
        lengthToNames.computeIfAbsent(name.length(), _ -> new ArrayList<>())
                .add(name);
    }

    void loops(List<String> names) {
        int i = 0;
        for (var _ : names) {
            System.out.println("name #" + i++);
        }

        // Or
        names.forEach(_ -> System.out.println("Got a name!"));
    }
}
