import java.util.InputMismatchException;
import java.util.Scanner;

class NombreProductoLengthException extends Exception {
    public NombreProductoLengthException(String message) {
        super(message);
    }
}
class IndiceInvalidoException extends Exception {
    public IndiceInvalidoException(String mensaje) {
        super(mensaje);
    }
}
class CantidadProductoInvalidaException extends Exception {
    public CantidadProductoInvalidaException(String mensaje) {
        super(mensaje);
    }
}

public class Producto {

    public int cantidadProductos;
    public String[] nombres;
    public int[] cantidades;
    public Float[] precios;

    public Producto() {
    }

    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de productos: ");
        cantidadProductos = scanner.nextInt();
        scanner.nextLine();

        nombres = new String[cantidadProductos];
        cantidades = new int[cantidadProductos];
        precios = new Float[cantidadProductos];

        for (int i = 0; i < cantidadProductos; i++) {
            boolean nombreIngresadoCorrectamente = false;
            do {
                try {
                    System.out.print("Ingrese el nombre del producto #" + (i + 1) + ": ");
                    nombres[i] = scanner.nextLine();
                    validarNombreProducto(nombres[i]);
                    nombreIngresadoCorrectamente = true;
                } catch (NombreProductoLengthException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } while (!nombreIngresadoCorrectamente);

            boolean cantidadIngresadaCorrectamente = false;
            do {
                try {
                    System.out.print("Ingrese la cantidad del producto #" + (i + 1) + ": ");
                   cantidades[i]  = scanner.nextInt();
                    validarCantidadProducto(cantidades[i]);
                    cantidadIngresadaCorrectamente = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: La cantidad debe ser un número entero.");
                    scanner.nextLine();
                } catch (CantidadProductoInvalidaException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } while (!cantidadIngresadaCorrectamente);

            System.out.print("Ingrese el precio del producto #" + (i + 1) + ": ");
            precios[i] = scanner.nextFloat();
            scanner.nextLine();
        }
    }

    private void validarNombreProducto(String nombre) throws NombreProductoLengthException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new NombreProductoLengthException("El nombre del producto no puede estar vacío.");
        }
    }

    public void validarCantidadProducto(int cantidad) throws CantidadProductoInvalidaException {
        if (cantidad <= 0) {
            throw new CantidadProductoInvalidaException("La cantidad del producto debe ser mayor a 0.");
        }
    }


    public void imprimirInformacionProductos() {
        System.out.println("\nInformación de los productos ingresados:");
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println("\nProducto #" + (i + 1));
            System.out.println("Nombre del producto: " + nombres[i]);
            System.out.println("Cantidad: " + cantidades[i]);
            System.out.println("Precio: " + precios[i]);
            calcularTotal(i);
        }
    }

    public void calcularTotal(int indice) {
        float valorTotal = precios[indice]*cantidades[indice];
        System.out.println("Valor Total: " + valorTotal);

    }


    public void buscarProductoPorIndice() {
        Scanner scanner = new Scanner(System.in);
        boolean indiceValido = false;

        do {
            try {
                System.out.print("Ingrese el índice del producto a buscar: ");
                int indiceBuscado = scanner.nextInt();
                validarIndice(indiceBuscado);
                System.out.println("\nProducto encontrado:");
                System.out.println("\nProducto #" + indiceBuscado);
                imprimirInformacionProducto(indiceBuscado - 1);
                indiceValido = true;
            } catch (InputMismatchException | IndiceInvalidoException e) {
                scanner.nextLine();
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, ingrese un índice válido.");
            }
        } while (!indiceValido);
    }


    private void imprimirInformacionProducto(int indice) {
        System.out.println("Nombre del producto: " + nombres[indice]);
        System.out.println("Cantidad: " + cantidades[indice]);
        System.out.println("Precio: " + precios[indice]);
        float valorTotal = precios[indice]*cantidades[indice];
        System.out.println("Valor Total: " + valorTotal);
    }

    private void validarIndice(int indice) throws IndiceInvalidoException {
        if (indice < 1 || indice > cantidadProductos) {
            throw new IndiceInvalidoException("Índice fuera de rango.");
        }
    }

    private boolean indiceValido(int indice) {
        return indice >= 1 && indice <= cantidadProductos;
    }



    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public String[] getNombres() {
        return nombres;
    }

    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    public int[] getCantidades() {
        return cantidades;
    }

    public void setCantidades(int[] cantidades) {
        this.cantidades = cantidades;
    }

    public Float[] getPrecios() {
        return precios;
    }

    public void setPrecios(Float[] precios) {
        this.precios = precios;
    }


}
