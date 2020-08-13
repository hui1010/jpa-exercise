package se.lexicon.huiyi.jpaexercises.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    AppUser user;

    @BeforeEach
    void setUp() {
        user = new AppUser("Bowser", "test", "Tester",
                LocalDate.parse("2000-01-01"), false, null);
    }

    @Test
    void successfully_created() {
        assertNotNull(user);
        assertTrue(user.getUserId()==0);
        assertEquals(user.getUserName(), "Bowser");
        assertEquals("test", user.getFirstName());
        assertEquals("Tester", user.getLastName());
        assertEquals("2000-01-01", user.getBirthDate().toString());
        assertFalse(user.isActive());
    }

    @Test
    void testEquals() {
        AppUser copy = new AppUser("Bowser", "test", "Tester",
                LocalDate.parse("2000-01-01"), false, null);
        assertEquals(user, copy);
    }

    @Test
    void testHashcode() {
        AppUser copy = new AppUser("Bowser", "test", "Tester",
                LocalDate.parse("2000-01-01"), false, null);
        assertEquals(user.hashCode(), copy.hashCode());
    }

    @Test
    void testToString() {
        String string = user.toString();
        assertTrue(string.contains(Integer.toString(user.getUserId())));
        assertTrue(string.contains(user.getFirstName()));
        assertTrue(string.contains(user.getLastName()));
        assertTrue(string.contains(user.getUserName()));
        assertTrue(string.contains(user.getBirthDate().toString()));
        assertTrue(string.contains(Boolean.toString(user.isActive())));

    }
}