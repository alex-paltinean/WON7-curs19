package org.fasttrackit.countryappp.service.person;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final String config;
    private final boolean booleanConfig;
    private final int intConfig;

    public PersonService(@Value("${my.string.config}") String config,
                         @Value("${my.boolean.config}") boolean booleanConfig,
                         @Value("${my.int.config:56}") int intConfig) {
        this.config = config;
        this.booleanConfig = booleanConfig;
        this.intConfig = intConfig;
        System.out.println(config + " " + booleanConfig + " " + intConfig);
    }
}
