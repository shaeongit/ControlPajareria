package org.controlpajareria;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Clase que representa una venta en nuestro control de una pajarería.
 * Contiene información sobre el cliente, la fecha de la venta y los pájaros vendidos.
 * Cada venta puede incluir múltiples pájaros (líneas de venta), y permite calcular
 * el importe total de la misma. Es utilizada para registrar transacciones dentro
 * del sistema de control de la pajarería.
 *
 * @author shaeongit
 * @version 1.0
 * @since 2025-04-05
 */

public class Venta {
    /**
     * Cliente que realiza la compra.
     * No debe ser nulo, ya que toda venta está asociada a un cliente.
     */
    private Cliente cliente;

    /**
     * Lista de pájaros incluidos en esta venta.
     * Representa las "líneas de venta". Se inicializa vacía al crear la instancia.
     */
    private ArrayList<Pajaro> lineasDeVenta;

    /**
     * Fecha en la que se realizó la venta.
     * Se establece automáticamente en el momento de la creación de la venta.
     */
    private String fecha;

    /**
     * Constructor que inicializa una nueva venta para un cliente específico.
     * La fecha se establece automáticamente como la fecha actual del sistema,
     * y la lista de pájaros vendidos comienza vacía.
     *
     * @param cliente El cliente que realiza la compra. No debe ser {@code null}.
     */
    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.lineasDeVenta = new ArrayList<>();
        this.fecha = LocalDate.now().toString();
    }

    /**
     * Agrega un pájaro a la lista de productos vendidos en esta venta.
     *
     * @param pajaro El objeto {@code Pajaro} que se añade a la venta.
     *               No debe ser {@code null}.
     */
    public void agregarPajaro(Pajaro pajaro) {
        lineasDeVenta.add(pajaro);
    }

    /**
     * Calcula el precio total de la venta sumando los precios de todos los pájaros incluidos.
     *
     * @return El importe total de la venta como un valor double. Si no hay pájaros,
     *         devuelve 0.0.
     */
    public double calcularTotal() {
        return lineasDeVenta.stream().mapToDouble(Pajaro::getPrecio).sum();
    }

    /**
     * Obtiene el cliente asociado a esta venta.
     *
     * @return El objeto {@code Cliente} que realizó la compra.
     */
    public Cliente getCliente() { return cliente; }

    /**
     * Obtiene la lista de pájaros incluidos en la venta.
     *
     * @return Una referencia a la lista de objetos {@code Pajaro} vendidos.
     */
    public ArrayList<Pajaro> getLineasDeVenta() { return lineasDeVenta; }

    /**
     * Obtiene la fecha en la que se realizó la venta.
     *
     * @return La fecha como cadena.
     */
    public String getFecha() { return fecha; }

    /**
     * Devuelve una cadena de texto de la venta.
     * El formato incluye el nombre del cliente, la fecha y el total.
     *
     * @return Una cadena con el formato:
     *         {@code Venta{cliente=Nombre, fecha='YYYY-MM-DD', total=XX.XX}}
     */
    @Override
    public String toString() {
        return "Venta{cliente=" + cliente.getNombre() + ", fecha='" + fecha + "', total=" + String.format("%.2f", calcularTotal()) + "}";
    }
}