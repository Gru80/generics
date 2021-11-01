package collections;

import generics.max.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    public static void main(String args[]) {

        // Since Java 9 - but immutable!
        List<Employee> employees = List.of(new Employee(1, "Bernd Gugusch"));
        try {
            employees.add(new Employee(2, "Anthon Bhernad"));
        } catch (UnsupportedOperationException nope) {
            System.out.println("Java says NO when trying to add item to immutable list");
        }


        List<Employee> employees1 = Arrays.asList(new Employee(1, "Bernd Gugusch"));
        try {
            employees1.add(new Employee(2, "Anthon Bhernad"));
        } catch (UnsupportedOperationException nope) {
            System.out.println("Java says NO when trying to add item to immutable list");
        }


        var employees2 = new ArrayList<>();
        employees2.add(new Employee(1, "Bernd Gugusch"));
        employees2.add(new Employee(2, "Anthon Bhernad"));

        System.out.println(employees2);


        List<String> lowerCase = new ArrayList<>();
        lowerCase.add("Check");
        lowerCase.add("Out This");
        lowerCase.add("Lower-Case");
        lowerCase.add("Function");

        lowerCase.replaceAll(String::toLowerCase);
        // Alternative:
        // lowerCase.replaceAll(s -> s.toLowerCase());

        System.out.println(lowerCase.toString());

    }
}
