package com.akhil.project.dao;

import java.util.List;

import com.akhil.project.model.Student; 

public interface StudentDAO {
    

    boolean addStudent(Student student);
    

    List<Student> getAllStudents();


    Student getStudentById(Long id);

    boolean updateStudent(Student student, Long id);

    boolean deleteStudentById(Long stu_Id);
    
}