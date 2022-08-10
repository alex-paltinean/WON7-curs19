package org.fasttrackit.countryappp.service.country;

import org.fasttrackit.countryappp.model.country.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Primary
public class CountryReader implements CountryProvider {
    @Value("${file.countries}")
    private String fileCountriesPath;
    @Override
    public List<Country> getCountries() {
//        int[] idArr = {0};
        AtomicInteger integer = new AtomicInteger(0);
//        int id = 0;
        try {
            return Files.lines(Path.of(fileCountriesPath))
                    .map(line -> lineToCountry(integer.getAndIncrement(), line))
                    .toList();
        } catch (IOException e) {
            System.err.println("Could not find file");
            return List.of();
        }
    }

    private Country lineToCountry(int id, String line) {
        String[] countryParts = line.split("\\|");
        return new Country(id, countryParts[0], countryParts[1], Long.parseLong(countryParts[2]),
                Double.parseDouble(countryParts[3]), countryParts[4],
                countryParts.length > 5 ? parseNeighbours(countryParts[5]) : List.of());
    }

    private List<String> parseNeighbours(String countryPart) {
        return Arrays.stream(countryPart.split("~")).toList();
    }
}
