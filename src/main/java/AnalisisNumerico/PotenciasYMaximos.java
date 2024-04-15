package AnalisisNumerico;

import java.util.Arrays;
import java.util.List;

public class PotenciasYMaximos implements CalculadoraDeNumeros {

    @Override
    public int calcularPotencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * calcularPotencia(base, exponente - 1);
        }
    }

    @Override
    public int encontrarMaximo(List<Integer> numeros, int indice, int maximoActual) {
        if (indice == numeros.size()) {
            return maximoActual;
        } else {
            if (numeros.get(indice) > maximoActual) {
                maximoActual = numeros.get(indice);
            }
            return encontrarMaximo(numeros, indice + 1, maximoActual);
        }
    }

    public static void main(String[] args) {
        CalculadoraDeNumeros calculator = new PotenciasYMaximos();
        int base = 2;
        int exponente = 5;
        int resultadoPotencia = calculator.calcularPotencia(base, exponente);
        System.out.println(base + "^" + exponente + " = " + resultadoPotencia);

        List<Integer> numeros = Arrays.asList(1, 3, 7, 2, 5);
        int maximo = calculator.encontrarMaximo(numeros, 0, numeros.get(0));
        System.out.println("El valor máximo en la lista es: " + maximo);
    }
}
