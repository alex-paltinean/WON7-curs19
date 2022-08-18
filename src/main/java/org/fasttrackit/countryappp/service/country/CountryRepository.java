package org.fasttrackit.countryappp.service.country;

import org.fasttrackit.countryappp.model.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    List<Country> findByContinent(String name);
}
