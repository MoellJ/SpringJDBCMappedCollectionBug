package com.moellj.jdbc.showcase;

import com.moellj.jdbc.showcase.bug.Person;
import com.moellj.jdbc.showcase.bug.QueueRepository;
import com.moellj.jdbc.showcase.bug.RestaurantQueue;
import com.moellj.jdbc.showcase.bug.Skill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers(disabledWithoutDocker = true)
@Import({TestContainersConfig.class})
class BugTest {

    @Autowired
    QueueRepository queueRepository;

    @Test
    void bug_saveAndLoad() {
        final var person = new Person("p1", Set.of(new Skill("coding", "level-1")));
        final var queue = new RestaurantQueue("queue", 0, List.of(person));
        final var savedQueue = queueRepository.save(queue);
        final var loadedQueue = queueRepository.findById(queue.id());
        assertTrue(loadedQueue.isPresent());
        assertEquals(savedQueue, loadedQueue.get());
        System.out.println(loadedQueue.get());
    }
}
