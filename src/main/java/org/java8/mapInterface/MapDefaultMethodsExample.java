package org.java8.mapInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MapDefaultMethodsExample {
    public static void main(String[] args) {
        BiFunction<String, Integer, Integer> biFunction = MapDefaultMethodsExample::applyBifunction;
        Map<String, Integer> map = new HashMap<>(Map.of("pradyumna", 1979, "pratyusha", 2013, "pratyush", 2016, "monalisha", 1986));
        System.out.println("*REPLACE ALL*".repeat(10));
        System.out.println("Original Map : " + map);
        map.replaceAll(biFunction);
        System.out.println("replaceAll Map : " + map);
        System.out.println("*COMPUTE IF PRESENT*".repeat(10));
        map.computeIfAbsent("key1", u -> 2000 + 300);
        System.out.println("computeIfAbsent : " + map);
        map.computeIfPresent("key1", (k, v) -> 44);
        System.out.println("computeIfPresent : " + map);
        System.out.println("*COMPUTE*".repeat(10));
        Map<String, String> map1 = new HashMap<>();

        map1.put("Name", "Aman");
        map1.put("Address", "Kolkata");

        // Print the map
        System.out.println("Map: " + map1);

        // remap the values using compute() method
        map1.compute("Name", (key, val)
                -> val.concat(" Singh"));
        map1.compute("Address", (key, val)
                -> val.concat(" West-Bengal"));
        // print new mapping
        System.out.println("New Map: " + map1);
        System.out.println("*MERGE*".repeat(10));

        Map<Integer, String>
                map2 = new HashMap<>();
        map2.put(1, "L");
        map2.put(2, "M");
        map2.put(3, "N");

        Map<Integer, String>
                map3 = new HashMap<>();
        map3.put(1, "B");
        map3.put(2, "G");
        map3.put(3, "R");

        // print map details
        System.out.println("HashMap2: "
                + map2);

        System.out.println("HashMap3: "
                + map3);
        map3.forEach(
                (k,v)->map2.merge(
                           k,v,(v1,v2)->
                                v1.equalsIgnoreCase(v2)?v1:v1+","+v2
                )
        );
        System.out.println("map3"+map2);
    }

    private static Integer applyBifunction(String u, Integer v) {
        return 2023 - v;
    }
}
