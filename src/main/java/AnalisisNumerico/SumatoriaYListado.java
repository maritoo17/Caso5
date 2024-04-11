package AnalisisNumerico;

import java.util.ArrayList;
import java.util.List;

public class SumatoriaYListado {

    public static void main(String[] args) {
        int n = 10;
        int resultadoSuma = sumaNaturales(n);
        System.out.println("La suma de los primeros " + n + " números naturales es: " + resultadoSuma);

        int inicio = 1;
        int fin = 10;
        List<Integer> listaNumeros = listarNumeros(inicio, fin);
        System.out.println("Listado de números del " + inicio + " al " + fin + ": " + listaNumeros);
    }

    public static int sumaNaturales(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + sumaNaturales(n - 1);
        }
    }

    public static List<Integer> listarNumeros(int inicio, int fin) {
        if (inicio > fin) {
            return new ArrayList<>();
        } else {
            List<Integer> lista = listarNumeros(inicio, fin - 1);
            lista.add(fin);
            return lista;
        }
    }
}
