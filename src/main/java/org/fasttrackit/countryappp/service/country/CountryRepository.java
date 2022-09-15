package org.fasttrackit.countryappp.service.country;

import org.fasttrackit.countryappp.model.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    List<Country> findByContinent(String name);

    @Query("""
            select c from Country c where (:continentName is null or c.continent = :continentName) 
            and (:minPopulation is null or c.population > :minPopulation) 
            and (:maxPopulation is null or c.population < :maxPopulation)
            and (:text is null or lower(c.name) like :text)""")
    List<Country> getAllFiltered(@Param("continentName") String continentName,
                                 @Param("minPopulation") Long minPopulation,
                                 @Param("maxPopulation") Long maxPopulation,
                                 @Param("text") String text);
}
