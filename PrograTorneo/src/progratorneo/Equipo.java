

package progratorneo;

import java.awt.Image;

public class Equipo {
    String nombre;
    Jugador[] jugadores;
    Entrenador entrenador;
    int dinero;
    Image camisa;
    int posicionTorneo;
    int goles;

    //Punteros
    Equipo sig;
    Equipo ant;

    public Equipo(String nombre, Image camisa) {
        this.nombre= nombre;
        this.jugadores = null;
        this.entrenador = null;
        this.dinero = 3000000;
        this.camisa = camisa;
        this.posicionTorneo = 0;
        this.goles = 0;
        this.sig = null;
        this.ant = null;
    }

}
