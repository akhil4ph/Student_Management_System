package com.akhil.project;

import java.util.List;
import java.util.Scanner;

import com.akhil.project.model.Student;
import com.akhil.project.service.StudentService;

public class App {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
         StudentService studentService = new StudentService();

        System.out.println("=========================================");
        System.out.println("   Welcome to Student Management System  ");
        System.out.println("=========================================");

        
        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add Student Info");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Info");
            System.out.println("5. Delete Student by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            
             scanner.nextLine(); 

              switch (choice) {
                case 1:
                    System.out.println("\n[ Add Student Selected ]");
                    
                     System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    long phone = scanner.nextLong();
                    scanner.nextLine(); 
                        Student newStudent = new Student(0L, age, email, name, phone);

                      boolean isAdded = studentService.addStudentInfo(newStudent);
                    if (isAdded) {
                        System.out.println("Success: Student added to database!");
                    } else {
                        System.out.println("Error: Failed to add student.");
                    }
                    break;

                case 2:
                    System.out.println("\n[ View All Students Selected ]");
                    
                    List<Student> studentList = studentService.getAllStudentsInfo();
                    
                    if (studentList.isEmpty()) {
                        System.out.println("No students found in the database. Pehle kuch data add karo!");
                    } else {
                        System.out.println("---------------------------------------------------------------------------------------");
                        
                        System.out.printf("%-5s | %-15s | %-5s | %-25s | %-12s | %-12s\n", "ID", "Name", "Age", "Email", "Phone", "DOB");
                        System.out.println("---------------------------------------------------------------------------------------");
                        
                        
                        for (Student s : studentList) {
                            System.out.printf("%-5d | %-15s | %-5d | %-25s | %-12d | %-12s\n", 
                                    s.getStudentId(), s.getName(), s.getAge(), s.getEmail(), s.getPhoneNumber(), s.getDob());
                        }
                        System.out.println("---------------------------------------------------------------------------------------");
                    }
                    break;

                case 3:
                    System.out.println("\n[ Search Student Selected ]");
                    System.out.print("Enter Student ID to search: ");
                    
                    
                    Long searchId = scanner.nextLong();
                    scanner.nextLine(); 
                    
                    
                    Student foundStudent = studentService.getStudentById(searchId);
                    
                    if (foundStudent != null) {
                        System.out.println("\n--- Student Details ---");
                        System.out.println("ID    : " + foundStudent.getStudentId());
                        System.out.println("Name  : " + foundStudent.getName());
                        System.out.println("Age   : " + foundStudent.getAge());
                        System.out.println("Email : " + foundStudent.getEmail());
                        System.out.println("Phone : " + foundStudent.getPhoneNumber());
                        
                        
                        System.out.println("DOB   : " + foundStudent.getDob());
                        System.out.println("-----------------------");
                    } else {
                        System.out.println("Error: No student found with ID " + searchId);
                    }
                    break;

                case 4:
                    System.out.println("\n[ Update Student Selected ]");
                    System.out.print("Enter Student ID to update: ");
                    long updateId = scanner.nextLong();
                    scanner.nextLine(); 

                    
                    Student existingStudent = studentService.getStudentById(updateId);

                    if (existingStudent != null) {
                        System.out.println("Student found! Current Name: " + existingStudent.getName());
                        
                        
                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine();
                        
                        System.out.print("Enter New Age: ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.print("Enter New Email: ");
                        String newEmail = scanner.nextLine();
                        
                        System.out.print("Enter New Phone Number: ");
                        long newPhone = scanner.nextLong();
                        scanner.nextLine();

                        
                        existingStudent.setName(newName);
                        existingStudent.setAge(newAge);
                        existingStudent.setEmail(newEmail);
                        existingStudent.setPhoneNumber(newPhone);
                        
                        
                        boolean isUpdated = studentService.updateStudent(existingStudent, updateId);
                        
                        if (isUpdated) {
                            System.out.println("Success: Student details updated successfully!");
                        } else {
                            System.out.println("Error: Failed to update student.");
                        }
                    } else {
                        System.out.println("Error: No student found with ID " + updateId);
                    }
                    break;

                case 5:
                    System.out.println("\n[ Delete Student Selected ]");
                    System.out.print("Enter Student ID to delete: ");
                    long deleteId = scanner.nextLong();
                    scanner.nextLine(); // Buffer clear

                    
                    Student studentToDelete = studentService.getStudentById(deleteId);
                    
                    if (studentToDelete != null) {
                        
                        System.out.print("Are you sure you want to delete " + studentToDelete.getName() + "? (Y/N): ");
                        String confirm = scanner.nextLine();
                        
                        if (confirm.equalsIgnoreCase("Y")) {
                            boolean isDeleted = studentService.deleteStudentById(deleteId);
                            if (isDeleted) {
                                System.out.println("Success: Student deleted successfully from the database!");
                            } else {
                                System.out.println("Error: Failed to delete student.");
                            }
                        } else {
                            System.out.println("Deletion cancelled. Student is safe!");
                        }
                    } else {
                        System.out.println("Error: No student found with ID " + deleteId);
                    }
                    break;

                case 6:
                    System.out.println("\nExiting Application... Bye!");
                    scanner.close();
                    System.exit(0); 
                    break;

                default:
                    System.out.println("\nInvalid choice! Please select an option between 1 and 6.");
            }
        }
    }
}