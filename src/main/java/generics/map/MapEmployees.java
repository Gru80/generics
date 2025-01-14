package generics.map;

import generics.max.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * Created by Ken Kousen on 11/9/16.
 */
public class MapEmployees {
    public static List<Employee> createEmployees() {
        return Arrays.asList(
                new Employee(1, "Peter Gibbons"),
                new Employee(2, "Samir Nagheenanajar"),
                new Employee(3, "Michael Bolton"),
                new Employee(4, "Milton Waddams"),
                new Employee(5, "Jim Wu"),
                new Employee(6, "Apu Nahasapeemapetilon")
        );
    }

    public static void main(String[] args) {
        List<Employee> employees = createEmployees();
        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(toList());

        List<Integer> ids = employees.stream()
                .map(Employee::getId)
                .collect(toList());

        int totalLength = employees.stream()
                .map(Employee::getName)
                .mapToInt(String::length)
                .sum();


        // Add employees to a map using id as key
        Map<Integer, Employee> employeeMap = employees.stream()
                .collect(toMap(Employee::getId, Function.identity()));
        // Function.identity() basically does:  for each employee return the employee
        // same thing (function wise) would be: e -> e

        System.out.println("\n*** Output the employeeMap ***");
        employeeMap.forEach((id, emp) -> System.out.println(id + ": " + emp));


        // Sort employees by id and print them
        System.out.println("\nSorted by key:");
        // entrySet() -> no duplicates
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });

        // Reverse sort employees by id and print them
        System.out.println("\nReverse sorted by key:");
        employeeMap.entrySet().stream()
                // using the override of compareByKey - now the Comparator is provided:
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });

        // Sort employees by name and print them
        System.out.println("\nSorted by name:");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(comparing(Employee::getName)))
                // lambda version would be:
                // .sorted(Map.Entry.comparingByValue(comparing(e -> e.getName())))
                //
                // following would cause compiler error, because Employee has no natural order implemented:
                // .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });

        // Sort employees by name and print them
        System.out.println("\nSorted by length of name:");
        employeeMap.entrySet().stream()
                // *-1 to get the name with the most characters descending
                .sorted(Map.Entry.comparingByValue(comparing(e -> e.getName().length()*-1)))
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });

        // Now that Employee implements Comparable ...
        System.out.println("\nSorted by name in natural order (name length):");
        employeeMap.entrySet().stream()
                // ...this can be done
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });
    }
}
