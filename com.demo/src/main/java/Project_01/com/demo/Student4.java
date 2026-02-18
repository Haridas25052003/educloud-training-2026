package Project_01.com.demo;

import java.util.List;

public class Student4 {

    private String name;
    private String city;
    private List<Course1> courses;

    public Student4(String name, String city, List<Course1> courses) {
        this.name = name;
        this.city = city;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public List<Course1> getCourses() {
        return courses;
    }
}
