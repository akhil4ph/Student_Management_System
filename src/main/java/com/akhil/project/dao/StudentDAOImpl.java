package com.akhil.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.akhil.project.model.Student;
import com.akhil.project.util.DBConnection;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean addStudent(Student student) {
        boolean isAdded = false;
        
        String query = """
                        INSERT INTO StudentInfo_tbl (name, age, email, phone, DOB) VALUES (?, ?, ?, ?, ?)
                        """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString(1, student.getName());
                statement.setInt(2, student.getAge());
                statement.setString(3, student.getEmail());
                statement.setLong(4, student.getPhoneNumber());
                statement.setDate(5, java.sql.Date.valueOf(student.getDob()));
                
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected == 1) {
                    isAdded = true;
                } else {
                    System.out.println("Failed to add student. 0 rows affected.");
                }
                
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
        
        return isAdded;
    }

    
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();


        String query = """
                            SELECT * FROM StudentInfo_tbl
                """;
                try( Connection connection = DBConnection.getConnection();
                    PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery();
                ){


                    while(resultSet.next()){
                        Student student = mapRow(resultSet);
                        students.add(student);
                    }
                } catch (SQLException e) {
                    System.out.println("Error retrieving students: " + e);
                }
        return students;
    }

    @Override
    public boolean updateStudent(Student student, Long id) {
        boolean isUpdated = false;

        String query = """
                            UPDATE StudentInfo_tbl SET name = ?, age = ?, email = ?, phone = ?, DOB = ? WHERE stu_id = ?
                """;


            try(Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
            ){

                statement.setString(1, student.getName());
                statement.setInt(2, student.getAge());
                statement.setString(3, student.getEmail());
                statement.setLong(4, student.getPhoneNumber());
                statement.setObject(5, student.getDob());
                statement.setLong(6, id);

                int rowsAffected = statement.executeUpdate();
                if(rowsAffected == 1){
                    isUpdated = true;
                } else {
                    System.out.println("Failed to update student. 0 rows affected.");
                }

            } catch (SQLException e) {
                System.out.println("Error updating student: " + e);
            }


        return isUpdated;
    }

    @Override
    public boolean deleteStudentById(Long stu_Id) {
    

        boolean isDeleted = false;

        String query = """
                    
                        DELETE FROM studentInfo_tbl WHERE stu_Id = ?
                """;

        try(
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
        ){

            int rowsAffected = statement.executeUpdate();
            if(rowsAffected == 1){
                isDeleted = true;
            } else {
                System.out.println("Failed to delete student. 0 rows affected.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e);
        }

        return isDeleted ;
    }


    @Override
    public Student getStudentById(Long id) {
        Student student = null;

        
        String query = """
                            SELECT * FROM StudentInfo_tbl WHERE stu_id = ?
                """;
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
                
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();


            if (resultSet.next()) {
                student = mapRow(resultSet);
            }
            
        } catch (SQLException e) {
            System.out.println("Error retrieving student by ID: " + e);
        }
        
        return student;
    }

    private Student mapRow(ResultSet resultSet) throws SQLException {

            Long id = resultSet.getLong("stu_Id");
            int age = resultSet.getInt("age");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            long phone = resultSet.getLong("phone");

            Student student = new Student(id, age, email, name, phone);
            return student;
        }

}



 