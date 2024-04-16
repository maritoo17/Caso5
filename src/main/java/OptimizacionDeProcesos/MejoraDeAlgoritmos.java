package OptimizacionDeProcesos;

public class MejoraDeAlgoritmos implements Ordenamiento {

    @Override
    public void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int left, int right) {
        if (left + 10 <= right) {
            int pivot = medianOfThree(arr, left, right);
            int i = left, j = right - 1;
            while (true) {
                while (arr[++i] < pivot) {}
                while (arr[--j] > pivot) {}
                if (i < j) {
                    swap(arr, i, j);
                } else {
                    break;
                }
            }
            swap(arr, i, right - 1);

            quicksort(arr, left, i - 1);
            quicksort(arr, i + 1, right);
        } else {
            insertionSort(arr, left, right);
        }
    }

    private int medianOfThree(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[left] > arr[center]) swap(arr, left, center);
        if (arr[left] > arr[right]) swap(arr, left, right);
        if (arr[center] > arr[right]) swap(arr, center, right);

        swap(arr, center, right - 1);
        return arr[right - 1];
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j > left && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println("Este programa mejora el rendimiento de algoritmos de ordenamiento mediante la combinación de quicksort con sort de inserción para optimizar el ordenamiento de arreglos pequeños.");
        Ordenamiento sorter = new MejoraDeAlgoritmos();
        int[] arr = { 34, 8, 64, 51, 32, 21 };
        sorter.sort(arr);
        System.out.print("Arreglo ordenado: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
