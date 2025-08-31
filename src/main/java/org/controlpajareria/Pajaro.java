package org.controlpajareria;

/**
 * Clase que representa un pájaro disponible nuestro control de una pajarería.
 * Contiene información sobre su especie, color, precio y cantidad en stock.
 * Esta clase se utiliza para modelar los productos (pájaros) que pueden ser
 * vendidos a los clientes, y es parte fundamental del sistema de gestión comercial.
 *
 * @author shaeongit
 * @version 1.0
 * @since 2025-04-05
 */
public class Pajaro {
    /**
     * Especie del pájaro (por ejemplo: "Canario", "Periquito", "Jilguero").
     * Este campo identifica el tipo biológico o común del ave.
     */
    private String especie;

    /**
     * Color predominante del pájaro.
     * Puede incluir variantes como "amarillo", "verde", "azul", etc.
     */
    private String color;

    /**
     * Precio unitario del pájaro.
     * Debe ser un valor positivo o cero.
     */
    private double precio;

    /**
     * Cantidad disponible en inventario para esta especie y color.
     * Representa cuántos ejemplares de este pájaro hay en stock.
     */
    private int cantidad;

    /**
     * Constructor que inicializa un nuevo pájaro con los atributos especificados.
     *
     * @param especie   La especie del pájaro. No debe ser nulo ni vacío.
     * @param color     El color predominante del pájaro. No debe ser nulo ni vacío.
     * @param precio    El precio unitario del pájaro. Debe ser mayor o igual a 0.
     * @param cantidad  La cantidad disponible en stock. Debe ser mayor o igual a 0.
     */
    public Pajaro(String especie, String color, double precio, int cantidad) {
        this.especie = especie;
        this.color = color;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la especie del pájaro.
     *
     * @return El nombre de la especie como cadena de texto.
     */
    public String getEspecie() { return especie; }

    /**
     * Establece la especie del pájaro.
     *
     * @param especie El nuevo nombre de la especie. No debe ser nulo ni vacío.
     */
    public void setEspecie(String especie) { this.especie = especie; }

    /**
     * Obtiene el color del pájaro.
     *
     * @return El color predominante del pájaro como cadena de texto.
     */
    public String getColor() { return color; }

    /**
     * Establece el color del pájaro.
     *
     * @param color El nuevo color del pájaro. No debe ser nulo ni vacío.
     */
    public void setColor(String color) { this.color = color; }

    /**
     * Obtiene el precio del pájaro.
     *
     * @return El precio como valor double. Puede ser 0 o positivo.
     */
    public double getPrecio() { return precio; }

    /**
     * Establece el precio del pájaro.
     *
     * @param precio El nuevo precio. Debe ser mayor o igual a 0.
     */
    public void setPrecio(double precio) { this.precio = precio; }

    /**
     * Obtiene la cantidad disponible en inventario.
     *
     * @return El número de ejemplares disponibles de este pájaro.
     */
    public int getCantidad() { return cantidad; }

    /**
     * Establece la cantidad disponible en stock.
     *
     * @param cantidad La nueva cantidad. Debe ser mayor o igual a 0.
     */
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    /**
     * Devuelve una representación en cadena de texto del objeto Pájaro.
     * Útil para depuración, impresión de listados o registro de información.
     *
     * @return Una cadena con el formato:
     *         {@code Pájaro {especie='...', color='...', cantidad='...', precio=...}}
     */
    @Override
    public String toString() {
        return "Pájaro {especie='" + especie + "', color='" + color + "', cantidad='" + cantidad + "', precio=" + precio + "}";
    }
}