package org.java8.Collectors.filtering;

import org.java8.model.Department;
import org.java8.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FilteringExample {
    /*
    All the departments whose salary greater then a threshold
     */
    public static void main(String[] args) {
        Employee employee1 = new Employee("pradyumna",20_000,new Department("IT"));
        Employee employee2 = new Employee("Mohit",30_000,new Department("IT"));
        Employee employee3 = new Employee("pradyumna",40_000,new Department("SUPPORT"));
        Employee employee4 = new Employee("pradyumna",15_000,new Department("IT"));
        List<Employee> list = List.of(employee1,employee2,employee3,employee4);
        Map<Department, Set<Employee>> map = getDepartmentBySalary(list);
        System.out.println(map);
    }

    private static Map<Department, Set<Employee>> getDepartmentBySalary(List<Employee> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.filtering(employee -> employee.getSalary()>=20_000,Collectors.toSet())));
    }
}
