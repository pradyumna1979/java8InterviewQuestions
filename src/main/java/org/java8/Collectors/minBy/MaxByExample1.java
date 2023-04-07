package org.java8.Collectors.minBy;

import org.java8.model.Department;
import org.java8.model.Employee;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxByExample1 {
    /*
         highest salary in each department
     */
    public static void main(String[] args) {
        Employee employee1 = new Employee("pradyumna", 20_000, new Department("IT"));
        Employee employee2 = new Employee("Mohit", 30_000, new Department("QA"));
        Employee employee3 = new Employee("pradyumna", 40_000, new Department("SUPPORT"));
        Employee employee4 = new Employee("pradyumna", 15_000, new Department("IT"));
        List<Employee> list = List.of(employee1, employee2, employee3, employee4);
        Map<String, Long> map = getPersonOfHighestSalaryByCityJava11(list);
        System.out.println(map);
        Map<String, Optional<Employee>> map1 = getPersonOfHighestSalaryByCity1(list);
        System.out.println(map1);
        Map<String, Long> map2 = getPersonOfHighestSalaryByCityJava8(list);
        System.out.println(map2);

    }

    private static Map<String, Long> getPersonOfHighestSalaryByCityJava11(List<Employee> list) {
        Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary);
        return list.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment().getDept(),
                                Collectors.reducing(0L,
                                        Employee::getSalary,
                                        BinaryOperator.maxBy(Long::compare)
                                )
                        )
                );

    }

    private static Map<String, Long> getPersonOfHighestSalaryByCityJava8(List<Employee> list) {
        Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary);
        return list.stream()
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(employee -> employee.getDepartment().getDept(),
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                ), createMap));

    }

    static Function<Map<String, Optional<Employee>>, Map<String, Long>> createMap = (k) -> {

        return k.entrySet()
                .stream()
                .map(stringOptionalEntry -> new AbstractMap.SimpleEntry<>(stringOptionalEntry.getKey(),
                        stringOptionalEntry.getValue().get().getSalary()))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));
    };


    private static Map<String, Optional<Employee>> getPersonOfHighestSalaryByCity1(List<Employee> list) {
        Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary);
        return list.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment().getDept(),
                                Collectors.maxBy(bySalary)
                        )
                );

    }
}
