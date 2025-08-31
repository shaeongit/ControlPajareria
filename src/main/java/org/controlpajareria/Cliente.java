package org.controlpajareria;

/**
 * Clase que representa a un cliente del sistema en nuestro control de una pajarería.
 * Almacena información básica del cliente como nombre, DNI, teléfono y correo electrónico.
 * Esta clase es utilizada para gestionar los datos personales de los clientes
 * que interactúan con el sistema, facilitando su identificación y contacto.
 *
 * @author shaeongit
 * @version 1.0
 * @since 2025-04-05
 */

public class Cliente {
    /**
     * Nombre, DNI, Teléfonos del cliente.
     */
    private String nombre;
    private String dni;
    private String telefono;
    private String email;

    public Cliente(String nombre, String dni, String telefono, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente como cadena de texto.
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nuevo nombre del cliente. No debe ser nulo.
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Obtiene el DNI del cliente.
     *
     * @return El DNI del cliente como cadena de texto.
     */
    public String getDni() { return dni; }

    /**
     * Establece el DNI del cliente.
     *
     * @param dni El nuevo DNI del cliente. Debe ser válido y único.
     */
    public void setDni(String dni) { this.dni = dni; }

    /**
     * Obtiene el número de teléfono del cliente.
     *
     * @return El número de teléfono del cliente, o null si no está establecido.
     */
    public String getTelefono() { return telefono; }

    /**
     * Establece el número de teléfono del cliente.
     *
     * @param telefono El nuevo número de teléfono del cliente.
     */
    public void setTelefono(String telefono) { this.telefono = telefono; }

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return La dirección de correo electrónico del cliente.
     */
    public String getEmail() { return email; }

    /**
     * Establece el correo electrónico del cliente.
     *
     * @param email La nueva dirección de correo electrónico del cliente.
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Devuelve en cadena de texto el objeto Cliente.
     * @return Una cadena con el formato:
     *         {@code Cliente{nombre='...', dni='...', telefono='...', email='...'}}
     */
    @Override
    public String toString() {
        return "Cliente{nombre='" + nombre + "', dni='" + dni + "', telefono='" + telefono + "', email='" + email + "'}";
    }
}