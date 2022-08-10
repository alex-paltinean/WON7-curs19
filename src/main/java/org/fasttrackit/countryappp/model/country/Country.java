package org.fasttrackit.countryappp.model.country;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Country {
    private int id;
    private String name;
    private String capital;
    private long population;
    private double area;
    private String continent;
    private List<String> neighbours;
}
