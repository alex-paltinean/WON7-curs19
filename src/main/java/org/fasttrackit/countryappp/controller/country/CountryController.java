package org.fasttrackit.countryappp.controller.country;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.countryappp.model.city.City;
import org.fasttrackit.countryappp.model.country.Country;
import org.fasttrackit.countryappp.service.country.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("countries")
@RequiredArgsConstructor
public class CountryController {
    private final int CONSTANT = 10;
    private final CountryService countryService;

    @GetMapping
    List<Country> getAll(@RequestParam(required = false) String continentName,
                         @RequestParam(required = false) Long minPopulation,
                         @RequestParam(required = false) Long maxPopulation,
                         @RequestParam(required = false) String text) {
        return countryService.getAllFiltered(continentName, minPopulation, maxPopulation, text);
    }

    @GetMapping("{id}")
    Country findById(@PathVariable int id) {
        return countryService.findById(id);
    }

    @PostMapping
    Country save(@RequestBody Country country) {
        return countryService.save(country);
    }

    @PutMapping("{id}")
    Country update(@RequestBody Country country, @PathVariable Integer id){
        return countryService.update(country, id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable int id) {
        countryService.delete(id);
    }

    @PostMapping("{id}/cities")
    Country addCityToCountry(@PathVariable int id, @RequestBody City city) {
        return countryService.addCityToCountry(id, city);
    }
}
