
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author minsikkim
 */
public class StudentQuizGrades {
    UserIOImpl usrIO = new UserIOImpl();
    private Map<Student, List<Integer>> studentQuiz;
    StudentQuizGrades(){
        this.studentQuiz = new HashMap<Student, List<Integer>>();
    }
    public void viewStudents(){
        System.out.println("List of Students!!");
        System.out.println("");
        for (Student student : this.studentQuiz.keySet()){
            student.print();
        }
    }
    public void addStudent(String name){
        Student temp = new Student(name);
        this.studentQuiz.put(temp, new ArrayList<Integer>());
    }
    public static void main(String[] args) {
        StudentQuizGrades a = new StudentQuizGrades();
        a.addStudent("mark");
        a.addStudent("Kenny");
        a.viewStudents();
    }
}
