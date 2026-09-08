package com.akhil.project.model;

import java.time.LocalDate;

public class Student {
    private Long StudentId;
    private String name;
    private int age;
    private String email;
    private long phoneNumber;
    private LocalDate dob = LocalDate.now();

    public Student(Long StudentId, int age, String email, String name, long phoneNumber) {
        this.StudentId = StudentId;
        this.age = age;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Long getStudentId() {
        return StudentId;
    }

    public void setStudentId(Long StudentId) {
        this.StudentId = StudentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student [StudentId=" + StudentId + ", name=" + name + ", age=" + age + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", dob=" + dob + "]";
    }

   
    
}
