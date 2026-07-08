package com.model;

public class Student {

    private int id;
    private String name;
    private String course;
    private String email;
    private String mobile;

    public Student() {
    }

    public Student(int id, String name, String course, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.email = email;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}