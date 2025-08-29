package org.controlpajareria;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Cliente> clientes = new ArrayList<>();
    private static final ArrayList<Pajaro> catalogo = new ArrayList<>();
    private static final ArrayList<Venta> ventas = new ArrayList<>();

    public static void main(String[] args) {
        cargarDatosPrueba();
        mostrarMenu();
    }

    private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Gestión de pájaros");
            System.out.println("3. Realizar venta");
            System.out.println("4. Mostrar ventas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = getIntInput();

            switch (opcion) {
                case 1 -> menuClientes();
                case 2 -> menuPajaros();
                case 3 -> realizarVenta();
                case 4 -> menuVentas();
                case 5 -> System.out.println("Gracias por usar el sistema.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    // --- GESTIÓN DE CLIENTES ---
    private static void menuClientes() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Alta de cliente");
            System.out.println("2. Baja de cliente");
            System.out.println("3. Modificación de cliente");
            System.out.println("4. Búsqueda por DNI");
            System.out.println("5. Listado de clientes");
            System.out.println("6. Volver");
            System.out.print("Seleccione: ");
            opcion = getIntInput();

            switch (opcion) {
                case 1 -> altaCliente();
                case 2 -> bajaCliente();
                case 3 -> modificarCliente();
                case 4 -> buscarClientePorDNI();
                case 5 -> listadoClientes();
                case 6 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void altaCliente() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        if (buscarClientePorDNI(dni, false) != null) {
            System.out.println("Error: Ya existe un cliente con ese DNI.");
            return;
        }
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        clientes.add(new Cliente(nombre, dni, telefono, email));
        System.out.println("Cliente registrado con éxito.");
    }

    private static void bajaCliente() {
        System.out.print("DNI del cliente a eliminar: ");
        String dni = scanner.nextLine();
        Cliente cliente = buscarClientePorDNI(dni, false);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente eliminado.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void modificarCliente() {
        System.out.print("DNI del cliente a modificar: ");
        String dni = scanner.nextLine();
        Cliente cliente = buscarClientePorDNI(dni, false);
        if (cliente == null) return;

        System.out.print("Nuevo nombre (" + cliente.getNombre() + "): ");
        String nombre = scanner.nextLine();
        if (!nombre.trim().isEmpty()) cliente.setNombre(nombre);

        System.out.print("Nuevo teléfono (" + cliente.getTelefono() + "): ");
        String telefono = scanner.nextLine();
        if (!telefono.trim().isEmpty()) cliente.setTelefono(telefono);

        System.out.print("Nuevo email (" + cliente.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.trim().isEmpty()) cliente.setEmail(email);

        System.out.println("Cliente actualizado.");
    }

    private static void buscarClientePorDNI() {
        System.out.print("DNI a buscar: ");
        String dni = scanner.nextLine();
        Cliente cliente = buscarClientePorDNI(dni, true);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static Cliente buscarClientePorDNI(String dni, boolean mostrar) {
        for (Cliente c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                if (mostrar) System.out.println(c);
                return c;
            }
        }
        return null;
    }

    private static void listadoClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("\n--- LISTADO DE CLIENTES ---");
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    // --- GESTIÓN DE PÁJAROS ---
    private static void menuPajaros() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Pájaros ---");
            System.out.println("1. Alta de pájaro");
            System.out.println("2. Listado del catálogo");
            System.out.println("3. Búsqueda por especie");
            System.out.println("4. Volver");
            System.out.print("Seleccione: ");
            opcion = getIntInput();

            switch (opcion) {
                case 1 -> altaPajaro();
                case 2 -> listadoPajaros();
                case 3 -> buscarPajaroPorEspecie();
                case 4 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void altaPajaro() {
        System.out.print("Especie: ");
        String especie = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = getDoubleInput();
        System.out.print("Precio: ");
        int cantidad = getIntInput();

        catalogo.add(new Pajaro(especie, color, precio, cantidad));
        System.out.println("Pájaro agregado al catálogo.");
    }

    private static void listadoPajaros() {
        if (catalogo.isEmpty()) {
            System.out.println("No hay pájaros en el catálogo.");
        } else {
            System.out.println("\n--- CATÁLOGO DE PÁJAROS ---");
            for (int i = 0; i < catalogo.size(); i++) {
                System.out.println((i + 1) + ". " + catalogo.get(i));
            }
        }
    }

    private static void buscarPajaroPorEspecie() {
        System.out.print("Especie a buscar: ");
        String especie = scanner.nextLine().toLowerCase();
        boolean encontrado = false;
        for (Pajaro p : catalogo) {
            if (p.getEspecie().toLowerCase().contains(especie)) {
                System.out.println(p);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron pájaros de esa especie.");
        }
    }

    // --- REALIZAR VENTA ---
    private static void realizarVenta() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados. Registre uno primero.");
            return;
        }
        if (catalogo.isEmpty()) {
            System.out.println("No hay pájaros disponibles para vender.");
            return;
        }

        System.out.print("Ingrese DNI del cliente: ");
        String dni = scanner.nextLine();
        Cliente cliente = buscarClientePorDNI(dni, false);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Venta venta = new Venta(cliente);
        boolean continuar = true;

        while (continuar) {
            listadoPajaros();
            System.out.print("Seleccione el número del pájaro a añadir (0 para terminar): ");
            int num = getIntInput();

            if (num == 0) {
                continuar = false;
            } else if (num > 0 && num <= catalogo.size()) {
                venta.agregarPajaro(catalogo.get(num - 1));
                System.out.println("Pájaro añadido a la venta.");
            } else {
                System.out.println("Número no válido.");
            }
        }

        if (!venta.getLineasDeVenta().isEmpty()) {
            ventas.add(venta);
            System.out.println("Venta registrada. Total: $" + String.format("%.2f", venta.calcularTotal()));
        } else {
            System.out.println("Venta cancelada: no se añadieron pájaros.");
        }
    }

    // --- MOSTRAR VENTAS ---
    private static void menuVentas() {
        int opcion;
        do {
            System.out.println("\n--- Mostrar Ventas ---");
            System.out.println("1. Mostrar todas las ventas");
            System.out.println("2. Mostrar ventas por cliente");
            System.out.println("3. Mostrar importe total de cada venta");
            System.out.println("4. Volver");
            System.out.print("Seleccione: ");
            opcion = getIntInput();

            switch (opcion) {
                case 1 -> mostrarTodasVentas();
                case 2 -> mostrarVentasPorCliente();
                case 3 -> mostrarTotalCadaVenta();
                case 4 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void mostrarTodasVentas() {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            System.out.println("\n--- TODAS LAS VENTAS ---");
            for (Venta v : ventas) {
                System.out.println(v);
            }
        }
    }

    private static void mostrarVentasPorCliente() {
        System.out.print("DNI del cliente: ");
        String dni = scanner.nextLine();
        Cliente cliente = buscarClientePorDNI(dni, false);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        boolean encontrado = false;
        for (Venta v : ventas) {
            if (v.getCliente().getDni().equalsIgnoreCase(dni)) {
                System.out.println(v);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay ventas para este cliente.");
        }
    }

    private static void mostrarTotalCadaVenta() {
        System.out.println("\n--- IMPORTE TOTAL DE CADA VENTA ---");
        for (Venta v : ventas) {
            System.out.println("Cliente: " + v.getCliente().getNombre() +
                    " | Fecha: " + v.getFecha() +
                    " | Total: $" + String.format("%.2f", v.calcularTotal()));
        }
    }

    // --- MÉTODOS AUXILIARES ---
    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    private static double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Ingrese un número válido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    // --- DATOS DE PRUEBA ---
    private static void cargarDatosPrueba() {
        clientes.add(new Cliente("Ana López", "12345678A", "600111222", "ana@email.com"));
        clientes.add(new Cliente("Luis García", "87654321B", "699888777", "luis@email.com"));

        catalogo.add(new Pajaro("Canario", "Amarillo", 25.0, 3));
        catalogo.add(new Pajaro("Periquito", "Verde", 40.0, 2));
        catalogo.add(new Pajaro("Jilguero", "Marrón", 30.0, 1));
    }
}