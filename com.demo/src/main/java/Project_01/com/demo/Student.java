package Project_01.com.demo;

public class Student {

    private Integer id;
    private String name;
    private String city;
    private Double fee;
    private String status;

    public Student(Integer id, String name, String city, Double fee, String status) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.fee = fee;
        this.status = status;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getCity() { return city; }
    public Double getFee() { return fee; }
    public String getStatus() { return status; }
}
