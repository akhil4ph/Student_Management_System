package com.akhil.project.service;

import java.util.List;

import com.akhil.project.dao.StudentDAO;
import com.akhil.project.dao.StudentDAOImpl;
import com.akhil.project.model.Student;

public class StudentService {

    private StudentDAO studentDao = new StudentDAOImpl();

    public boolean addStudentInfo(Student student) {
        
        return studentDao.addStudent(student);
    }

    public List<Student> getAllStudentsInfo() {
        return studentDao.getAllStudents();
    }

    
    public Student getStudentById(Long id) { 
        return studentDao.getStudentById(id);
    }

    public boolean updateStudent(Student student, Long id) {
        return studentDao.updateStudent(student, id);
    }

    public boolean deleteStudentById(Long id) {
        return studentDao.deleteStudentById(id);
    }
}