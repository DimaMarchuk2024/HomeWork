package homework6;

import java.util.Objects;

public class NewStudent {
    private final String fullName;

    private Double avgGrade;

    public NewStudent(String fullName, Double avgGrade) {
        this.fullName = fullName;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "NewStudent{" +
                "fullName='" + fullName + '\'' +
                ", avgGrade=" + avgGrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewStudent that = (NewStudent) o;
        return Objects.equals(fullName, that.fullName) && Objects.equals(avgGrade, that.avgGrade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, avgGrade);
    }

    public String getFullName() {
        return fullName;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Double avgGrade) {
        this.avgGrade = avgGrade;
    }
}


