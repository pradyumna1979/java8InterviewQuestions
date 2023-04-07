package org.java8.Collectors.joining;

import org.java8.model.City;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JoiningExample2 {
    public static void main(String[] args) {
        List<City> list = List.of(new City("pradyumna","odisha"),new City("abc","odisha"));
        String str = getCommaSeparatedString(list);
        System.out.println(str);
    }

    private static String getCommaSeparatedString(List<City> list) {
        return list.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));
    }
}
