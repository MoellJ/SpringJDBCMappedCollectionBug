package com.moellj.jdbc.showcase.setsyntaxexample;

import org.springframework.data.repository.CrudRepository;


public interface CityRepository
        extends CrudRepository<City, String> {
}
