package com.att.tlv.training.java.interfaces;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.ListIterator;

// Consider moving your utility methods to the natural interface.
// So instead of having a Collection interface and a CollectionUtils class with static methods
// place your utility methods in the Collection interface.
interface CoolList<T> extends List<T> {

    static <T> void copy(CoolList<? extends T> source, CoolList<? super T> destination) {
        int sourceSize = source.size();
        if (sourceSize > destination.size()) {
            throw new IndexOutOfBoundsException("Source does not fit in destination");
        }

        ListIterator<? super T> destinationItr = destination.listIterator();
        ListIterator<? extends T> sourceItr = source.listIterator();
        for (int i = 0; i < sourceSize; i++) {
            destinationItr.next();
            destinationItr.set(sourceItr.next());
        }
    }

    static <T> ImmutableList<T> asImmutable(CoolList<T> list) {
        return ImmutableList.copyOf(list);
    }
}

public class StaticMethods {
    
    public void foo(CoolList<String> coolStrings) {
        // Static methods belong to the class, or in this case - the interface,
        // and are accessible exclusively via the interface.
        ImmutableList<String> strings = CoolList.asImmutable(coolStrings);
        strings.forEach(System.out::println);
    }
}