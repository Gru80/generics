package generics.youtube;

import java.util.StringJoiner;

public class PairXtended<T, S> {
    private final T first;
    private final S second;

    public PairXtended(T first, S second) {
        this.first = first;
        this.second = second;

    }

    public T getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PairXtended.class.getSimpleName() + "[", "]")
                .add("first='" + first + "'")
                .add("second='" + second + "'")
                .toString();
    }
}
