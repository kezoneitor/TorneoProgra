/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progratorneo;

public class Entrenador {

    String nombre;
    String apellido;
    Equipo equipo;
    Entrenador sig;

    public Entrenador(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.equipo = null;
        this.sig = null;
    }

    @Override
    public String toString() {
        return "Entrenador{" + "nombre=" + nombre + ", apellido=" + apellido + ", equipo=" + equipo + '}';
    }

}
