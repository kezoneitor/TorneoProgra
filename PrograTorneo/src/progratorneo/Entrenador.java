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
public class Entrenador {
    String nombre;
    Equipo equipo;
    Entrenador sig;

    public Entrenador(String nombre, Equipo equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.sig = null;
    }
    
}
