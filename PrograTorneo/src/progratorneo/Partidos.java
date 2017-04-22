
package progratorneo;

import java.util.ArrayList;

public class Partidos {

    Partidos sig;
    Estadio estadio;
    Equipo equipoA;
    Equipo equipoB;
    ArrayList<String> goleadores;
    int aficion;
    int golesA;
    int golesB;

    public Partidos(Estadio estadio, Equipo equipoA, Equipo equipoB) {
        this.sig = null;
        this.estadio = estadio;
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        this.golesA = 0;
        this.golesB = 0;
        this.goleadores = new ArrayList();
        this.aficion = 0;
    }
    
}
