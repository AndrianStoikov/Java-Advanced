import java.util.ArrayList;
import java.util.List;


public class Student {
    private String FacultyNumber;
    private String FirstName;
    private String LastName;
    private String Email;
    private Integer Age;
    private Integer Group;
    private List<Integer> Grade;
    private String Phone;

    public Student(String facultyNumber,
                   String firstName,
                   String lastName,
                   String email,
                   Integer age,
                   Integer group,
                   String Phone) {
        this.FacultyNumber = facultyNumber;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.Age = age;
        this.Group = group;
        this.Grade = new ArrayList<Integer>();
        this.Phone = Phone;
    }

    public String getFacultyNumber() {
        return FacultyNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public Integer getAge() {
        return Age;
    }

    public Integer getGroup() {
        return Group;
    }

    public List<Integer> getGrade() {
        return Grade;
    }

    public String getPhone() {
        return Phone;
    }
}
