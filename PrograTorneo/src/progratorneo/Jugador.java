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
public class Jugador {
    Equipo equipo;
    //Físico, Defensa, Dribbling Disparo
    int[] habilidades;
    String nombre;
    String apellido;
    int precio;
    String posicion;
    int goles;
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
    }
    
}
