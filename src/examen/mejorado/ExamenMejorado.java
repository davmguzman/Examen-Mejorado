package examen.mejorado;

import java.util.Scanner;

public class ExamenMejorado {

    static final int MAX_VENTAS = 10; // Máximo número de ventas
    static int[] factura = new int[MAX_VENTAS];
    static int[] cedula = new int[MAX_VENTAS];
    static String[] nombre = new String[MAX_VENTAS];
    static int[] localidad = new int[MAX_VENTAS];
    static int[] cantidad = new int[MAX_VENTAS];
    static int[] subtotal = new int[MAX_VENTAS];
    static int[] cargosServicios = new int[MAX_VENTAS];
    static int[] total = new int[MAX_VENTAS];
    static int[] precio = new int[MAX_VENTAS];
    static Scanner scanner = new Scanner(System.in);
    static int numVentas = 0;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        byte opcion;
        do {
            opcion = 0;
            System.out.println("Bienvenidos a la pagina de la Federacion Costaricense de Futbol");
            System.out.println("                                                     ");
            System.out.println("Entradas para el partido del 5 de Noviembre del 2018");
            System.out.println("                                                                        ");
            System.out.println("1-Ingrese su Compra");
            System.out.println("2-Inicializar vectores");
            System.out.println("3-Estadisticas");
            System.out.println("4-Salir");
            System.out.println("Digite una opcion");
            opcion = scanner.nextByte();
            switch (opcion) {
                case 1:
                    ingresarVenta();
                    break;
                case 2:
                    //inicializarArreglos();
                    break;
                case 3:
                    //mostrarEstadisticas();
                    break;

                default:
                    System.out.println("Gracias por su compra");

            }
        } while (opcion != 4);

    }

    public static void ingresarVenta() {
        String continuar = "n";

        do {
            if (numVentas == MAX_VENTAS) {
                System.out.println("No se pueden ingresar más ventas");
                return;
            }
            System.out.println("Ingrese número de factura:");
            factura[numVentas] = scanner.nextInt();
            System.out.println("Ingrese cédula del comprador:");
            cedula[numVentas] = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            System.out.println("Ingrese nombre del comprador:");
            nombre[numVentas] = scanner.nextLine();
            System.out.println("Ingrese localidad (1. Sol Norte/Sur, 2. Sombra Este/Oeste, 3. Preferencial):");
            localidad[numVentas] = scanner.nextInt() - 1;
            if (localidad[numVentas] < 0 || localidad[numVentas] > 2) {
                System.out.println("Localidad inválida");
                continue;
            }
            System.out.println("Ingrese cantidad de entradas:");
            cantidad[numVentas] = scanner.nextInt();
            if (cantidad[numVentas] < 1 || cantidad[numVentas] > 4) {
                System.out.println("Cantidad inválida");
                continue;
            }
            switch (localidad[numVentas]) {
                case 0:
                    precio[numVentas] = 10500;
                    break;
                case 1:
                    precio[numVentas] = 20500;
                    break;
                case 2:
                    precio[numVentas] = 25500;
                    break;
                default:
                    precio[numVentas] = 0;
                    break;
            }
            subtotal[numVentas] = cantidad[numVentas] * precio[numVentas];
            cargosServicios[numVentas] = cantidad[numVentas] * 1000;
            total[numVentas] = subtotal[numVentas] + cargosServicios[numVentas];
            numVentas++;
            System.out.println("¿Desea ingresar otra venta? (s/n)");
            continuar = scanner.next();
            scanner.nextLine(); // Consumir salto de línea
        } while (continuar.equalsIgnoreCase("s"));
        while (continuar.equalsIgnoreCase("s"));

    // Desglose de los datos ingresados y los costos de la compra
    System.out.println("\nDesglose de las ventas:\n");
    for (int i = 0; i < numVentas; i++) {
        System.out.println("Factura: " + factura[i]);
        System.out.println("Cédula: " + cedula[i]);
        System.out.println("Nombre: " + nombre[i]);
        System.out.println("Localidad: " + (localidad[i] + 1));
        System.out.println("Precio: " + precio[i]);
        System.out.println("Cantidad: " + cantidad[i]);
        System.out.println("Subtotal: " + subtotal[i]);
        System.out.println("Cargos de servicios: " + cargosServicios[i]);
        System.out.println("Total: " + total[i] + "\n");
    }
    }
}
