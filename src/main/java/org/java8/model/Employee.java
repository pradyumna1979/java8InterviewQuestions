package org.java8.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
    private String name;
    private long salary;
    private Department department;
}
