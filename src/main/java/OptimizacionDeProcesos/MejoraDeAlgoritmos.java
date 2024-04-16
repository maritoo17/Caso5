package OptimizacionDeProcesos;

import java.util.Random;
import java.util.Scanner;

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

    private static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Este programa mejora el rendimiento de algoritmos de ordenamiento.");
        System.out.print("Elija 1 para ingresar manualmente el arreglo o 2 para generar uno aleatoriamente: ");
        int choice = scanner.nextInt();
        int[] arr;

        if (choice == 1) {
            System.out.print("Ingrese la cantidad de elementos en el arreglo: ");
            int size = scanner.nextInt();
            arr = new int[size];
            System.out.println("Ingrese los elementos del arreglo:");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }
        } else {
            System.out.print("Ingrese el tamaño del arreglo aleatorio: ");
            int size = scanner.nextInt();
            System.out.print("Ingrese el límite superior para los valores aleatorios: ");
            int bound = scanner.nextInt();
            arr = generateRandomArray(size, bound);
            System.out.print("Arreglo generado aleatoriamente: ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        Ordenamiento sorter = new MejoraDeAlgoritmos();
        sorter.sort(arr);
        System.out.print("Arreglo ordenado: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
