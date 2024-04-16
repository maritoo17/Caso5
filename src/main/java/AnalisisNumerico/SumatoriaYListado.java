package AnalisisNumerico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumatoriaYListado implements OperacionesNumericas {

    @Override
    public int sumaNaturales(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + sumaNaturales(n - 1);
        }
    }

    @Override
    public List<Integer> listarNumeros(int inicio, int fin) {
        if (inicio > fin) {
            return new ArrayList<>();
        } else {
            List<Integer> lista = listarNumeros(inicio, fin - 1);
            lista.add(fin);
            return lista;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Este programa realiza la suma de los primeros n números naturales y lista números desde 1 hasta n.");
        System.out.print("Por favor, ingrese el número n hasta el cual desea listar y sumar los números naturales: ");
        int n = scanner.nextInt();

        OperacionesNumericas operations = new SumatoriaYListado();
        int resultadoSuma = operations.sumaNaturales(n);
        System.out.println("La suma de los primeros " + n + " números naturales es: " + resultadoSuma);

        List<Integer> listaNumeros = operations.listarNumeros(1, n);
        System.out.println("Listado de números del 1 al " + n + ": " + listaNumeros);

        scanner.close();
    }
}
