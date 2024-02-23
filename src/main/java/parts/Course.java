package parts;

public class Course {
    private int maxNumberOfStudents;
    private String name;
    private String code;

    public Course(String name, String code, int maxNumberOfStudents) { 
        this.name = name;
        this.code = code; 
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public String getName() {
        return name;
    }

    public String getCode() { 
        return code; 
    }


    @Override
    public String toString() {
        return "Course: " + name + ", Code: " + code;
    }
}
