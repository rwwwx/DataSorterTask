package org.sample.datasorter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateSorterImplTest {

    private DateSorterImpl dateSorter;
    private List<LocalDate> input;
    private List<LocalDate> expected;

    @BeforeEach
    void setUp() {
        this.dateSorter = new DateSorterImpl();
    }

    @Test
    void monthsWithRLetter() {
        input = List.of(
                LocalDate.parse("2021-11-12"),
                LocalDate.parse("2022-01-03"),
                LocalDate.parse("2021-01-19"),
                LocalDate.parse("2022-12-01"),
                LocalDate.parse("2022-07-21"),
                LocalDate.parse("2022-08-16"),
                LocalDate.parse("2022-08-13"),
                LocalDate.parse("2022-03-23")
                );
        expected = List.of(
                LocalDate.parse("2021-01-19"),
                LocalDate.parse("2021-11-12"),
                LocalDate.parse("2022-01-03"),
                LocalDate.parse("2022-03-23"),
                LocalDate.parse("2022-12-01"),
                LocalDate.parse("2022-08-16"),
                LocalDate.parse("2022-08-13"),
                LocalDate.parse("2022-07-21")
                );
        assertEquals(expected, dateSorter.sortDates(input));
    }

    @Test
    void monthsWithoutRLetter() {
        input = List.of(
                LocalDate.parse("2021-06-12"),
                LocalDate.parse("2021-05-12"),
                LocalDate.parse("2022-08-09"),
                LocalDate.parse("2022-08-03"),
                LocalDate.parse("2022-07-23"),
                LocalDate.parse("2021-06-22"),
                LocalDate.parse("2021-05-01"),
                LocalDate.parse("2022-07-04")
        );
        expected = List.of(
                LocalDate.parse("2022-08-09"),
                LocalDate.parse("2022-08-03"),
                LocalDate.parse("2022-07-23"),
                LocalDate.parse("2022-07-04"),
                LocalDate.parse("2021-06-22"),
                LocalDate.parse("2021-06-12"),
                LocalDate.parse("2021-05-12"),
                LocalDate.parse("2021-05-01")
                );
        assertEquals(expected, dateSorter.sortDates(input));
    }

    @Test
    void sortDates() {
        input = List.of(
                LocalDate.parse("2022-01-19"),
                LocalDate.parse("2021-11-12"),
                LocalDate.parse("2022-03-23"),
                LocalDate.parse("2022-01-03"),
                LocalDate.parse("2022-08-16"),
                LocalDate.parse("2022-06-11"),
                LocalDate.parse("2022-05-26"),
                LocalDate.parse("2022-08-13"),
                LocalDate.parse("2022-07-21"));
        expected = List.of(
                LocalDate.parse("2021-11-12"),
                LocalDate.parse("2022-01-03"),
                LocalDate.parse("2022-01-19"),
                LocalDate.parse("2022-03-23"),
                LocalDate.parse("2022-08-16"),
                LocalDate.parse("2022-08-13"),
                LocalDate.parse("2022-07-21"),
                LocalDate.parse("2022-06-11"),
                LocalDate.parse("2022-05-26"));
        assertEquals(expected, dateSorter.sortDates(input));
    }
}