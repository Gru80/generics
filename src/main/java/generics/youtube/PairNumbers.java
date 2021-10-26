package generics.youtube;

import java.util.StringJoiner;

public class PairNumbers <T extends Number> {
    private final T first;
    private final T second;

    public PairNumbers(T first, T second) {
        this.first = first;
        this.second = second;

    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pair.class.getSimpleName() + "[", "]")
                .add("first='" + first + "'")
                .add("second='" + second + "'")
                .toString();
    }
}
