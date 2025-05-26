import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Double> grades;
    private boolean honor;
    private String passStatus;

    public Student(String id, String name) {
        if(id == null || id.isEmpty() || name == null || name.isEmpty()){
            throw new IllegalArgumentException("ID and Name cannot be empty.");
        }
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
        this.honor = false;
        this.passStatus = "Unknown";
    }

    public void addGrade(Object grade) {
        if (grade instanceof Number) {
            double g = ((Number) grade).doubleValue();
            if (g >= 0 && g <= 100) {
                grades.add(g);
            } else {
                System.out.println("Error: Grade must be between 0 and 100.");
            }
        } else {
            System.out.println("Error: Grade must be a numeric value.");
        }
    }

    public double average() {
        if (grades.isEmpty()) return 0;
        double total = 0;
        for (double g : grades) {
            total += g;
        }
        return total / grades.size();
    }

    public String letterGrade() {
        double avg = average();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    public void checkHonorStatus() {
        honor = average() >= 90;
    }

    public void checkPassFail() {
        passStatus = average() >= 60 ? "Passed" : "Failed";
    }

    public void removeGradeByIndex(int index) {
        if (index >= 0 && index < grades.size()) {
            grades.remove(index);
        } else {
            System.out.println("Error: Index out of range.");
        }
    }

    public void removeGradeByValue(double value) {
        if (!grades.remove(value)) {
            System.out.println("Error: Grade value not found.");
        }
    }

    public void report() {
        checkHonorStatus();
        checkPassFail();
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Number of grades: " + grades.size());
        System.out.printf("Average: %.2f%n", average());
        System.out.println("Letter Grade: " + letterGrade());
        System.out.println("Pass/Fail: " + passStatus);
        System.out.println("Honor Roll: " + (honor ? "Yes" : "No"));
    }
}