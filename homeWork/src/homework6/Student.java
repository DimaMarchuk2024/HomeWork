package homework6;

import java.util.List;
import java.util.Objects;

public class Student {

    private final String firstName;
    private final String lastName;
    private Integer course;

    List<Integer> listGrades;

    public Student(String firstName, String lastName, Integer course, List<Integer> listGrades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.listGrades = listGrades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", course=" + course +
                ", listGrades=" + listGrades +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(course, student.course) &&
                Objects.equals(listGrades, student.listGrades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, course, listGrades);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getCourse() {
        return course;
    }

    public List<Integer> getListGrades() {
        return listGrades;
    }

    public void setListGrades(List<Integer> listGrades) {
        this.listGrades = listGrades;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }
}
