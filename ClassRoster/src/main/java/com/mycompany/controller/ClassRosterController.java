/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.ClassRosterDao;
import com.mycompany.dao.ClassRosterPersistanceException;
import com.mycompany.dto.Student;
import com.mycompany.service.ClassRosterDataValidationException;
import com.mycompany.service.ClassRosterDuplicateIdException;
import com.mycompany.service.ClassRosterServiceLayer;
import com.mycompany.view.ClassRosterView;
import java.util.List;

/**
 *
 * @author minsikkim
 */
public class ClassRosterController {

    private ClassRosterServiceLayer service;
    private ClassRosterView view;

    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        int studentId;
        while (keepGoing) {

            menuSelection = view.printMenuAndGetSelection();
            try {
                switch (menuSelection) {
                    case 1://List Students IDs
                        view.displayDisplayAllBanner();
                        List<Student> studentList = service.getAllStudents();
                        view.displayStudentList(studentList);
                        break;
                    case 2: // lCreate New Student
                        view.displayCreateStudentBanner();
                        boolean hasErrors = false;
                        do{
                            Student currentStudent = view.getStudentInfo();
                            try{
                                service.createStudent(currentStudent);
                                view.displayCreateSuccessBanner();
                                hasErrors = false;
                            }catch(ClassRosterDuplicateIdException | ClassRosterDataValidationException e){
                                hasErrors = true;
                                view.displayError(e.getMessage());
                            }
                            
                        }while(hasErrors);
                        break;
                    case 3://View a Student
                        view.displayDisplayStudentBanner();
                        studentId = view.getStudentIdChoice();
                        Student student = service.getStudent(studentId);
                        view.displayStudent(student);
                        break;
                    case 4: //Remove a Student
                        view.displayRemoveStudentBanner();
                        studentId = view.getStudentIdChoice();
                        Student removedStudent = service.removeStudent(studentId);
                        view.displayRemoveResult(removedStudent);
                        break;
                    case 5://Exit
                        view.printThanksMessage();
                        keepGoing = false;
                        break;
                    default:
                        view.printInvalidMenuSelectionMessage();
                }
            } catch (ClassRosterPersistanceException ex) {
                view.displayError(ex.getMessage());
            }
        }
        view.printByeMessage();
    }
}
