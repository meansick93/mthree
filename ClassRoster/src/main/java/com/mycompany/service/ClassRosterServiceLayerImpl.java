/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.ClassRosterAuditDao;
import com.mycompany.dao.ClassRosterDao;
import com.mycompany.dao.ClassRosterPersistanceException;
import com.mycompany.dto.Student;
import java.util.List;

/**
 *
 * @author minsikkim
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer{
    
    ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao){
        this.dao = dao;
        this.auditDao = auditDao;
    }
    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistanceException {
        if (dao.getStudent(student.getStudentID()) != null){
            throw new ClassRosterDuplicateIdException ("Error: Could not create student. Student id "+student.getStudentID()+ " already exists!");
        }
        
        validateStudentData(student);
        dao.addStudent(student.getStudentID(), student);
        auditDao.writeAuditEntry("Student "+student.getStudentID()+" created.");
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistanceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(int studentId) throws ClassRosterPersistanceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(int studentId) throws ClassRosterPersistanceException {
        Student removedStudent = dao.removeStudent(studentId);
        auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
        return removedStudent;
    }
    
    private void validateStudentData(Student student) throws
        ClassRosterDataValidationException {

    if (student.getFirstName() == null
            || student.getFirstName().trim().length() == 0
            || student.getLastName() == null
            || student.getLastName().trim().length() == 0
            || student.getCohort() == null
            || student.getCohort().trim().length() == 0) {

        throw new ClassRosterDataValidationException(
                "ERROR: All fields [First Name, Last Name, Cohort] are required.");
    }
}
    
}
