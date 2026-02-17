package com.demo;

public class Course {
    
    private int id;
    private String name;
    private String instructor;
    private double  fees;

    Course(int id, String name, String instructor, double fees){
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.fees =fees;
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getInstructor(){
    return instructor;
    }
    public double getFees(){
        return fees;
    }

}
