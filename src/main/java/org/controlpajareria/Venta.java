package org.controlpajareria;

import java.util.ArrayList;
import java.time.LocalDate;

public class Venta {
    private Cliente cliente;
    private ArrayList<Pajaro> lineasDeVenta;
    private String fecha;

    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.lineasDeVenta = new ArrayList<>();
        this.fecha = LocalDate.now().toString();
    }

    public void agregarPajaro(Pajaro pajaro) {
        lineasDeVenta.add(pajaro);
    }

    public double calcularTotal() {
        return lineasDeVenta.stream().mapToDouble(Pajaro::getPrecio).sum();
    }

    public Cliente getCliente() { return cliente; }
    public ArrayList<Pajaro> getLineasDeVenta() { return lineasDeVenta; }
    public String getFecha() { return fecha; }

    @Override
    public String toString() {
        return "Venta{cliente=" + cliente.getNombre() + ", fecha='" + fecha + "', total=" + String.format("%.2f", calcularTotal()) + "}";
    }
}