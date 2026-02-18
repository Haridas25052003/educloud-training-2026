package Project_01.com.demo;

public class Student2 {

    private String studentName;
    private String course;
    private Double fee;

    public Student2(String studentName, String course, Double fee) {
        this.studentName = studentName;
        this.course = course;
        this.fee = fee;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

    public Double getFee() {
        return fee;
    }
}
