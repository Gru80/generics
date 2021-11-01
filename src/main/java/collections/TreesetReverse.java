package collections;

import java.util.*;

public class TreesetReverse {

    public static void main(String args[]) {
        TreeSet<Integer> s = new TreeSet<>();
        for ( int i=1; i<10; i++)
            s.add(i);

        s.removeIf( i -> (i%2) != 0);    // remove odd elements
        s.forEach(System.out::println);

        // reverse iteration
        System.out.println("\nReverse order:");
        for (Iterator<Integer> iit = s.descendingIterator(); iit.hasNext();) {
            int i = iit.next();
            System.out.println(i);
        }
    }
}
