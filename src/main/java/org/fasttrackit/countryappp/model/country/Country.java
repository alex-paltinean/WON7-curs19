package org.fasttrackit.countryappp.model.country;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fasttrackit.countryappp.model.city.City;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
public class Country {
    public Country(Integer id, String name, City capital, long population, double area, String continent, List<String> neighbours) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbours = neighbours;
    }

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private City capital;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "country",
            fetch = FetchType.LAZY)
    private List<City> cities;
    @ManyToMany
    private List<Country> neighboursCountries;
    @Column
    private long population;
    @Column
    private double area;
    @Column
    private String continent;
    @Transient
    private List<String> neighbours;

    public void addCity(City city) {
        if (cities == null) {
            cities = new ArrayList<>();
        }
        cities.add(city);
    }
}
