package org.fasttrackit.countryappp;

import org.fasttrackit.countryappp.model.country.Country;
import org.fasttrackit.countryappp.service.country.CountryProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class CountryAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountryAppApplication.class, args);
    }

    @Bean
    CountryProvider emptyCountryProvider() {
        return Arrays::asList;
    }
}
