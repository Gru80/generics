package generics.youtube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Based on the youtube video
 * https://www.youtube.com/watch?v=CN27X68YO4I
 *
 */

public class GenericDemo {

    public static void main(String args[]) {
        List<Integer> myIntegers = new ArrayList<>();
        myIntegers.add(42);

        Pair<String> myPair = new Pair<>("Ben", "Holly");
        PairXtended<Integer, String> myXtendedPair = new PairXtended<>(0, "Zero");

        System.out.println(myPair.toString());
        System.out.println(myXtendedPair.toString());

        // generics with methods - usage
        List<String> originalList = Arrays.asList("Hello", "world");
        System.out.println(reverse(originalList));
    }

    // generics with methods - implementation
    private static <T> List<T> reverse(List<T> originalList) {
        List<T> reversedList = new ArrayList<>(originalList);
        Collections.reverse(reversedList);
        return reversedList;
    }
}
