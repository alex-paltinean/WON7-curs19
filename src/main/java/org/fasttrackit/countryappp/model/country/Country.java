package org.fasttrackit.countryappp.model.country;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private String capital;
    @Column
    private long population;
    @Column
    private double area;
    @Column
    private String continent;
    @Transient
    private List<String> neighbours;
}
