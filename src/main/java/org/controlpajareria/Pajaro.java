package org.controlpajareria;

public class Pajaro {
    private String especie;
    private String color;
    private double precio;
    private int cantidad;

    public Pajaro(String especie, String color, double precio, int cantidad) {
        this.especie = especie;
        this.color = color;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }


    @Override
    public String toString() {
        return "Pájaro {especie='" + especie + "', color='" + color + "', cantidad='" + cantidad + "', precio=" + precio + "}";
    }
}