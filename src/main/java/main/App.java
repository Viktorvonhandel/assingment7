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
        System.out.println("Tervetuloa Gifu-järjestelmään.\nMille yliopistolle haluat ottaa järjestelmän käyttöön?");
        String university = scanner.nextLine();
        sisu.addUniversity(university);
        

        int choice;
        do {
            
            System.out.println("1) Luo uusi kurssi, 2) Luo uusi opiskelija, 3) Listaa kurssit, 4) Listaa opiskelijat, 5) Lisää opiskelija kurssille, 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, 8) Listaa opiskelijan arvosanat, 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");
            choice = scanner.nextInt();
            scanner.nextLine(); // Tyhjentää puskurin
            switch (choice) {
                case 1:
                    // Luo uusi kurssi
                    System.out.println("Anna kurssin nimi:");
                    String courseName = scanner.nextLine();
                    System.out.println("Anna kurssin ID:");
                    String courseCode = scanner.nextLine();
                    System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                    int coursemaxNumberOfStudents = scanner.nextInt();
                    sisu.addCourse(new Course(courseName, courseCode, coursemaxNumberOfStudents));
                    break;
                case 2:
                    // Luo uusi opiskelija
                    System.out.println("Anna opiskelijan nimi:");
                    String studentName = scanner.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentId = scanner.nextLine();
                    sisu.addStudent(new Student(studentName, studentId));
                    break;
                case 3:
                    // Listaa kurssit
                    ArrayList<Course> courses = sisu.getCourses();
                    for (Course course : courses) {
                        System.out.println(course.getCode()+" "+ course.getName());
                    }
                    break;
                case 4:
                    // Listaa opiskelijat
                    ArrayList<Student> students = sisu.getStudents();
                    for (Student student : students) {
                        System.out.println(student.getName() + " (" + student.getId() + ")");
                    }
                    break;
                case 5:
                    // Lisää opiskelija kurssille
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentIdToAdd = scanner.nextLine();
                    System.out.println("Anna kurssin koodi:");
                    String courseCodeToAdd = scanner.nextLine();
                    sisu.enrollStudent(sisu.getStudent(studentIdToAdd), sisu.getCourse(courseCodeToAdd));
                    break;
                case 6:
                    // Anna kurssiarvosanat
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentIdForGrade = scanner.nextLine();
                    System.out.println("Anna kurssin koodi:");
                    String courseCodeForGrade = scanner.nextLine();
                    System.out.println("Anna arvosana:");
                    int grade = scanner.nextInt();
                    scanner.nextLine(); // Tyhjentää puskurin
                    sisu.gradeCourse(sisu.getStudent(studentIdForGrade), sisu.getCourse(courseCodeForGrade), grade);
                    break;
                case 7:
                    // Listaa kurssilla olevat opiskelijat
                    System.out.println("Anna kurssin koodi:");
                    String courseCodeToDisplayStudents = scanner.nextLine();
                    ArrayList<Student> enrolledStudents = sisu.getStudents();
                    for (Student student : enrolledStudents) {
                        System.out.println(student.getName() + " (" + student.getId() + ")");
                    }
                    break;
                case 8:
                    // Listaa opiskelijan arvosanat
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentIdForGrades = scanner.nextLine();
                    ArrayList<Enrollment> studentGrades = sisu.getEnrollments(sisu.getStudent(studentIdForGrades));
                    for (Enrollment enrollment : studentGrades) {
                        System.out.println("Kurssi: " + enrollment.getCourse().getName() + ", Arvosana: " + enrollment.getGrade());
                    }
                    break;
                case 9:
                    // Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat
                    ArrayList<Enrollment> allGrades = sisu.getAllGrades();
                    for (Enrollment enrollment : allGrades) {
                        System.out.println("Opiskelija: " + enrollment.getStudent().getName() + ", Kurssi: " + enrollment.getCourse().getName() + ", Arvosana: " + enrollment.getGrade());
                    }
                    break;
                case 0:
                    scanner.close();
                    System.out.println("Kiitos ohjelman käytöstä.");
                    break;
                default:
                    System.out.println("Virheellinen valinta.");
            }
        } while (choice != 0);
        
    }
}

