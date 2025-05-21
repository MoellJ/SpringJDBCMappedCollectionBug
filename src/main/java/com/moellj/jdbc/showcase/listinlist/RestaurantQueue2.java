package com.moellj.jdbc.showcase.listinlist;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("queue")
public record RestaurantQueue2(
    @Id String id,
    @Version int version,
    @MappedCollection(idColumn = "queue_id", keyColumn = "position_in_queue")
    List<Person2> persons
){}
