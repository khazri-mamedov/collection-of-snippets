package org.scratch.basic.util;

/**
 * Tuple for returning 2 values from any method
 * @param <F> type of first value
 * @param <S> type of second value
 */
public class Tuple<F, S> {
    private F first;
    private S second;

    public Tuple(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }
}
