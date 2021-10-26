package generics.youtube;

import java.util.Comparator;
import java.util.StringJoiner;

public class PairComparable<T extends Comparable<T>> {
        private final T first;
        private final T second;

        public PairComparable(T first, T second) {
            this.first = first;
            this.second = second;

        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }

        public T getLarger() {
            return first.compareTo(second) > 0 ? first : second;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", generics.youtube.Pair.class.getSimpleName() + "[", "]")
                    .add("first='" + first + "'")
                    .add("second='" + second + "'")
                    .toString();
        }
}
