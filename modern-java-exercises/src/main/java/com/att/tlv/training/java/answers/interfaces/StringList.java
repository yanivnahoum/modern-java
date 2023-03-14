package com.att.tlv.training.java.answers.interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringList implements StringCollection {
    
    private final List<String> strings = new ArrayList<>();

    @Override
    public Iterator<String> iterator() {
        return strings.iterator();
    }

    @Override
    public StringList add(String s) {
        strings.add(s);
        return this;
    }

    @Override
    public boolean remove(String s) {
        return strings.remove(s);
    }
}