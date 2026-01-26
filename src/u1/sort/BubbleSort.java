package u1.sort;
import java.util.Random;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int[] arr_copy = arr.clone();

        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n-1; i++) {
            swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        System.out.println("\033[H\033[2J"); // limpiar pantalla        
        int min = 11;
        int max = 20;
        Long seed = 42L;
        int size = 10;
        Random rand = new Random(seed);  // Random wituout seed:   Random rand = new Random();

        int aleatorio =  (int) (rand.nextDouble() * ((max - min) + 1)) + min;
        System.out.println("Numero aleatorio: " + aleatorio);

        //aleatorio = (int) (Math.random() * ((max - min) + 1)) + min;
        //System.out.println("Numero aleatorio: " + aleatorio);

        //int[] my_array = {64, 34, 25, 12, 22, 11, 90};
        int[] my_array = new int[size];

        // generar un arreglo aleario de 1000 elementos entre min y max
        for (int i = 0; i < my_array.length; i++) {
            my_array[i] = rand.nextInt((max - min) + 1) + min;
        }

        int n = my_array.length;
        // Medir tiempo de ejecución en milisegundos
        long startTime = System.currentTimeMillis();
        bubbleSort(my_array);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Tiempo de ejecución: " + duration + " milisegundos");

        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(my_array[i] + " ");
        }
        System.out.println();
    }
}
