public class Main {
    public static void main(String[] args) {
        Student s = new Student("abc123", "John Doe");
        s.addGrade(95);
        s.addGrade(87.5);
        s.addGrade("Ninety"); // Esto debe lanzar error de tipo
        s.removeGradeByIndex(10); // Error índice fuera de rango
        s.report();
    }
}