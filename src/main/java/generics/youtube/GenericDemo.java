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

        // bounded types
        PairNumbers<Integer> myIntPair = new PairNumbers<>(10, 100);
        PairNumbers<Double> myDoublePair = new PairNumbers<>(5.5, 15.5);
        // this would cause a compiler error, because String does not extend Number:
        //    PairNumbers<String> myStringPair = new PairNumbers<String>("0", "10");

        // generics with methods - usage
        List<String> originalList = Arrays.asList("Hello", "world");
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(reverse(originalList));
        System.out.println(reverse(intList));
    }

    // generics with methods - implementation
    // the Type (T) stands just before the return type (List<T>)
    private static <T> List<T> reverse(List<T> originalList) {
        List<T> reversedList = new ArrayList<>(originalList);
        Collections.reverse(reversedList);
        return reversedList;
    }
}
