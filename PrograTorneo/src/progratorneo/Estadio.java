/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progratorneo;

/**
 *
 * @author Kezo
 */
public class Estadio {
    String nombre;
    String ubicacion;
    int capacidad;
    Estadio sig;

    public Estadio(String nombre, String ubicacion, int capacidad) {
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.sig = null;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estadio{" + "nombre=" + nombre + ", ubicacion=" + ubicacion + ", capacidad=" + capacidad + ", sig=" + sig + '}';
    }
    
}
