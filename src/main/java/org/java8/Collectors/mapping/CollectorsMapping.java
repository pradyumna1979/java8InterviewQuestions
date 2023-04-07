package org.java8.Collectors.mapping;

import org.java8.model.City;
import org.java8.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsMapping {
    public static void main(String[] args) {
        Person person1 = new Person("1","pradyumna1","khadanga1",new City("Bhanjanagar","Odisha"));
        Person person2 = new Person("2","pradyumna2","khadanga2",new City("Bhanjanagar","Odisha"));
        Person person3 = new Person("3","pradyumna3","khadanga3",new City("Bhanjanagar3","Odisha3"));
        List<Person> list=Arrays.asList(person1,person2,person3);
        Map<City,Set<String>> lastNamesByCity = getLastNamesByCity(list);
        System.out.println(lastNamesByCity);
    }

    private static Map<City, Set<String>> getLastNamesByCity(List<Person> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Person::getCity,Collectors.mapping(Person::getLsatName,Collectors.toSet())));
    }
}
