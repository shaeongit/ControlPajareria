package org.controlpajareria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaPajareriaTest {

    private ArrayList<Cliente> clientes;

    @BeforeEach
    void setUp() {
        clientes = new ArrayList<>();
    }

    @Test
    void testAltaCliente() {
        Cliente cliente = new Cliente("Ana López", "12345678A", "600111222", "ana@email.com");
        clientes.add(cliente);

        assertFalse(clientes.isEmpty());
        assertEquals("12345678A", clientes.get(0).getDni());
        assertEquals("Ana López", clientes.get(0).getNombre());
    }

    @Test
    void testVentaReduceStock() {
        Pajaro pajaro = new Pajaro("Canario", "Amarillo", 25.0, 3);
        Cliente cliente = new Cliente("Luis García", "87654321B", "699888777", "luis@email.com");
        Venta venta = new Venta(cliente);

        venta.agregarPajaro(new Pajaro("Canario", "Amarillo", 25.0, 1));
        pajaro.setCantidad(pajaro.getCantidad() - 1);

        assertEquals(2, pajaro.getCantidad());
    }

    @Test
    void testTotalVenta() {
        Cliente cliente = new Cliente("Ana López", "12345678A", "600111222", "ana@email.com");
        Venta venta = new Venta(cliente);
        venta.agregarPajaro(new Pajaro("Canario", "Amarillo", 25.0, 1));
        venta.agregarPajaro(new Pajaro("Periquito", "Verde", 40.0, 1));

        double total = venta.calcularTotal();
        assertEquals(65.0, total, 0.01);
    }
}