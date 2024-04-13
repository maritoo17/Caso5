package InformacionGenetica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class GestionDeFechas {
    private List<LocalDate> fechas;
    private DateTimeFormatter formatter;

    public GestionDeFechas() {
        fechas = new ArrayList<>();
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }


    public void agregarFecha(LocalDate fecha) {
        fechas.add(fecha);
    }

    public void listarFechasOrdenadas() {
        Collections.sort(fechas);
        for (LocalDate fecha : fechas) {
            System.out.println(formatter.format(fecha));
        }
    }

    public static void main(String[] args) {
        GestionDeFechas manager = new GestionDeFechas();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gestión de Fechas para Experimentos");

        while (true) {
            System.out.print("Introduce una fecha (formato dd-MM-yyyy) o 'salir' para terminar: ");
            String input = scanner.nextLine();
            if ("salir".equalsIgnoreCase(input)) {
                break;
            }
            try {
                LocalDate fecha = LocalDate.parse(input);
                manager.agregarFecha(fecha);
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Por favor, intenta de nuevo.");
            }
        }

        System.out.println("Fechas ordenadas:");
        manager.listarFechasOrdenadas();
        scanner.close();
    }
}
