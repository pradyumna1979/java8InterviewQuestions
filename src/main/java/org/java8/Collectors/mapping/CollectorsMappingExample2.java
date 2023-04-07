package org.java8.Collectors.mapping;

import org.java8.model.City;
import org.java8.model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsMappingExample2 {
    /*
    For example, to compute the set of last names of people in each city, where the city names are sorted:
     */
    public static void main(String[] args) {
        Person person1 = new Person("1","pradyumna1","khadanga",new City("abc","Odisha"));
        Person person2 = new Person("2","pradyumna2","khadanga1",new City("chanjanagar","Odisha"));
        Person person3 = new Person("3","pradyumna3","khadanga3",new City("bhanjanagar3","Odisha3"));
        List<Person> list=Arrays.asList(person1,person2,person3);
        Map<City,Set<String>> lastNamesByCity = getLastNamesByCitySortedByCityNames(list);
        System.out.println(lastNamesByCity);
    }

    private static Map<City, Set<String>> getLastNamesByCitySortedByCityNames(List<Person> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Person::getCity,TreeMap::new,Collectors.mapping(Person::getLsatName, Collectors.toSet())));
    }

    private static Map<City, Set<String>> getLastNamesByCity(List<Person> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Person::getCity,Collectors.mapping(Person::getLsatName,Collectors.toSet())));
    }
}
