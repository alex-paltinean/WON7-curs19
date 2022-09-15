package org.fasttrackit.countryappp.controller.country;

import lombok.AllArgsConstructor;
import org.fasttrackit.countryappp.service.country.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("continents")
@AllArgsConstructor
public class ContinentController {

    private final CountryService countryService;

    @GetMapping
    public List<String> getAll(){
        return countryService.getAllContinents();
    }
}
