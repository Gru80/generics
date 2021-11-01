package collections;

import java.util.Arrays;
import java.util.OptionalDouble;

public class StreamDemo {

    public static final String lorem = """
    Lorem ipsum dolor sit amet,
    consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt
    ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero
    eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren,
    no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum
    dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod
    tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.
    At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd
    gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
    """;

    public static void main(String args[]) {
        // get rid of linebreaks, dots, commas and split by blanks
        var lst = Arrays.asList(lorem.replaceAll("[\n,.]", " ").split(" "));

        // print words longer than 6
        lst.stream()
                .filter( s -> s.length() > 6)
                .forEach(System.out::println);

        // count unique occurrences of words longer than 6
        long n = lst.stream()
                .filter(s -> s.length() > 6)
                .distinct()
                .count();
        System.out.println(n);

        // average word length
        OptionalDouble avg = lst.stream()
                .mapToInt(String::length)
                .average();
        if (avg.isPresent()) System.out.println(avg.getAsDouble());
    }
}
