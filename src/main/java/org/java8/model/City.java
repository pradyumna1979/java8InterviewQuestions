package org.java8.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class City implements Comparable{
    private String name;
    private String state;

    @Override
    public int compareTo(Object o) {

        return this.name.compareTo(((City)o).name);
    }
}
