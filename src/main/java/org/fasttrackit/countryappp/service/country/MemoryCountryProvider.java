package org.fasttrackit.countryappp.service.country;

import org.fasttrackit.countryappp.model.city.City;
import org.fasttrackit.countryappp.model.country.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemoryCountryProvider implements CountryProvider {
    @Override
    public List<Country> getCountries() {
        return List.of(
                Country.builder().id(1).name("Albania").capital(new City("Tirana")).build(),
                Country.builder().id(2).name("Burundi").continent("Africa").build());
    }
}
