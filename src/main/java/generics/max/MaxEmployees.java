package generics.max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

/**
 * Created by Ken Kousen on 11/9/16.
 */
public class MaxEmployees {
    public static List<Employee> createEmployees() {
        return Arrays.asList(
                new Employee(1, "Peter Gibbons"),
                new Employee(2, "Samir Nagheenanajar"),
                new Employee(3, "Michael Bolton"),
                new Employee(4, "Milton Waddams")
        );
    }

    public static void main(String[] args) {
        List<Employee> employees = createEmployees();

        //  getting maxId via explicit code of anonymous class
        Employee maxId1 = employees.stream()
                .max(new Comparator<Employee>() {
                    @Override
                    public int compare(Employee e1, Employee e2) {
                        return e1.getId() - e2.getId();
                    }
                }).orElse(Employee.DEFAULT_EMPLOYEE);

        // getting maxId via lambda
        Employee maxId = employees.stream()
                .max((Employee e1, Employee e2) -> e1.getId() - e2.getId()).orElse(Employee.DEFAULT_EMPLOYEE);

        // getting maxName with anonymous class
        Employee maxName = employees.stream()
                .max(new Comparator<Object>() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return o1.toString().compareTo(o2.toString());
                    }
                }).orElse(Employee.DEFAULT_EMPLOYEE);

        // getting maxName with labmda
        Employee maxName1 = employees.stream()
                .max((Object o1, Object o2) -> o1.toString().compareTo(o2.toString())).orElse(Employee.DEFAULT_EMPLOYEE);

        System.out.println("\nmaxId with anonymous class: " + maxId1);
        System.out.println("maxId with lambda:            " + maxId);
        System.out.println("maxName with anonymous class: " + maxName);
        System.out.println("maxName with lambda:          " + maxName1);

        // solution with comparingInt method
        maxId = employees.stream()
                .max(comparingInt(Employee::getId)).orElse(Employee.DEFAULT_EMPLOYEE);
        maxName = employees.stream()
                .max(comparing(Object::toString)).orElse(Employee.DEFAULT_EMPLOYEE);

        System.out.println("\nmaxId using comparingInt(): " + maxId);
        System.out.println("maxName using compare():    " + maxName);
    }
}
