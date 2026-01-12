package mat;

public class Fn {

    // Metodo de impresion de matrices
    public static void imprimirMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] transponerMatriz(int[][] matriz) {
        int F = matriz.length;
        int C = matriz[0].length;
        int[][] transpuesta = new int[C][F];

        for (int i = 0; i < F; i++) {
            for (int j = 0; j < C; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }

    public static void main(String[] args) {
        System.out.println("Clase de funciones ");
    }

}

