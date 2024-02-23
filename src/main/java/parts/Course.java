package parts;

public class Course {
    private int maxNumberOfStudents;
    private String name;
    private String code; // Lisätty kurssikoodi

    public Course(String name, String code, int maxNumberOfStudents) { // Lisätty kurssikoodi
        this.name = name;
        this.code = code; // Lisätty kurssikoodi
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public String getName() {
        return name;
    }

    public String getCode() { // Lisätty kurssikoodi
        return code; // Lisätty kurssikoodi
    }


    @Override
    public String toString() {
        return "Course: " + name + ", Code: " + code; // Muutettu tulostusformaatti
    }
}
