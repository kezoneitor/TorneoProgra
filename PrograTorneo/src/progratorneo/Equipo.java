/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progratorneo;

import java.awt.Image;

/**
 *
 * @author Kezo
 */
public class Equipo {
    Jugador[] jugadores;
    Entrenador entrenador;
    int dinero;
    Image camisa;
    int posicionTorneo;
    int goles;
    
    //Punteros
    Equipo sig;
    Equipo ant;

    public Equipo(int dinero, Image camisa, int posicionTorneo) {
        this.jugadores = null;
        this.entrenador = null;
        this.dinero = dinero;
        this.camisa = camisa;
        this.posicionTorneo = posicionTorneo;
        this.goles = 0;
        this.sig = null;
        this.ant = null;
    }
    
}
