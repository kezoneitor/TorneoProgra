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
//-------------------------------------------METODOS ADMINISTRADOR----------------------------------//
    // metodo buscar
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

    public String modificarAdmin(String nombre, String clave, String nombreN, String claveN) {
        Administrador aux = inicioA;
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.clave.equals(clave)) {
                aux.nombre = nombreN;

                aux.clave = claveN;

                return " Datos del Administrador modificados. ";

            }
            aux = aux.sig;
        }
        return " El administrador no existe.";

    }

    public String eliminarAdmin(String nombre, String clave) {
        Administrador auxAnt = inicioA;
        Administrador aux = inicioA.sig;
        if (inicioA.nombre.equals(nombre) & inicioA.clave.equals(clave)) {
            inicioA = aux;
            return " Administrador Eliminado. ";
        }
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.clave.equals(clave)) {
                auxAnt.sig = aux.sig;
                return " Administrador Eliminado. ";
            }
            auxAnt = aux;
            aux = aux.sig;
        }
        return " El administrador no existe.";

    }

    public void imprimirAdmin() {
        Administrador aux = inicioA;
        while (aux != null) {
            System.out.println(aux.toString());
            aux = aux.sig;
        }
    }

//-------------------------------------------METODOS ENTRENADOR----------------------------------//
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
            if (aux == finalEn) {
                break;
            }
            aux = aux.sig;
        }
        finalEn.sig = nuevo;
        nuevo.sig = inicioEn;
        inicioEn = nuevo;
        return "Entrenador Insertado";
    }

    //-------------------------------------------METODOS JUGADOR----------------------------------//
    //Insertar Inicio Simple
    public String InsertarJugador(String nombre, String apellido, int[] habilidades, int precio, String posicion) {
        Jugador nuevo = new Jugador(nombre, apellido, habilidades, precio, posicion);
        if (inicioJ == null) {
            inicioJ = nuevo;
            return "Jugador insertado";
        }
        Jugador aux = inicioJ;
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.apellido.equals(apellido)) {
                return "El jugador ya existe";
            }
            aux = aux.sig;
        }
        nuevo.sig = inicioJ;
        inicioJ = nuevo;
        return "Jugador insertado";
    }
    
    //Modificar 
    public String modificarJugador(String nombre, String apellido, int[] habilidades, int precio, String posicion) {
        Jugador aux = inicioJ;
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.apellido.equals(apellido)) {
                aux.nombre = nombre;
                aux.apellido = apellido;
                aux.habilidades = habilidades;
                aux.precio = precio;
                aux.posicion = posicion;
            }
            aux = aux.sig;
        }
        return "El jugador no existe";
    }
    
    
    //buscar simple por nombre y apellido
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
    
    //buscar simple por precio
    public ArrayList buscarJugadorPrecio(int precio, String signo) {
        ArrayList<Jugador> jugadores = new ArrayList();
        Jugador aux = inicioJ;
        while (aux != null) {
            switch(signo){
                case "=":
                    if(aux.precio == precio){
                        jugadores.add(aux);
                    }
                    break;
                case "<":
                    if(aux.precio <= precio){
                        jugadores.add(aux);
                    }
                    break;
                case ">":
                    if(aux.precio >= precio){
                        jugadores.add(aux);
                    }
                    break;
            }
            aux = aux.sig;
        }
        return jugadores;
    }
    
    //buscar simple por posicion
    public ArrayList buscarJugadorPosicion(String posicion) {
        ArrayList<Jugador> jugadores = new ArrayList();
        Jugador aux = inicioJ;
        while (aux != null) {
            if (aux.posicion.equals(posicion)) {
                jugadores.add(aux);
            }
            aux = aux.sig;
        }
        return jugadores;
    }
    
    //imprimir jugador
    public void imprimirJugador(){
        Jugador aux = inicioJ;
        while(aux != null){
            System.out.println(aux.toString());
            aux = aux.sig;
        }
    }

    //-------------------------------------------METODOS EQUIPO----------------------------------//
    //Insertar Doble circular
    public String InsertarEquipo(String nombre, String[] camisa) {
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

    //-------------------------------------------METODOS ESTADIO----------------------------------//
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
