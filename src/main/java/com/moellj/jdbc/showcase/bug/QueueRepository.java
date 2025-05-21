package com.moellj.jdbc.showcase.bug;

import org.springframework.data.repository.CrudRepository;


public interface QueueRepository
        extends CrudRepository<RestaurantQueue, String> {
}
