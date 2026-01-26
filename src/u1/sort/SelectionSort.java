package u1.sort;
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        // Crear una copia de arreglo original para no modificarlo
        int[] arr_copy = arr.clone();

        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_index = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            //arr[i], arr[min_idx] = arr[min_idx], arr[i] // Pythonic swap  
            // Swap the found minimum element with the first element
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;

            // Instead of swapping, we shift elements to the right
            // int min_value = arr[min_index];
            // for (int k = min_index; k > i; k--) {
            //     arr[k] = arr[k-1];
            // }
            // arr[i] = min_value;
        }
    }

    public static void main(String[] args) {
        int[] my_array = {64, 34, 25, 5, 22, 11, 90, 12};
        int n = my_array.length;
        selectionSort(my_array);

        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(my_array[i] + " ");
        }
        System.out.println();
    }
}

