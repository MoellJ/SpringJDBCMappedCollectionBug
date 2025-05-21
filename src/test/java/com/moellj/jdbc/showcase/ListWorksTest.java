package com.moellj.jdbc.showcase;

import com.moellj.jdbc.showcase.listinlist.Person2;
import com.moellj.jdbc.showcase.listinlist.QueueRepository2;
import com.moellj.jdbc.showcase.listinlist.RestaurantQueue2;
import com.moellj.jdbc.showcase.listinlist.Skill2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers(disabledWithoutDocker = true)
@Import({TestContainersConfig.class})
class ListWorksTest {

    @Autowired
    QueueRepository2 queueRepository;

    @Test
    void workaround_saveAndLoad() {
        final var person = new Person2("p1", List.of(new Skill2("coding", "level-1")));
        final var queue = new RestaurantQueue2("queue", 0, List.of(person));
        final var savedQueue = queueRepository.save(queue);
        final var loadedQueue = queueRepository.findById(queue.id());
        assertTrue(loadedQueue.isPresent());
        assertEquals(savedQueue, loadedQueue.get());
        System.out.println(loadedQueue.get());
    }
}
