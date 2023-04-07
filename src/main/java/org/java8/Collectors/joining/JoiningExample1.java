package org.java8.Collectors.joining;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JoiningExample1 {
    public static void main(String[] args) {
        List<String> list = List.of("a","b","c");
        String str = getCommaSeparatedString(list);
        System.out.println(str);
    }

    private static String getCommaSeparatedString(List<String> list) {
        return list.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));
    }
}
