package com.demo;

public class Student {

    private String name;
    private int marks;

    Student(String name, int marks){
        this.name =name;
        this.marks =marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}
