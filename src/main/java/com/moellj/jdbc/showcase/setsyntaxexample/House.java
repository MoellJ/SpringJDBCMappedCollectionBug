package com.moellj.jdbc.showcase.setsyntaxexample;

import org.springframework.data.relational.core.mapping.Table;

@Table("house")
public record House(String number) {
}
