# SpringJDBCMappedCollectionBug

## Issue

When using `@MappedCollection` for a Set nested within another `@MappedCollection` of type `List` (or `Map`), the `Set` isn't stored correctly. The `keyColumn` of the encapsulating `List` isn't populated in the resulting table entry.

### Example project
To see an example of this, checkout https://github.com/MoellJ/SpringJDBCMappedCollectionBug

RestaurantQueue
├── Person  (via `@MappedCollection(idColumn = "queue_id", keyColumn = "position_in_queue")` in RestaurantQueue)
│   └── Skill (via `@MappedCollection(idColumn = "queue_id")` in Person

For a nested `@MappedCollection` the expected behaviour is that the `keyColumn`s of all parent collections are taken over. However in the provided example `skill.position_in_queue` isn't populated in the database. For `List`s this seems to work.

The repository also contains a workaround using a `List` instead of `Set` (and unnecessary "skill_idx" `keyColumn`) and another example showing that nested `Set`s work with `@MappedCollection`



### Further investigation:

When using `@MappedCollection` for a Set, the documentation and Javadoc state that `idColumn` is sufficient and `keyColumn` isn't needed / used. See https://github.com/spring-projects/spring-data-relational/blob/d411be41ac200a9f324621956b5724f2c88a5a74/spring-data-relational/src/main/java/org/springframework/data/relational/core/mapping/MappedCollection.java#L49
The aforementioned issue also can't be fixed by adding `keyColumn` to the `@MappedCollection`  of the `Set` 


 