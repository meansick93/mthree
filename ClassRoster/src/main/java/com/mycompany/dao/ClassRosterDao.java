/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Student;
import java.util.List;

/**
 *
 * @author minsikkim
 */
public interface ClassRosterDao {
    Student addStudent(int studentID, Student student) throws ClassRosterPersistanceException;
    List<Student> getAllStudents()throws ClassRosterPersistanceException;
    Student getStudent(int studentID);
    Student removeStudent(int studentID)throws ClassRosterPersistanceException;
}
