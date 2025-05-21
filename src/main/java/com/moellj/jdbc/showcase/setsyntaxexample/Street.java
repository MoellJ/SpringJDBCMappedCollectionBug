package com.moellj.jdbc.showcase.setsyntaxexample;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("street")
public record Street(@Id String name,@MappedCollection(idColumn = "streetname") Set<House> items) {
}
