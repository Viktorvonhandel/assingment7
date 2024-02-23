package main;

import parts.Sisu;
import parts.Course;
import parts.Student;
import parts.Enrollment;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Sisu sisu = new Sisu("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tervetuloa Gifu-järjestelmään\nMille yliopistolle haluat ottaa järjestelmän käyttöön?");
        String university = scanner.nextLine();
        sisu.addUniversity(university);
        

        int choice;
        do {
            
            System.out.println("1) Luo uusi kurssi, 2) Luo uusi opiskelija, 3) Listaa kurssit, 4) Listaa opiskelijat, 5) Lisää opiskelija kurssille, 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, 8) Listaa opiskelijan arvosanat, 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");
            choice = scanner.nextInt();
          
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Anna kurssin nimi:");
                    String courseName = scanner.nextLine();
                    System.out.println("Anna kurssin ID:");
                    String courseCode = scanner.nextLine();
                    System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                    int coursemaxNumberOfStudents = scanner.nextInt();
                    sisu.addCourse(new Course(courseName, courseCode, coursemaxNumberOfStudents));
                    scanner.nextLine(); 
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Anna opiskelijan nimi:");
                    String studentName = scanner.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentId = scanner.nextLine();
                    sisu.addStudent(new Student(studentName, studentId));
                    break;
                case 3:
                    
                    ArrayList<Course> courses = sisu.getCourses();
                    for (int i = 0; i < courses.size(); i++) {
                        Course course = courses.get(i);
                        System.out.println(i + ") " + course.getCode() + " " + course.getName());
                    }
                    break;
                case 4:
                   
                    ArrayList<Student> students = sisu.getStudents();
                    for (int i = 0; i < students.size(); i++) {
                        Student student = students.get(i);
                        System.out.println(i + ") " +student.getId() +""+ student.getName());
                       
                    }
                    break;
                    case 5:
                    scanner.nextLine();
                    ArrayList<Course> coursesToAdd = sisu.getCourses();
                    for (int i = 0; i < coursesToAdd.size(); i++) {
                        Course course = coursesToAdd.get(i);
                        System.out.println(i + ") " + course.getCode() + " " + course.getName());
                    }
                    System.out.println("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
                    int courseIndexToAdd = scanner.nextInt();
                    Course selectedCourseToAdd = coursesToAdd.get(courseIndexToAdd);
                    
                    ArrayList<Student> studentsToAdd = sisu.getStudents();
                    for (int i = 0; i < studentsToAdd.size(); i++) {
                        Student student = studentsToAdd.get(i);
                        System.out.println(i + ") " + student.getId() + " " + student.getName());
                    }
                    System.out.println("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero:");
                    int studentIndexToAdd = scanner.nextInt();
                    Student selectedStudentToAdd = studentsToAdd.get(studentIndexToAdd);
                    
                    sisu.enrollStudent(selectedStudentToAdd, selectedCourseToAdd);
                    break;
                case 6:
                    
                    ArrayList<Course> coursesForGrading = sisu.getCourses();
                    for (int i = 0; i < coursesForGrading.size(); i++) {
                        Course course = coursesForGrading.get(i);
                        System.out.println(i + ") " + course.getCode() + " " + course.getName());
                    }
                    System.out.println("Minkä kurssin haluat arvostella? Syötä kurssin numero:");
                    int courseIndexForGrade = scanner.nextInt();
                    scanner.nextLine();
                    Course courseForGrade = coursesForGrading.get(courseIndexForGrade);

                   
                    ArrayList<Enrollment> enrolledStudents = sisu.getEnrollments(courseForGrade);
                    for (int i = 0; i < enrolledStudents.size(); i++) {
                        Enrollment enrollment = enrolledStudents.get(i);
                        Student student = enrollment.getStudent();
                        
                   
                        System.out.println("Anna arvosana opiskelijalle " + student.getId() + " " + student.getName());
                        int grade = scanner.nextInt();
                        scanner.nextLine();
                        
                       
                        sisu.gradeCourse(student, courseForGrade, grade);
                    }
                    break;
                
                case 7:

                    ArrayList<Course> coursesForListing = sisu.getCourses();
                    for (int i = 0; i < coursesForListing.size(); i++) {
                        Course course = coursesForListing.get(i);
                        System.out.println(i + ") " + course.getCode() + " " + course.getName());
                    }
                    
                   
                    System.out.println("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
                    int courseIndexStudentlist = scanner.nextInt();
                    scanner.nextLine();
                    Course selectedCourse = coursesForListing.get(courseIndexStudentlist);
                    
                    
                    ArrayList<Enrollment> enrolledStudents1 = sisu.getEnrollments(selectedCourse);
                    for (int i = 0; i < enrolledStudents1.size(); i++) {
                        Enrollment enrollment = enrolledStudents1.get(i);
                        Student student = enrollment.getStudent();
                        int grade = enrollment.getGrade(); 
                        System.out.println(i + ") " + student.getId() + " " + student.getName() + ", arvosana: " + grade);
                    }
                    break;

                case 8:
                        
                    ArrayList<Student> studentsToGradeList = sisu.getStudents();
                    for (int i = 0; i < studentsToGradeList.size(); i++) {
                        Student student = studentsToGradeList.get(i);
                        System.out.println(i + ") " + student.getId() + " " + student.getName());
                    }
                    System.out.println("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero:");
                    int studentsToGradeIndex = scanner.nextInt();
                    Student selectedStudent = studentsToGradeList.get(studentsToGradeIndex);

                    ArrayList<Enrollment> studentEnrollments = sisu.getEnrollments(selectedStudent); 
                    System.out.println("Opiskelijan " + selectedStudent.getId() + " " + selectedStudent.getName() + " arvosanat:");
                    
                    for (int i = 0; i < studentEnrollments.size(); i++) { 
                        Enrollment enrollment = studentEnrollments.get(i); 
                        Course course = enrollment.getCourse(); 
                        int grade = enrollment.getGrade();
                        

                        System.out.println(course.getCode() + " " + course.getName() + ", arvosana: " + grade);
                    }
                    
                
                    break;
                case 9:
                    
                ArrayList<Enrollment> allGrades = sisu.getAllGrades();
                ArrayList<Course> allCourses = sisu.getCourses();
                
                int index = 0;
                
               
                for (Course course : allCourses) {
                    System.out.println("Kurssi: " + course.getName());
                    while (index < allGrades.size()) {
                        Enrollment enrollment = allGrades.get(index);
                        if (enrollment.getCourse().equals(course)) {
                            System.out.println(enrollment.getStudent().getId() + " " + enrollment.getStudent().getName() + ", Arvosana: " + enrollment.getGrade());
                        } else {
                            break;
                        }
                        index++;
                    }
                }
                
                break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    break;
                default:
                    System.out.println("Virheellinen valinta.");
            }
        } while (choice != 0);
        scanner.close();
    }
}

