package progratorneo;

import java.awt.Image;
import java.util.ArrayList;

public class Metodos {
    //Punteros de las listas
    public Torneo inicioT;

    public Administrador inicioA;

    public Entrenador inicioEn;
    public Entrenador finalEn;

    public Estadio inicioEs;

    public Equipo inicioEq;
    public Equipo finalEq;

    public Partidos inicioP;

    public Jugador inicioJ;
    
//Metodos de listas

    public Administrador buscarAdmin(String nombre, String clave) {
        Administrador aux = inicioA;
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.clave.equals(clave)) {
                return aux;
            }
            aux = aux.sig;
        }
        return null;
    }

    public Entrenador buscarEntrenador(String nombre, String apellido) {
        Entrenador aux = inicioEn;
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.apellido.equals(apellido)) {
                return aux;
            }
            if (aux == finalEn) {
                return null;
            }
            aux = aux.sig;
        }
        return null;
    }

    public Jugador buscarJugador(String nombre, String apellido) {
        Jugador aux = inicioJ;
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.apellido.equals(apellido)) {
                return aux;
            }
            aux = aux.sig;
        }
        return null;
    }

    // Insercion al final simple
    public boolean InsertarAdmin(String nombre, String clave) {
        Administrador nuevo = new Administrador(nombre, clave, 0);
        if (inicioA == null) {
            inicioA = nuevo;
            return true;
        }
        Administrador aux = inicioA;
        while (aux.sig != null) {
            if (aux.nombre.equals(nombre)) {
                return false;
            }
            aux = aux.sig;
        }
        aux.sig = nuevo;
        nuevo.sig = null;
        return true;
    }

    // Insercion al inicio simple circular
    public String InsertarEntrenador(String nombre, String apellido) {
        Entrenador nuevo = new Entrenador(nombre, apellido);
        if (inicioEn == null) {
            inicioEn = nuevo;
            inicioEn.sig = inicioEn;
            finalEn = inicioEn;
            return "Entrenador Insertado";
        }
        Entrenador aux = inicioEn;
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.apellido.equals(apellido)) {
                return "Entrenador ya existe";
            }
            if (aux.nombre.equals(finalEq.nombre)) {
                break;
            }
            aux = aux.sig;
        }
        finalEn.sig = nuevo;
        nuevo.sig = inicioEn;
        inicioEn = nuevo;
        return "Entrenador Insertado";
    }

    //Insertar Inicio Simple
    public boolean InsertarJugador(String nombre, String apellido, int[] habilidades, int precio, String posicion) {
        Jugador nuevo = new Jugador(nombre, apellido, habilidades, precio, posicion);
        if (inicioJ == null) {
            inicioJ = nuevo;
            return true;
        }
        Jugador aux = inicioJ;
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.apellido.equals(apellido)) {
                return false;
            }
            aux = aux.sig;
        }
        nuevo.sig = inicioJ;
        inicioJ = nuevo;
        return true;
    }
    //Insertar Doble circular

    public String InsertarEquipo(String nombre, String camisa) {
        Equipo nuevo = new Equipo(nombre, camisa);
        if (inicioEq == null) {
            inicioEq = nuevo;
            finalEq = inicioEq;
            inicioEq.ant = nuevo;
            finalEq.sig = nuevo;
            return "Insertado";
        }
        Equipo aux = inicioEq;
        while (aux != null) {
            if (aux.nombre.equals(nombre)) {
                return "Ya Existe!";
            }
            if (aux.nombre.equals(finalEq.nombre)) {
                break;
            }
            aux = aux.sig;
        }
        inicioEq.ant = nuevo;
        nuevo.sig = inicioEq;
        inicioEq = nuevo;
        inicioEq.ant = finalEq;
        finalEq.sig = inicioEq;

        return "Insertado";

    }

    // insertar simple
    public String InsertarEstadio(String nombre, String ubicacion, int capacidad) {
        Estadio nuevo = new Estadio(nombre, ubicacion, capacidad);
        if (inicioEs == null) {
            inicioEs = nuevo;
            return "";
        }
        Estadio aux = inicioEs;
        while (aux != null) {
            if (aux.nombre.equals(nombre)) {
                return "";
            }
            aux = aux.sig;
        }
        nuevo.sig = inicioEs;
        inicioEs = nuevo;
        return "";
    }
}
