package se.lexicon.huiyi.jpaexercises.dao_access;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.huiyi.jpaexercises.entity.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
class AppUserDapJpaImplTest {
    AppUser user1;
    AppUser user2;
    AppUser user3;

    @Autowired
    AppUserDao test;

    @Autowired
    TestEntityManager entityManager;

    @BeforeEach
    void setUp() {

        user1 = entityManager.persistAndFlush(new AppUser("one", "test1", "Tester1", null, true, null));
        user2 = entityManager.persistAndFlush(new AppUser("two", "test2", "Tester2", LocalDate.of(2020,2,2), true, null));
        user3 = entityManager.persistAndFlush(new AppUser("three", "test3", "Tester3", LocalDate.of(2020,3,3), false, null));

        assertNotNull(user1);
        assertNotNull(user2);
        assertNotNull(user3);

    }


    @Test
    void update() {
        user1 = new AppUser("one", "test1", "Tester1", LocalDate.of(2000,1,1), true, null);
        test.update(user1);
        assertNotNull(user1.getBirthDate());
        assertEquals("2000-01-01", user1.getBirthDate().toString());
    }

    @Test
    void save_and_findById_and_delete() {

        test.save(user1);
        test.save(user2);
        test.save(user3);

        //test the save and findById method
        assertNotNull(test.findById(2));
        assertEquals(user2, test.findById(2).get());

        //test the delete method
        test.delete(user2);
        assertNull(test.findById(2));
    }

}