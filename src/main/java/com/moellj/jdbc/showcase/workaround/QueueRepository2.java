package com.moellj.jdbc.showcase.workaround;

import org.springframework.data.repository.CrudRepository;


public interface QueueRepository2
        extends CrudRepository<RestaurantQueue2, String> {
}
