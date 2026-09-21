import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Clase ejecutable para automatizar y gestionar la toma de pedidos de clientes.
 * Permite realizar diferentes operaciones: agregar productos (por
 * unidad/cantidad),
 * quitar productos, consultar totales y emitir el detalle completo del pedido.
 */
public class TomaPedido {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // 1. Instanciación de Laboratorios (proveedores de productos)
        Laboratorio lab1 = new Laboratorio("TechCorp", "Av. Corrientes 1234", "011-4567-8900");
        Laboratorio lab2 = new Laboratorio("Editorial Alfa", "San Martín 456", "011-4321-7654");

        // 2. Creación de un catálogo inicial de productos disponibles para elegir
        ArrayList<Producto> catalogo = new ArrayList<>();
        catalogo.add(new Producto(101, "Pendrive 64GB", 9693.75, lab1, 5, "Computación"));
        catalogo.add(new Producto(102, "Libro-POO", 9330.36, lab2, 2, "Librería"));
        catalogo.add(new Producto(103, "Revista-user", 5205.36, lab2, 10, "Kiosco"));
        catalogo.add(new Producto(104, "Mouse Óptico", 4500.00, lab1, 8, "Computación"));

        // 3. Creación del Cliente (TP2 Ejercicio 4)
        Cliente cliente = new Cliente(44542230, "Gómez", "Juan", 50000.0);

        // 4. Creación del Pedido inicial con la fecha actual y un producto inicial
        // obligatorio
        Calendar fecha = Calendar.getInstance();
        Pedido miPedido = new Pedido(fecha, cliente, catalogo.get(0));

        // Agregamos un segundo producto para simular el pedido inicial
        miPedido.agregarProducto(catalogo.get(1));

        System.out.println("==========================================================");
        System.out.println("        SISTEMA DE TOMA DE PEDIDOS - EMPRESA");
        System.out.println("==========================================================");
        System.out.println("Cliente: " + cliente.nomYAp() + " (DNI: " + cliente.getNroDNi() + ")");
        System.out.println("Pedido iniciado con 2 productos del catálogo.");

        int opcion = 0;
        do {
            System.out.println("\n----------------- MENÚ DE OPERACIONES -----------------");
            System.out.println("1. Agregar producto desde el catálogo");
            System.out.println("2. Crear y agregar un nuevo producto manual");
            System.out.println("3. Quitar un producto del pedido");
            System.out.println("4. Consultar totales (Contado y Financiado)");
            System.out.println("5. Emitir detalle completo del pedido");
            System.out.println("6. Ver información del cliente");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            if (!teclado.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                teclado.nextLine();
                continue;
            }

            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("\n--- Catálogo de Productos Disponibles ---");
                    for (int i = 0; i < catalogo.size(); i++) {
                        Producto p = catalogo.get(i);
                        System.out.printf("%d. %-18s | P. Lista: $%-9.2f | P. Contado: $%-9.2f%n",
                                (i + 1), p.getDescripcion(), p.precioLista(), p.precioContado());
                    }
                    System.out.print("Seleccione el número del producto a agregar: ");
                    int numProd = teclado.nextInt();
                    System.out.print("Ingrese la cantidad de unidades: ");
                    int cantidad = teclado.nextInt();
                    teclado.nextLine();

                    if (numProd >= 1 && numProd <= catalogo.size() && cantidad > 0) {
                        Producto seleccionado = catalogo.get(numProd - 1);
                        // Se trabaja por unidad: se agrega la cantidad de veces solicitada a la lista
                        for (int i = 0; i < cantidad; i++) {
                            miPedido.agregarProducto(seleccionado);
                        }
                        System.out.printf("Se agregaron %d unidad(es) de '%s' al pedido.%n",
                                cantidad, seleccionado.getDescripcion());
                    } else {
                        System.out.println("Opción o cantidad no válida.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Crear Nuevo Producto Manual ---");
                    System.out.print("Ingrese código: ");
                    int codigo = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Ingrese descripción: ");
                    String descripcion = teclado.nextLine();
                    System.out.print("Ingrese rubro: ");
                    String rubro = teclado.nextLine();
                    System.out.print("Ingrese precio de costo: ");
                    double costo = teclado.nextDouble();
                    System.out.print("Ingrese existencia mínima requerida: ");
                    int existMin = teclado.nextInt();
                    System.out.print("Ingrese cantidad de unidades para este pedido: ");
                    int cantNuevo = teclado.nextInt();
                    teclado.nextLine();

                    if (cantNuevo > 0) {
                        Producto nuevoProducto = new Producto(codigo, descripcion, costo, lab1, existMin, rubro);
                        catalogo.add(nuevoProducto);
                        for (int i = 0; i < cantNuevo; i++) {
                            miPedido.agregarProducto(nuevoProducto);
                        }
                        System.out.printf("Producto '%s' creado y agregado (%d unidades) al pedido.%n",
                                descripcion, cantNuevo);
                    } else {
                        System.out.println("La cantidad debe ser mayor a 0.");
                    }
                    break;

                case 3:
                    ArrayList<Producto> prodsEnPedido = miPedido.getProductos();
                    if (prodsEnPedido.isEmpty()) {
                        System.out.println("El pedido no contiene productos para quitar.");
                        break;
                    }
                    System.out.println("\n--- Productos actuales en el Pedido ---");
                    for (int i = 0; i < prodsEnPedido.size(); i++) {
                        Producto p = prodsEnPedido.get(i);
                        System.out.printf("%d. %-18s | P. Contado: $%-9.2f | P. Lista: $%-9.2f%n",
                                (i + 1), p.getDescripcion(), p.precioContado(), p.precioLista());
                    }
                    System.out.print("Seleccione el número del producto a quitar: ");
                    int indiceQuitar = teclado.nextInt() - 1;
                    teclado.nextLine();

                    if (indiceQuitar >= 0 && indiceQuitar < prodsEnPedido.size()) {
                        Producto eliminado = prodsEnPedido.get(indiceQuitar);
                        boolean quitado = miPedido.quitarProducto(eliminado);
                        if (quitado) {
                            System.out.println("Producto '" + eliminado.getDescripcion() + "' quitado del pedido.");
                        } else {
                            System.out.println("No se pudo quitar el producto.");
                        }
                    } else {
                        System.out.println("Índice no válido.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Resumen de Totales del Pedido ---");
                    System.out.printf("Total al Contado:  $%.2f%n", miPedido.totalAlContado());
                    System.out.printf("Total Financiado:  $%.2f%n", miPedido.totalFinanciado());
                    break;

                case 5:
                    System.out.println();
                    miPedido.mostrarPedido();
                    break;

                case 6:
                    System.out.println();
                    miPedido.getCliente().mostrar();
                    break;

                case 7:
                    System.out.println("\nSaliendo del sistema de toma de pedidos...");
                    break;

                default:
                    System.out.println("Opción no válida. Ingrese un número entre 1 y 7.");
                    break;
            }
        } while (opcion != 7);

        teclado.close();
    }
}
