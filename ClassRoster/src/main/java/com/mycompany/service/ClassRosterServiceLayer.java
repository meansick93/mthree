/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.ClassRosterPersistanceException;
import com.mycompany.dto.Student;
import java.util.List;

/**
 *
 * @author minsikkim
 */
public interface ClassRosterServiceLayer {

    void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistanceException;

    List<Student> getAllStudents() throws
            ClassRosterPersistanceException;

    Student getStudent(int studentId) throws
            ClassRosterPersistanceException;

    Student removeStudent(int studentId) throws
            ClassRosterPersistanceException;
}
