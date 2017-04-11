

package progratorneo;

import java.util.ArrayList;

public class Equipo {
    String nombre;
    ArrayList<Jugador> jugadores;
    Entrenador entrenador;
    int dinero;
    String[] camisa;
    int posicionTorneo;
    int goles;

    //Punteros
    Equipo sig;
    Equipo ant;

    public Equipo(String nombre, String[] camisa) {
        this.nombre = nombre;
        this.jugadores = new ArrayList();
        this.entrenador = null;
        this.dinero = 3000000;
        this.camisa = camisa;
        this.posicionTorneo = 0;
        this.goles = 0;
        this.sig = null;
        this.ant = null;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", jugadores=" + jugadores + ", entrenador=" + entrenador + ", dinero=" + dinero + ", camisa=" + camisa + ", posicionTorneo=" + posicionTorneo + ", goles=" + goles +'}';
    }
    
    

}
