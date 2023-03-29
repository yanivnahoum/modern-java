package com.att.tlv.training.java.answers.patternmatching;

public class InstanceOfAnswer {

    static class Point {
        private final int x;
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Rewrite this method. Use pattern matching for instance of, and get rid of the explicit cast to Point
         *
         * @param o
         * @return
         */
        public boolean equals(Object obj) {
            return obj instanceof Point other
                    && x == other.x
                    && y == other.y;
        }
    }
}
