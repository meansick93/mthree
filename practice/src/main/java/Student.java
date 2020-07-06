/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author minsikkim
 */
public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String cohort; // Java or .NET + cohort month/year
    UserIOImpl userIO = new UserIOImpl();

    public Student(String studentId) {
        this.studentId = studentId;
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

    public String getStudentID() {
        return studentId;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }   
    public void print(){
        String temp = "Student name : "+this.firstName+" "+this.lastName+" with STD ID : "+this.studentId;
        userIO.print(temp);
    }

}