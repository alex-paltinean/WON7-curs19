package org.fasttrackit.countryappp.controller.country;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.countryappp.model.country.Country;
import org.fasttrackit.countryappp.service.country.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("countries")
@RequiredArgsConstructor
public class CountryController {
    private final int CONSTANT = 10;
    private final CountryService countryService;

    @GetMapping
    List<Country> getAll() {
        return countryService.getAll();
    }

    @GetMapping("{id}")
    Country findById(@PathVariable int id) {
        return countryService.findById(id);
    }
}
