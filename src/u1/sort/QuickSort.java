package u1.sort;

public class QuickSort {  // tradicional p183
    // Funcion principal que implementa QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Encuentra el indice de particion
            int pi = partition(arr, low, high);

            // Ordena recursivamente los elementos antes y despues de la particion
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Funcion para encontrar el indice de particion
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivote
        int i = (low - 1); // indice del elemento mas pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivot) {
                i++;

                // intercambia arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // intercambia arr[i+1] y arr[high] (o pivote)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Metodo para imprimir el array
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Metodo principal para probar el algoritmo QuickSort
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        System.out.println("Array original:");
        printArray(arr);

        quickSort(arr, 0, n - 1);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}
