package com.cognizant.ormlearn;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootTest
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    public void testGetAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        assertThat(countries).isNotNull();
        assertThat(countries.size()).isGreaterThanOrEqualTo(1);
    }
}
