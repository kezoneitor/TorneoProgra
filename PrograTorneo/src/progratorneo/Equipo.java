

package progratorneo;

import java.util.ArrayList;
import java.util.Arrays;

public class Equipo {
    String nombre;
    ArrayList<Jugador> jugadores;
    Entrenador entrenador;
    int dinero;
    String[] camisa;
    int posicionTorneo;
    int goles;
    int golesContra;

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
        this.golesContra = 0;
        this.sig = null;
        this.ant = null;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", jugadores=" + jugadores.size() +  ", dinero=" + dinero + ", camisa=" + Arrays.toString(camisa) + ", posicionTorneo=" + posicionTorneo + ", goles=" + goles +'}';
    }
    
    

}
