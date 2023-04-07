package org.java8.Collectors.reducing;

import org.java8.model.City;
import org.java8.model.Person;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ReducingExample {
    /*
    given a stream of Person, to calculate the longest last name of residents in each city:
     */
    public static void main(String[] args) {
        Person person1 = new Person("1", "pradyumna1", "khadanga1", new City("Bhanjanagar", "Odisha"));
        Person person2 = new Person("2", "pradyumna2", "khadangaMishra", new City("Bhanjanagar", "Odisha"));
        Person person3 = new Person("3", "pradyumna3", "khadangaDash", new City("Bhanjanagar", "Odisha"));
        List<Person> list = Arrays.asList(person1, person2, person3);
        Map<City, Optional<Person>> lastNamesByCity = getLongestLastNameOfEachCity(list);
        System.out.println(lastNamesByCity);
        Map<City, Optional<Person>> lastNamesByCity1 = getLongestLastNameOfEachCity1(list);
        System.out.println(lastNamesByCity1);
    }


    private static Map<City, Optional<Person>> getLongestLastNameOfEachCity(List<Person> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Person::getCity,
                                Collectors.reducing(BinaryOperator.maxBy(
                                                Comparator.comparing(
                                                        Person::getLsatName
                                                )
                                        )
                                )
                        )
                );
    }
    private static Map<City, Optional<Person>> getLongestLastNameOfEachCity1(List<Person> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Person::getCity,
                                Collectors.maxBy(
                                                Comparator.comparing(
                                                        Person::getLsatName
                                                )
                                        )
                                )
                );
    }
}
