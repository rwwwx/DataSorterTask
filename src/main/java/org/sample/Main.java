package org.sample;

import org.sample.datasorter.DateSorterImpl;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DateSorterImpl dateSorter = new DateSorterImpl();
        Collection<LocalDate> result = dateSorter.sortDates(initListOfDates());
        result.forEach(localDate -> System.out.println(
                localDate + " hashcode: " + localDate.hashCode() + " month name: " + localDate.getMonth().toString()));
    }

    private static List<LocalDate> initListOfDates() {
        return List.of(
                LocalDate.parse("2022-01-19"),
                LocalDate.parse("2021-11-12"),
                LocalDate.parse("2022-03-23"),
                LocalDate.parse("2022-01-03"),
                LocalDate.parse("2022-08-16"),
                LocalDate.parse("2022-06-11"),
                LocalDate.parse("2022-05-26"),
                LocalDate.parse("2022-08-13"),
                LocalDate.parse("2022-07-21"));
    }

}