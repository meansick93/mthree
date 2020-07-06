/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view;

import com.mycompany.dto.Student;
import java.util.List;

/**
 *
 * @author minsikkim
 */
public class ClassRosterView {

    UserIO io;

    public ClassRosterView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Student IDs");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public Student getStudentInfo() {
        io.print("Enter Student Info");
        String firstName = io.readString("Enter Fist Name:");
        String lastName = io.readString("Enter Last Name");
        int studentID = io.readInt("Enter Student ID:");
        String cohort = io.readString("Enter Cohort");

        return new Student(firstName, lastName, studentID, cohort);
    }

    public void printThanksMessage() {
        io.print("Thanks for using!");
    }

    public void printInvalidMenuSelectionMessage() {
        io.print("Please Select a valid menu!");
    }

    public void printByeMessage() {
        io.print("GoodBye!!");
    }

    public void displayError(String message) {
        io.print(message);
    }

    public void successMessage(String message) {
        io.print("Success!! on : " + message);
    }

    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }

    public void displayCreateSuccessBanner() {
        io.print(
                "Student successfully created.");
    }

    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            displayStudent(currentStudent);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }

    public void displayDisplayStudentBanner() {
        io.print("=== Display Student ===");
    }

    public Integer getStudentIdChoice() {
        return io.readInt("Please enter the Student ID.");
    }

    public void displayStudent(Student student) {
        if (student != null) {
            String studentInfo = String.format("#%s : %s %s",
                    student.getStudentID(),
                    student.getFirstName(),
                    student.getLastName());
            io.print(studentInfo);
        } else {
            io.print("No such student.");
        }
    }

    public void displayRemoveStudentBanner() {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveResult(Student studentRecord) {
        if (studentRecord != null) {
            io.print("Student successfully removed.");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }
}
