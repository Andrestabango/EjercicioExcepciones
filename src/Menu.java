import java.util.Scanner;

public class Menu {
        Scanner scanner = new Scanner(System.in);
        Producto producto = new Producto();
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("[1] Ingresar datos del producto");
            System.out.println("[2] Imprimir información del producto");
            System.out.println("[3] Buscar producto por índice");
            System.out.println("[0] Salir");
            System.out.print("Ingrese la opción deseada: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    producto.ingresarDatos();
                    System.out.println("****************************");
                    break;
                case 2:
                    producto.imprimirInformacionProductos();
                    System.out.println("****************************");
                    break;
                case 3:
                    producto.buscarProductoPorIndice();
                    System.out.println("****************************");
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
}
