package org.fasttrackit.countryappp.service.country;

import org.fasttrackit.countryappp.exception.ResourceNotFoundException;
import org.fasttrackit.countryappp.model.country.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryProvider countryProvider, CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
        countryRepository.saveAll(countryProvider.getCountries());
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public Country findById(int id) {
        return countryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found"));
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }

    public List<Country> findByContinent(String name){
        return countryRepository.findByContinent(name);
    }
}
