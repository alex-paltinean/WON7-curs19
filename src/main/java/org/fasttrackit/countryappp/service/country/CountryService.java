package org.fasttrackit.countryappp.service.country;

import org.fasttrackit.countryappp.exception.ResourceNotFoundException;
import org.fasttrackit.countryappp.model.country.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final List<Country> countries;

    public CountryService(/*@Qualifier("memoryCountryProvider")*/ CountryProvider countryProvider) {
        this.countries = countryProvider.getCountries();
    }

    public List<Country> getAll() {
        return countries;
    }

    public Country findById(int id) {
        return countries.stream()
                .filter(country -> country.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Country not found!"));
    }
}
