package org.sample.datasorter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class DateSorterImpl implements IDateSorter {

    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        Collection<LocalDate> result = new ArrayList<>();
        result.addAll(unsortedDates.stream()
                .filter(localDate -> localDate.getMonth().name().contains("R"))
                .sorted(LocalDate::compareTo)
                .toList());
        result.addAll(unsortedDates.stream()
                .filter(localDate -> !localDate.getMonth().name().contains("R"))
                .sorted(Comparator.reverseOrder())
                .toList());
        return result;
    }

}
