package u1;

public class MatrizTranspuesta {
    public static void main(String[] args) {
        // Entrada de datos
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int F = matriz.length;
        int C = matriz[0].length;

        // Proceso: calcular la transpuesta
        int[][] transpuesta = new int[C][F];  
        for (int i = 0; i < F; i++) {
            for (int j = 0; j < C; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }

        // Salida de datos
        System.out.println("Matriz Original:");
        for (int i = 0; i < F; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatriz Transpuesta:");
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < F; j++) {
                System.out.print(transpuesta[i][j] + " ");
            }
            System.out.println();
        }

    }
}
