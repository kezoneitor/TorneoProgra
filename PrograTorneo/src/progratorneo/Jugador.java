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
    int precio;
    String posicion;
    int goles;
    //Punteros
    Jugador sig;

    public Jugador(String nombre, int[] habilidades, int precio, String posicion) {
        this.equipo = null;
        this.nombre = nombre;
        this.habilidades = habilidades;
        this.precio = precio;
        this.posicion = posicion;
        this.goles = 0;
        this.sig = null;
    }
    
}
