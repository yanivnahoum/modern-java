package com.att.tlv.training.java.exercises.patternmatching;

public class InstanceOf {

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
         * @param obj
         * @return
         */
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) {
                return false;
            }
            Point other = (Point) obj;
            return x == other.x
                    && y == other.y;
        }
    }
}
