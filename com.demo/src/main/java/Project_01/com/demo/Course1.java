package Project_01.com.demo;

public class Course1 {

    private String courseName;
    private Double fee;

    public Course1(String courseName, Double fee) {
        this.courseName = courseName;
        this.fee = fee;
    }

    public String getCourseName() {
        return courseName;
    }

    public Double getFee() {
        return fee;
    }
}
