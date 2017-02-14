import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Path studentsDataPath = Paths.get(
                "C:\\Users\\Andrian\\IdeaProjects\\Java\\Java-Advanced\\Stream API - Exercises\\src\\StudentData.txt");


        List<String> data = new ArrayList<>();

        try {
            data = Files.readAllLines(studentsDataPath);
            List<Student> students = new ArrayList<>();

            for (int i = 0; i < data.size(); i++) {
                String[] tokens = data.get(i).split("\\s+");
                String facNum = tokens[0];
                String firstName = tokens[1];
                String lastName = tokens[2];
                String email = tokens[3];
                Integer age = Integer.valueOf(tokens[4]);
                Integer group = Integer.valueOf(tokens[5]);
                String phone = tokens[10];

                Student student = new Student(facNum, firstName, lastName, email, age, group, phone);

                for (int gradeIndex = 6; gradeIndex <= 9; gradeIndex++) {
                    Integer grade = Integer.valueOf(tokens[gradeIndex]);
                    student.getGrade().add(grade);
                }
                students.add(student);
            }


            //P01_StudentsByGroup(students);
            //P02_StudentsByFirstAndLastName(students);
            //P04_SortStudents(students);
            //P05_FilterStudentsByEmail(students);
            //P06_FilterStudentsByPhone(students);
            //P07_ExcellentStudents(students);
            //P08_WeakStudents(students);
            P09_StudentsByEnrollmentYear(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void P01_StudentsByGroup(List<Student> students) {
        students.stream()
                .filter(a -> a.getGroup() == 2)
                .sorted(Comparator.comparing(Student::getFirstName))
                .forEach(student -> System.out.println(student.getFirstName() + " " + student.getLastName()));
    }

    public static void P02_StudentsByFirstAndLastName(List<Student> students) {
        students.stream()
                .filter(a -> a.getFirstName().compareTo(a.getLastName()) <= 0)
                .forEach(student -> System.out.println(student.getFirstName() + " " + student.getLastName()));
    }

    public static void P03_StudentsByAge(List<Student> students) {
        students.stream()
                .filter(a -> a.getAge() >= 18 && a.getAge() <= 24)
                .forEach(student -> System.out.println(student.getFirstName()
                        + " " + student.getLastName() + " " + student.getAge()));
    }

    public static void P04_SortStudents(List<Student> students) {

        Comparator<Student> lastNameAscending =
                Comparator.comparing(Student::getLastName);

        Comparator<Student> studentComparator =
                lastNameAscending
                        .thenComparing((s1, s2) -> s2.getFirstName().compareTo(s1.getFirstName()));

        students.stream()
                .sorted(studentComparator)
                .forEach(student -> System.out.println(student.getFirstName()
                        + " " + student.getLastName()));
    }

    public static void P05_FilterStudentsByEmail(List<Student> students) {
        students.stream()
                .filter(s -> s.getEmail().endsWith("@gmail.com"))
                .forEach(student -> System.out.println(student.getFirstName()
                        + " " + student.getLastName() + " " + student.getEmail()));
    }

    public static void P06_FilterStudentsByPhone(List<Student> students) {
        students.stream()
                .filter(s -> s.getPhone().startsWith("02") || s.getPhone().startsWith("+3592"))
                .forEach(student -> System.out.println(student.getFirstName()
                        + " " + student.getLastName() + " " + student.getPhone()));
    }

    public static void P07_ExcellentStudents(List<Student> students) {
        students.stream()
                .filter(s -> s.getGrade().contains(6))
                .forEach(student -> {
                    StringBuilder grades = new StringBuilder();
                    student.getGrade()
                            .stream()
                            .sorted(Comparator.reverseOrder())
                            .forEach(grade -> grades.append(grade).append(" "));
                    System.out.println(student.getFirstName()
                            + " " + student.getLastName() + " " + grades);
                });
    }

    public static void P08_WeakStudents(List<Student> students) {
        Comparator<Student> compareGrades = (s1, s2) -> {
            double first = (double) s1.getGrade().stream().reduce((a, b) -> a + b).get() / s1.getGrade().size();
            double second = (double) s2.getGrade().stream().reduce((a, b) -> a + b).get() / s2.getGrade().size();

            return -Double.compare(second, first);
        };

        students.stream()
                .filter(s -> {
                    int marksThree = Collections.frequency(s.getGrade(), 3);
                    int marksUnderThree = Collections.frequency(s.getGrade(), 2);
                    return (marksThree + marksUnderThree) >= 2;
                })
                .sorted(compareGrades)
                .forEach(student -> {
                    StringBuilder grades = new StringBuilder();
                    student.getGrade()
                            .stream()
                            .sorted(Integer::compare)
                            .forEach(grade -> grades.append(grade).append(" "));
                    System.out.println(student.getFirstName()
                            + " " + student.getLastName() + " " + grades);
                });
    }

    public static void P09_StudentsByEnrollmentYear(List<Student> students) {
        Map<Integer, List<Student>> studentsByYear =
                students.stream()
                        .collect(Collectors.groupingBy(s -> Integer.valueOf(
                                s.getFacultyNumber().substring(s.getFacultyNumber().length() - 2)
                        )));

        studentsByYear.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println("20" + entry.getKey() + ":");
                    entry.getValue().stream()
                            .sorted(Comparator.comparing(s -> (s.getFirstName() + s.getLastName())))
                            .forEach(s -> {
                                System.out.printf("-- %s %s\n", s.getFirstName(), s.getLastName());
                            });
                });
    }
}
