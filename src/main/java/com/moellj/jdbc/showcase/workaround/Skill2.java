package com.moellj.jdbc.showcase.workaround;

import org.springframework.data.relational.core.mapping.Table;

@Table("skill")
public record Skill2(String name, String level) {
}
