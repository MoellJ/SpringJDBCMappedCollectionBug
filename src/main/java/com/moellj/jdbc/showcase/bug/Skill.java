package com.moellj.jdbc.showcase.bug;

import org.springframework.data.relational.core.mapping.Table;

@Table("skill")
public record Skill(String name, String level) {
}
