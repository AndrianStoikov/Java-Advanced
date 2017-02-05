package SerializeCustomObject;


import java.io.Serializable;

public class Course implements Serializable {
    private String name = "";
    private Integer students = 0;

    Course(String name, Integer students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudents() {
        return students;
    }

    public void setStudents(Integer students) {
        this.students = students;
    }
}
