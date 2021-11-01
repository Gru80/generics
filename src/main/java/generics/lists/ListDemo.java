package generics.lists;

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
            employees.add(new Employee(2, "Anthon Bhernad"));
        } catch (UnsupportedOperationException nope) {
            System.out.println("Java says NO when trying to add item to immutable list");
        }

        var empolyees2 = new ArrayList<>();
        empolyees2.add(new Employee(1, "Bernd Gugusch"));
        empolyees2.add(new Employee(2, "Anthon Bhernad"));

        System.out.println(empolyees2);
    }
}
