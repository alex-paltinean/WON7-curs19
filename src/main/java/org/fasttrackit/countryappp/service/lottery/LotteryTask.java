package org.fasttrackit.countryappp.service.lottery;

import lombok.AllArgsConstructor;
import org.fasttrackit.countryappp.model.country.Country;
import org.fasttrackit.countryappp.service.country.CountryService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Component
public class LotteryTask {
    private final CountryService countryService;

    @Scheduled(fixedRateString = "${lottery.interval.seconds}", timeUnit = TimeUnit.SECONDS)
    public void pickWinner() {
        Random random = new Random();
        int i = random.nextInt(countryService.getAll().size());
        System.out.println("Winner country is " + countryService.findById(i).getName());
    }
}
