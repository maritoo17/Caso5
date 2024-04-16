import AnalisisGenomico.*;
import AnalisisNumerico.*;
import InformacionGenetica.*;
import OptimizacionDeProcesos.*;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Generar combinaciones genéticas");
            System.out.println("2. Contar genes");
            System.out.println("3. Calcular potencias y encontrar máximos");
            System.out.println("4. Sumar naturales y listar números");
            System.out.println("5. Búsqueda de palabras");
            System.out.println("6. Gestión de fechas");
            System.out.println("7. Ordenar documentos");
            System.out.println("8. Ordenamiento de algoritmos");
            System.out.println("9. Salir");
            System.out.print("Ingrese su elección: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CombinacionesGeneticas.main(args);
                    break;
                case 2:
                    ConteoDeGenes.main(args, scanner);
                    break;
                case 3:
                    PotenciasYMaximos.main(args);
                    break;
                case 4:
                    SumatoriaYListado.main(args);
                    break;
                case 5:
                    BusquedaEficiente.main(args);
                    break;
                case 6:
                    GestionDeFechas.main(args);
                    break;
                case 7:
                    OrganizacionDeDocumentos.main(args);
                    break;
                case 8:
                    MejoraDeAlgoritmos.main(args);
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
