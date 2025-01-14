package generics.max;

public class Employee implements Comparable<Employee>{
    public static final Employee DEFAULT_EMPLOYEE = new Employee(0, "No Name");

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Employee emp) {
        return emp.name.length() - name.length();
    }

    @Override
    public String toString() {
        return "'" + name + "'";
    }
}
