package org.java8.stream;

import org.java8.model.Employee;

import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        Stream.Builder<Employee> stream=Stream.builder();
        stream.add(new Employee())

                .build();
    }
}
