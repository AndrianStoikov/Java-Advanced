package Repository;

import IO.OutputWriter;
import StaticData.ExceptionMessages;

import java.util.*;
import java.util.function.Predicate;

public class RepositoryFilters {
    public static void printFilteredStudents(
            HashMap<String, ArrayList<Integer>> courseData,
            String filterType,
            Integer numberOfStudents) {

        Predicate<Double> filter = createFilter(filterType);

        if(filter == null) {
            String exception = ExceptionMessages.INVALID_FILTER;
            OutputWriter.displayException(exception);
            return;
        }

        int studentsCount = 0;
        for (String student : courseData.keySet()) {
            if(studentsCount == numberOfStudents) break;

            ArrayList<Integer> studentsMark = courseData.get(student);
            Double averageMark = studentsMark.stream().mapToDouble(Integer::valueOf).average().getAsDouble();

            Double percentage = averageMark / 100.0;
            Double mark = (percentage * 4) + 2;
            if(filter.test(mark)) {
                OutputWriter.printStudent(student, studentsMark);
                studentsCount++;
            }
        }
    }

    private static Predicate<Double> createFilter(String filterType) {
        switch(filterType) {
            case "excellent":
                return mark -> mark >= 5.00;
            case "average":
                return mark -> mark >= 3.50 && mark < 5.00;
            case "poor":
                return mark -> mark < 3.50;
            default:
                return null;
        }
    }

}
