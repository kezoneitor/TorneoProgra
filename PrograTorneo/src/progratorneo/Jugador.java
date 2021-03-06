/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progratorneo;

import java.util.Arrays;

/**
 *
 * @author Kezo
 */
public class Jugador {
    Equipo equipo;
    //Físico, Defensa, Dribbling Disparo
    int[] habilidades;
    String nombre;
    String apellido;
    int precio;
    String posicion;
    int goles;
    String estado;
    //Punteros
    Jugador sig;

    public Jugador(String nombre, String apellido, int[] habilidades, int precio, String posicion) {
        this.equipo = null;
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
        this.precio = precio;
        this.posicion = posicion;
        this.goles = 0;
        this.sig = null;
        this.estado = "libre";
    }

    @Override
    public String toString() {
        return "Jugador{" + "equipo=" + equipo + ", habilidades=" + Arrays.toString(habilidades) + ", nombre=" + nombre + ", apellido=" + apellido + ", precio=" + precio + ", posicion=" + posicion + ", goles=" + goles + '}';
    }
}
