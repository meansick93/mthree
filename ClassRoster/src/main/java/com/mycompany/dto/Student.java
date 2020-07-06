/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

/**
 *
 * @author minsikkim
 */
public class Student {
    private String firstName;
    private String lastName;
    private int studentID;
    private String cohort;
    
    public Student(){
        
    }
    public Student(String firstName, String lastName, int studentID, String cohort){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.cohort = cohort;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }
    
    
}
