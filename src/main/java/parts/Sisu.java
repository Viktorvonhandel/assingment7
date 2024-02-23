package parts;
import java.util.ArrayList;

public class Sisu {
    private String university;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private ArrayList<Enrollment> enrollments;

    public Sisu(String university) {
        this.university = university;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.enrollments = new ArrayList<>();
    }
    public void addUniversity(String university) {
        this.university = university;
    }

   
    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course getCourse(int index) {
        if (index >= 0 && index < courses.size()) {
            return courses.get(index);
        } else {
            return null;
        }
    }


    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void listCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudent(int index) {
        if (index >= 0 && index < students.size()) {
            return students.get(index);
        } else {
            return null;
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void listStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public ArrayList<Enrollment> getAllGrades() {
        return enrollments;
    }

    public void enrollStudent(Student student, Course course) {
        Enrollment enrollment = new Enrollment(student, course);
        enrollments.add(enrollment);
    }

    public ArrayList<Enrollment> getEnrollments(Course course) {
        ArrayList<Enrollment> courseEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse().equals(course)) {
                courseEnrollments.add(enrollment);
            }
        }
        return courseEnrollments;
    }

    public ArrayList<Enrollment> getEnrollments(Student student) {
        ArrayList<Enrollment> studentEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().equals(student)) {
                studentEnrollments.add(enrollment);
            }
        }
        return studentEnrollments;
    }
    
    public void gradeCourse(Student student, Course course, int grade) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().equals(student) && enrollment.getCourse().equals(course)) {
                enrollment.setGrade(grade);
                return;
            }
        }
        System.out.println("Opiskelijaa ei löytynyt tai hän ei ole ilmoittautunut kurssille.");
    }
}
