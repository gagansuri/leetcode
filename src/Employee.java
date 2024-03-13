import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    private String gender;

    private int salary;
    public String getGender() {
        return gender;
    }
    public int getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        List<Employee> employees = getEmployees();

        //employees.stream().filter(e->e.getGender().equals("male")).map()
        countMaleFemale(employees);


        separateEmployees(employees);



        filterAndCount(employees);


        List<Employee> maleEmployees =  employees.stream().filter(
            e->e.getGender().equalsIgnoreCase("male"))
            .collect(Collectors.toList());








    }

    private static void filterAndCount(List<Employee> employees) {
        Map<String, Long> mp = new HashMap<>();
        mp = employees.
                stream()
                .filter(e->{
                    System.out.println(e.gender);
                    return true;})
                    .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        mp.entrySet().forEach(e-> System.out.println(e));
        //employees.stream().filter(s->s.gender.equals("male")).collect();
    }

    private static void countMaleFemale(List<Employee> employees) {
        Map<String, Long> result = employees.stream().collect(
                Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        Map<String,Long> result1 = employees.stream()
                .collect(Collectors.groupingBy(p->p.getGender(),Collectors.counting()));
        System.out.println(result);
    }

    private static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.gender = "male";

        Employee employee2 = new Employee();
        employee2.gender = "male";

        Employee employee3 = new Employee();
        employee3.gender = "male";

        Employee employee4 = new Employee();
        employee4.gender = "female";

        Employee employee5 = new Employee();
        employee5.gender = "female";
        employees.addAll(Arrays.asList(employee1,employee2,employee3, employee4, employee5));
        return employees;
    }

    static void separateEmployees(List<Employee> employees) {
        Map<Boolean, List<Employee>> result = employees.stream()
                                                .collect(
                                                Collectors.partitioningBy(
                                                    e -> e.getGender().equals("male")));
        System.out.println(result);
    }
}
