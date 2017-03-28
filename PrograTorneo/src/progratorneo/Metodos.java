package progratorneo;

import java.awt.Image;
import java.util.ArrayList;

public class Metodos {

    ArrayList<ArrayList> Jugadores = new ArrayList();// matriz 
    ArrayList<String> listNombre = new ArrayList<String>();
    ArrayList<String> listApellido = new ArrayList<String>();

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

    public void AgregarNombreApellido() {

        listNombre.add("julio");
        listNombre.add("roberto");
        listNombre.add("cristal");
        listNombre.add("pepe");
        listNombre.add("manolo");
        listNombre.add("luis");
        listNombre.add("josue");
        listNombre.add("acer");
        listNombre.add("totto");
        listNombre.add("toshiba");
        listNombre.add("sibitec");
        listNombre.add("luz");
        listNombre.add("yeremi");
        listNombre.add("antonio");
        listNombre.add("pancracio");
        listNombre.add("keslerth");
        listNombre.add("vineichon");
        listNombre.add("maicol");
        listNombre.add("michaelle");

        listApellido.add("manantial");
        listApellido.add("stuar");
        listApellido.add("isuzu");
        listApellido.add("radix");
        listApellido.add("heap");
        listApellido.add("marshall");
        listApellido.add("tiberius");
        listApellido.add("reca");
        listApellido.add("abhdull");
        listApellido.add("innvovair");
        listApellido.add("ozil");
        listApellido.add("duda");
        listApellido.add("manantial");
        listApellido.add("silva");
        listApellido.add("diezcinueve");
        listApellido.add("russbell");
        listApellido.add("tinker");
        listApellido.add("moghulkan");
        listApellido.add("tidehunter");

    }

    public void CrearJugadores() {
        int[] posiciones = {32, 128, 128, 64, -1};
        for (int i = 0; i < listNombre.size(); i++) {
            for (int j = 0; j < listApellido.size(); j++) {

                ArrayList jugador = new ArrayList();

                int[] habilidades = {1, 1, 1, 1};

                jugador.add(listNombre.get(i));
                jugador.add(listApellido.get(j));
                jugador.add(generarHabilidades(habilidades));
                posiciones = generarPosicion(posiciones);
                switch (posiciones[4]) {
                    case 0:
                        jugador.add("portero");
                        break;
                    case 1:
                        jugador.add("defensa");
                        break;
                    case 2:
                        jugador.add("medio");
                        break;
                    case 3:
                        jugador.add("delantero");
                        break;
                }
                Jugadores.add(jugador);
            }
        }
        System.out.println(Jugadores);
    }

    public int[] generarHabilidades(int[] habilidades) {
        int total = 0;
        while (total != 15) {
            int pto1 = (int) (Math.random() * 9);
            int pto2 = (int) (Math.random() * 9);
            int pto3 = (int) (Math.random() * 9);
            int pto4 = (int) (Math.random() * 9);
            habilidades[0] = pto1 + 1;
            habilidades[1] = pto2 + 1;
            habilidades[2] = pto3 + 1;
            habilidades[3] = pto4 + 1;
            total = habilidades[0] + habilidades[1] + habilidades[2] + habilidades[3];
        }
        return habilidades;
    }

    public int[] generarPosicion(int[] posiciones) {
        return posiciones;
    }

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

    public String InsertarEquipo(String nombre, Image camisa) {
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
