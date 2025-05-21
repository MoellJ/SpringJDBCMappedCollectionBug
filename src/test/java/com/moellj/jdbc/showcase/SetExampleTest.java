package com.moellj.jdbc.showcase;

import com.moellj.jdbc.showcase.setsyntaxexample.House;
import com.moellj.jdbc.showcase.setsyntaxexample.City;
import com.moellj.jdbc.showcase.setsyntaxexample.CityRepository;
import com.moellj.jdbc.showcase.setsyntaxexample.Street;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers(disabledWithoutDocker = true)
@Import({TestContainersConfig.class})
class SetExampleTest {

    @Autowired
    CityRepository cityRepository;

    // This test serves to confirm that the @MappedCollection syntax for Set does indeed work
    @Test
    void saveAndLoad() {
        Street street = new Street("Wonokromo", Set.of(new House("23A")));
        final var city = new City("Surbaya", 0, Set.of(street));
        final var savedCity = cityRepository.save(city);
        final var loadedCity = cityRepository.findById(city.name());
        assertTrue(loadedCity.isPresent());
        assertEquals(savedCity, loadedCity.get());
        System.out.println(loadedCity.get());
    }
}
