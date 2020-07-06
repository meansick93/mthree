/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author minsikkim
 */
public class ClassRosterDaoImpl implements ClassRosterDao {

    private final String FILENAME = "student.txt";
    private final String DELIMITER = "::";

    List<Student> students = new ArrayList<>();

    @Override
    public Student addStudent(int studentID, Student student) throws ClassRosterPersistanceException {

        try {
            readDataFromFile();
        } catch (ClassRosterPersistanceException ex) {

        }
        Student temp = getStudent(studentID);
        if (temp != null) {
            return temp;
        } else {
            students.add(student);
            writeDataToFile();
            return student;
        }
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistanceException {
        readDataFromFile();
        return students;
    }

    @Override
    public Student getStudent(int studentID) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID() == studentID) {
                return students.get(i);
            }
        }
        return null;
    }

    @Override
    public Student removeStudent(int studentID) throws ClassRosterPersistanceException {
        Student ret = null;
        for (int i=0;i<students.size();i++){
            if (students.get(i).getStudentID()==studentID){
                ret = students.remove(i);
                writeDataToFile();
            }
        }
        return ret;
    }

    public void readDataFromFile() throws ClassRosterPersistanceException {
        Scanner sc;
        try {
            sc = new Scanner(new File(FILENAME));
        } catch (FileNotFoundException ex) {
            throw new ClassRosterPersistanceException("Error loading the file!");
        }
        students = new ArrayList<>();

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] splitted = line.split(DELIMITER);
            if (splitted.length == 4) {
                Student temp = new Student();
                temp.setFirstName(splitted[0]);
                temp.setLastName(splitted[1]);
                temp.setStudentID(Integer.parseInt(splitted[2]));
                temp.setCohort(splitted[3]);
                students.add(temp);
            }
        }
        sc.close();

    }

    public void writeDataToFile() throws ClassRosterPersistanceException {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(new File(FILENAME)));
        } catch (IOException ex) {
            throw new ClassRosterPersistanceException("Error Writing to File");
        }

        for (Student student : students) {
            pw.append(student.getFirstName() + DELIMITER
                    + student.getLastName() + DELIMITER
                    + student.getStudentID() + DELIMITER
                    + student.getCohort() + "\n");
        }
        pw.flush();
        pw.close();

    }

}
