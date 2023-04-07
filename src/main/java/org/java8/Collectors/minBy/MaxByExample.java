package org.java8.Collectors.minBy;

import org.java8.model.Department;
import org.java8.model.Employee;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class MaxByExample {
    /*
        Employee with highest salary in each department
     */
    public static void main(String[] args) {
        Employee employee1 = new Employee("pradyumna", 20_000, new Department("IT"));
        Employee employee2 = new Employee("Mohit", 30_000, new Department("IT"));
        Employee employee3 = new Employee("pradyumna", 40_000, new Department("SUPPORT"));
        Employee employee4 = new Employee("pradyumna", 15_000, new Department("IT"));
        List<Employee> list = List.of(employee1, employee2, employee3, employee4);
        Map<String, Optional<Employee>> map = getPersonOfHighestSalaryByCity(list);
        System.out.println(map);

    }

    private static Map<String, Optional<Employee>> getPersonOfHighestSalaryByCity(List<Employee> list) {
        return list.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment().getDept(),
                                Collectors.reducing(
                                        BinaryOperator.maxBy(
                                                Comparator.comparing(Employee::getSalary)
                                        )
                                )
                        )
                );
    }
}
