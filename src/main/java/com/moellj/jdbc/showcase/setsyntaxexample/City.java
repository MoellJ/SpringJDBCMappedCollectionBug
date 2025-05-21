package com.moellj.jdbc.showcase.setsyntaxexample;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("city")
public record City(
        @Id String name,
        @Version int version,
        @MappedCollection(idColumn = "city_name") Set<Street> streets) {
}
