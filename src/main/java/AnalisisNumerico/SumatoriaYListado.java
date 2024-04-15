package AnalisisNumerico;

import java.util.ArrayList;
import java.util.List;

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
        OperacionesNumericas operations = new SumatoriaYListado();
        int n = 10;
        int resultadoSuma = operations.sumaNaturales(n);
        System.out.println("La suma de los primeros " + n + " números naturales es: " + resultadoSuma);

        int inicio = 1;
        int fin = 10;
        List<Integer> listaNumeros = operations.listarNumeros(inicio, fin);
        System.out.println("Listado de números del " + inicio + " al " + fin + ": " + listaNumeros);
    }
}
