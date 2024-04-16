package InformacionGenetica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GestionDeFechas implements OrganizacionDias {
    private List<LocalDate> fechas;
    private DateTimeFormatter formatterEntrada;
    private DateTimeFormatter formatterSalida;

    public GestionDeFechas(String formatoEntrada, String formatoSalida) {
        fechas = new ArrayList<>();
        this.formatterEntrada = DateTimeFormatter.ofPattern(formatoEntrada);
        this.formatterSalida = DateTimeFormatter.ofPattern(formatoSalida);
    }

    @Override
    public void agregarFecha(String fechaTexto) {
        LocalDate fecha = LocalDate.parse(fechaTexto, formatterEntrada);
        fechas.add(fecha);
    }

    @Override
    public void listarFechasOrdenadas() {
        Collections.sort(fechas);
        for (LocalDate fecha : fechas) {
            System.out.println(fecha.format(formatterSalida));
        }
    }

    public static void main(String[] args) {
        System.out.println("Este programa permite al usuario agregar fechas en un formato especificado, organizarlas y mostrarlas ordenadamente en otro formato.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el formato de entrada de las fechas (ej. dd/MM/yyyy): ");
        String formatoEntrada = scanner.nextLine();
        System.out.print("Introduce el formato de salida de las fechas (ej. dd/MM/yyyy): ");
        String formatoSalida = scanner.nextLine();

        OrganizacionDias manager = new GestionDeFechas(formatoEntrada, formatoSalida);

        System.out.println("Gestión de Fechas para Experimentos");
        while (true) {
            System.out.print("Introduce una fecha en el formato especificado o 'salir' para terminar: ");
            String input = scanner.nextLine();
            if ("salir".equalsIgnoreCase(input)) {
                break;
            }
            try {
                manager.agregarFecha(input);
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Por favor, intenta de nuevo.");
            }
        }

        System.out.println("Fechas ordenadas:");
        manager.listarFechasOrdenadas();
    }
}
