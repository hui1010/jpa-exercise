package se.lexicon.huiyi.jpaexercises.dao_access;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.huiyi.jpaexercises.entity.TodoItem;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
class TodoItemDaoJpaImplTest {
    TodoItem one;
    TodoItem two;
    TodoItem three;

    @Autowired
    TodoItemDao test;

    @Autowired
    TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        one = new TodoItem("clean", "clean the kitchen", null);
        two = new TodoItem("shopping", "buy milk", null);
        three = new TodoItem("clean", "broom cats", null);

        assertNotNull(one);
        assertNotNull(two);
        assertNotNull(three);
    }

    @Test
    void save_and_findById() {
        test.save(one);
        test.save(two);
        test.save(three);

        assertNotNull(test.findById("1"));
        assertNotNull(test.findById("2"));
        assertNotNull(test.findById("3"));

        //test findById
        assertEquals(three, test.findById(three.getToDoId()).get());
        assertEquals(two, test.findById(two.getToDoId()).get());
        assertEquals(one, test.findById(one.getToDoId()).get());

        //test delete

        assertTrue(test.delete(three));
        assertEquals(2, test.findAll().size());
    }

    @Test
    void delete() {
        test.save(one);
        test.save(two);
        test.save(three);

        test.delete(three);
        assertTrue(test.findById(three.getToDoId()).isEmpty());
    }

    @Test
    void update() {
        test.save(one);
        test.save(two);
        one = new TodoItem("clean", "clean the kitchen", LocalDateTime.now());

        assertEquals(one.getDeadline(), test.update(one).getDeadline());
    }


    @Test
    void findByTitle() {
        test.save(one);
        test.save(two);
        test.save(three);

        assertEquals(2, test.findByTitle("clean").size());
    }

    @Test
    void findAll() {
        test.save(one);
        test.save(two);
        test.save(three);

        assertEquals(3, test.findAll().size());
    }

    @Test
    void findByDone() {
        one.setDone(true);
        two.setDone(true);
        test.save(one);
        test.save(two);
        test.save(three);

        assertEquals(2, test.findByDone().size());
    }
}