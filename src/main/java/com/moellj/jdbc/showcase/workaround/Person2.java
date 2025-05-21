package com.moellj.jdbc.showcase.workaround;

import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("person")
public record Person2(
        String id,
        // Workaround using List and a unnecessary skill_idx column
        @MappedCollection(idColumn = "queue_id", keyColumn = "skill_idx") List<Skill2> skills) {
}
