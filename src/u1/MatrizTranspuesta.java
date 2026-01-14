package u1;
import static mat.Fn.*;

import mat.Fn;

public class MatrizTranspuesta {
    public static void main(String[] args) {
        // Entrada de datos
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] transpuesta = Fn.transponerMatriz(matriz);

        // Salida de datos
        System.out.println("Matriz Original:");
        Fn.imprimirMatriz(matriz);
   
        System.out.println("\nMatriz Transpuesta:");
        imprimirMatriz(transpuesta);
    }
}
