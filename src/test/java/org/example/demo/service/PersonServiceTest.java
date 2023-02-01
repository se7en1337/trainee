package org.example.demo.service;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    //Test calculating
    @Test
    void calculateAge() {
        assertEquals(19, PersonService.calculateAge(localDate(2003, 8, 16), localDateNow()));
        assertEquals(20, PersonService.calculateAge(localDate(2002, 5, 12), localDateNow()));
        assertEquals(27, PersonService.calculateAge(localDate(1995, 2, 23), localDateNow()));
        assertEquals(23, PersonService.calculateAge(localDate(1999, 9, 25), localDateNow()));
        assertEquals(8, PersonService.calculateAge(localDate(2014, 12, 31), localDateNow()));
        assertEquals(9, PersonService.calculateAge(localDate(2014, 1, 1), localDateNow()));
        assertEquals(9, PersonService.calculateAge(localDate(2013, 12, 12), localDateNow()));
    }

    //Test exceptions
    @Test
    void expectedFail(){
        assertThrows(DateTimeException.class, () -> PersonService.calculateAge(localDate(2013, 13, 5), localDateNow()));
        assertThrows(DateTimeException.class, () -> PersonService.calculateAge(localDate(2013, 0, 5), localDateNow()));
        assertThrows(DateTimeException.class, () -> PersonService.calculateAge(localDate(2013, 13, 0), localDateNow()));
        assertThrows(DateTimeException.class, () -> PersonService.calculateAge(localDate(2013, 12, 40), localDateNow()));
        assertThrows(DateTimeException.class, () -> PersonService.calculateAge(localDate(2013, 0, 0), localDateNow()));
        assertThrows(DateTimeException.class, () -> PersonService.calculateAge(localDate(0, 0, 0), localDateNow()));
        assertThrows(DateTimeException.class, () -> PersonService.calculateAge(localDate(-5, 14, 3), localDateNow()));
        assertThrows(DateTimeException.class, () -> PersonService.calculateAge(localDate(53, 23, 2), localDateNow()));
    }

    //Test if blocks
    @Test
    void expectedNull() {
        assertNull(PersonService.calculateAge(null,localDate(2013, 12, 12)));
        assertNull(PersonService.calculateAge(localDateNow(), null));
        assertNull(PersonService.calculateAge(null, null));
    }

    private LocalDate localDateNow() {
        return LocalDate.now();
    }

    private LocalDate localDate(int year, int month, int dayOfMonth) {
        return LocalDate.of(year, month, dayOfMonth);
    }
}
