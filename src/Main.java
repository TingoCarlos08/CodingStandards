public class Main {
    public static void main(String[] args) {
        try {
            Student s = new Student("abc123", "John Doe");
            s.addGrade(95);
            s.addGrade(87.5);

            // s.addGrade("Ninety"); // Esto lanzará excepción, comentar para evitar error

            // Prueba eliminación con índice válido y luego inválido
            s.removeGradeByIndex(1); // elimina 87.5
            // s.removeGradeByIndex(10); // Lanzará excepción, comentar para evitar error

            s.report();

        } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}