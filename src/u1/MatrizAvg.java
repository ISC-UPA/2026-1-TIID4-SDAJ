package u1;
// Pasar el código de Java a Python

public class MatrizAvg {
    public static void main(String[] args) {
        // entrada de datos
        String[] alumnos = { "Ana", "Carlos", "Marta","Hugo", "Luis"};
        String[] materias = { "Matemáticas", "Física", "Química", "Biología" };
        double[][] calificaciones = {
                { 10, 9, 8, 7 },
                { 9, 7, 6, 8 },
                { 8, 9, 5, 9 },
                { 7, 8, 9, 10 },    
                { 6, 7, 8, 9 }
        };

        // proceso: obtener el promedio de alumnos y materias
        int F = calificaciones.length;    // número de filas        alumnos
        int C = calificaciones[0].length; // número de columnas     materias 

        double[] avgAlumnos = new double[F];
        double[] avgMaterias = new double[C];

        double avgTotal = 0;
        for (int i = 0; i < F; i++) {
            for (int j = 0; j < C; j++) {
                avgAlumnos[i] = avgAlumnos[i] + calificaciones[i][j] / C;
                avgMaterias[j] += calificaciones[i][j] / F;
                avgTotal += calificaciones[i][j] / (F * C);
            }
        }
        // salida de datos
        System.out.printf("%-20s", "Alumnos/Materias");
        for (int i = 0; i < C; i++) {
            System.out.printf("%-15s", materias[i]);
        }

        System.out.printf("%-15s", "Promedio");
        for (int i = 0; i < F; i++) {
            System.out.printf("\n%-20s", alumnos[i]);
            for (int j = 0; j < C; j++) {
                System.out.printf("%-15.2f", calificaciones[i][j]);
            }
            System.out.printf("%-15.2f", avgAlumnos[i]);
        }

        System.out.printf("\n%-20s", "Promedio");
        for (int j = 0; j < C; j++) {
            System.out.printf("%-15.2f", avgMaterias[j]);
        }
        System.out.printf("%-15.2f", avgTotal);

    }
    
}
