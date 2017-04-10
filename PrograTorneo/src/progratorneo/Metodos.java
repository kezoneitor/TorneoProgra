package progratorneo;

import java.awt.Image;
import static java.lang.System.out;
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
    //Metodos listas simple
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
            out.println(aux.toString());
            aux = aux.sig;
        }
    }

//-------------------------------------------METODOS ENTRENADOR----------------------------------//
    // Metodos simples Circular
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

    public String modificarEntrenador(String nombre, String apellido, String nombreN, String apellidoA) {
        Entrenador aux = inicioEn;
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.apellido.equals(apellidoA)) {
                aux.nombre = nombreN;

                aux.apellido = apellidoA;

                return " Datos del Entrenador modificados. ";

            }
            if (aux.nombre.equals(finalEn.nombre) & aux.apellido.equals(finalEn.apellido)) {
                break;
            }
            aux = aux.sig;
        }
        return " El Entrenador no existe.";

    }

    public String eliminarEntrenador(String nombre, String apellido) {
        Entrenador auxAnt = inicioEn;
        Entrenador aux = inicioEn.sig;
        Entrenador auxF = finalEn;
        if (inicioEn.nombre.equals(nombre) & inicioEn.apellido.equals(apellido)) {//inicio
            inicioEn = aux;
            finalEn.sig = aux;
            return " Entrenador Eliminado. ";
        }
        while (aux != null) {
            if (aux.nombre.equals(finalEn.nombre) & aux.apellido.equals(finalEn.apellido)) {
                break;
            }

            if (aux.nombre.equals(nombre) & aux.apellido.equals(apellido)) {
                auxAnt.sig = aux.sig;
                return " Entrenador Eliminado. ";
            }

            auxAnt = aux;
            aux = aux.sig;

        }
        if (aux.nombre.equals(finalEn.nombre) & aux.apellido.equals(finalEn.apellido)) {
            auxAnt.sig = inicioEn;
            aux.sig = null;
            return " Entrenador Eliminado. ";
        }
        return " El Entrenador no existe.";
    }

    public void imprimirEntrenador() {
        Entrenador aux = inicioEn;
        while (aux != null) {
            out.println(aux.toString());
            aux = aux.sig;
        }
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
    public String modificarJugador(String nombre, String nombreN, String apellido, int[] habilidades, int precio, String posicion) {
        Jugador aux = inicioJ;
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.apellido.equals(apellido)) {
                aux.nombre = nombreN;
                aux.apellido = apellido;
                aux.habilidades = habilidades;
                aux.precio = precio;
                aux.posicion = posicion;
                return "Jugador Modificado.";
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
            switch (signo) {
                case "=":
                    if (aux.precio == precio) {
                        jugadores.add(aux);
                    }
                    break;
                case "<":
                    if (aux.precio <= precio) {
                        jugadores.add(aux);
                    }
                    break;
                case ">":
                    if (aux.precio >= precio) {
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

    public String eliminarJugador(String nombre, String apellido) {
        if (inicioJ == null) {
            return "Lista vacía";
        }
        if (inicioJ.nombre.equals(nombre) & inicioJ.apellido.equals(apellido)) {
            inicioJ = inicioJ.sig;
            return "Jugador eliminado";
        }
        Jugador aux = inicioJ.sig;
        Jugador auxAnt = inicioJ;
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.apellido.equals(apellido)) {
                auxAnt.sig = aux.sig;
                return "Jugador eliminado";
            }
            aux = aux.sig;
        }
        return "No existe el jugador";
    }

    //imprimir jugador
    public void imprimirJugador() {
        Jugador aux = inicioJ;
        while (aux != null) {
            out.println(aux.toString());
            aux = aux.sig;
        }
    }

    //-------------------------------------------METODOS EQUIPO----------------------------------//
    //Insertar Doble circular
    public Equipo buscarEquipo(String nombre) {
        Equipo aux = inicioEq;
        while (aux != null) {

            if (aux.nombre.equals(nombre)) {
                return aux;

            }
            if (aux.nombre.equals(finalEq.nombre)) {
                break;
            }
            aux = aux.sig;
        }
        return null;
    }

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

    public String modificarEquipo(String nombre, int dinero, String[] camisa, String NuevoNombre) {
        Equipo aux = inicioEq;
        while (aux != null) {
            if (aux.nombre.equals(nombre)) {
                aux.nombre = NuevoNombre;
                aux.dinero = dinero;
                aux.camisa = camisa;

            }
            if (aux.nombre.equals(finalEq.nombre)) {
                return "El Equipo no Existe";
            }
            aux = aux.sig;
        }
        return "Lista vacia";
    }

    public String EliminarEquipo(String nombre) {
        Equipo auxAnt = inicioEq;
        Equipo aux = inicioEq.sig;
        Equipo auxF = finalEq;
        if (inicioEq.nombre.equals(nombre)) {
            inicioEq = aux;
            finalEq.sig = aux;
            return "Equipo eliminado";
        }
        while (aux != null) {
            if (aux.nombre.equals(finalEq.nombre)) {
                break;
            }
            if (aux.nombre.equals(nombre)) {
                auxAnt.sig = aux.sig;
                aux.sig.ant = auxAnt;
                return "Equipo eliminado";
            }
            auxAnt = aux;
            aux = aux.sig;
        }
        if (aux.nombre.equals(finalEq.nombre)) {
            auxAnt.sig = inicioEq;
            inicioEq.ant = auxAnt;
            return "Equipo eliminado";
        }
        return " El equipo no existe. ";
    }

    public void imprimirEquipo() {
        Equipo aux = inicioEq;
        while (aux != null) {
            out.println(aux.toString());
            aux = aux.sig;
        }
    }

    //-------------------------------------------METODOS ESTADIO----------------------------------//
    public Estadio buscarEstadio(String nombre) {
        Estadio aux = inicioEs;
        while (aux != null) {
            if (aux.nombre.equals(nombre)) {
                return aux;
            }
            aux = aux.sig;
        }
        return null;
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

    public String modificarEstadio(String nombre, String ubicacion, String nombreN, int capacidad) {
        Estadio aux = inicioEs;
        while (aux != null) {
            if (aux.nombre.equals(nombre)) {
                aux.nombre = nombreN;
                aux.ubicacion = ubicacion;
                aux.capacidad = capacidad;

                return " Datos del Estadio modificados. ";

            }
            aux = aux.sig;
        }
        return " El Estadio no existe.";

    }

    public String EliminarEstadio(String nombre) {
        Estadio aux = inicioEs.sig;
        Estadio auxAnt = inicioEs;
        if (auxAnt == null) {
            return " Lista vacia. ";
        }
        if (auxAnt.nombre.equals(inicioEs.nombre)) {
            inicioEs = aux;
            return "Estadio Eliminado. ";
        }
        while (aux != null) {
            if (aux.nombre.equals(nombre)) {
                auxAnt.sig = aux.sig;
                return "Estadio Eliminado. ";

            }
            auxAnt = aux;
            aux = aux.sig;
        }
        return "El Estadio no existe. ";
    }

    public void imprimirEstadio() {
        Estadio aux = inicioEs;
        while (aux != null) {
            out.println(aux.toString());
            aux = aux.sig;
        }
    }
//-------------------------------------------METODOS TORNEOS----------------------------------//
    //Metodos listas simple
    // metodo buscar

    public Torneo buscarTorneo(String nombreAdmin, String nombreTorneo) {
        Torneo aux = inicioT;
        while (aux != null) {
            if (aux.nombre.equals(nombreTorneo) & aux.admin.nombre.equals(nombreAdmin)) {
                return aux;
            }
            aux = aux.sig;
        }
        return null;
    }

    // Insercion al final simple
    public String InsertarTorneo(Administrador admin, String nombre, int[] premios) {
        Torneo nuevo = new Torneo(admin, nombre, premios);
        if (inicioT == null) {
            inicioT = nuevo;
            return "Torneo insertado";
        }
        Torneo aux = inicioT;
        while (aux.sig != null) {
            if (aux.nombre.equals(nombre) & aux.admin.nombre.equals(admin.nombre)) {
                return "Ya existe este torneo.";
            }
            aux = aux.sig;
        }
        aux.sig = nuevo;
        nuevo.ant = aux;
        return "Toneo insertado";
    }

    public String modificarAdmin(Administrador admin, String nombre, String nombreN, int[] premios) {
        Torneo aux = inicioT;
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.admin.nombre.equals(admin.nombre)) {
                aux.nombre = nombreN;
                aux.Premio = premios;
                return " Datos del Administrador modificados. ";

            }
            aux = aux.sig;
        }
        return " El Torneo no existe.";

    }

    public String eliminarTorneo(Administrador admin, String nombre) {
        if (inicioT.nombre.equals(nombre) & inicioT.admin.nombre.equals(admin.nombre)) {
            inicioT = inicioT.sig;
            inicioT.ant = null;
            return " Torneo Eliminado. ";
        }
        Torneo aux = inicioT.sig;
        while (aux.sig != null) {
            if (aux.nombre.equals(nombre) & aux.admin.nombre.equals(admin.nombre)) {
                aux.ant.sig = aux.sig;
                aux.sig.ant = aux.ant;
                return " Torneo Eliminado. ";
            }
            aux = aux.sig;
        }
        if (aux.nombre.equals(nombre) & aux.admin.nombre.equals(admin.nombre)) {
            aux.ant.sig = null;
            return " Torneo Eliminado. ";
        }
        return " El torneo no existe.";

    }

    public void imprimirTorneo() {
        Torneo aux = inicioT;
        while (aux != null) {
            out.println(aux.toString());
            
            Partidos auxPA = aux.SubPartidosA;
            System.out.print("Grupo A ");
            while(auxPA != null){
                System.out.print("/ "+ auxPA.toString());
                auxPA = auxPA.sig;
            }
            System.out.println(" /");
            
            Partidos auxPB = aux.SubPartidosB;
            System.out.print("Grupo B ");
            while(auxPB != null){
                System.out.print("/ "+ auxPB.toString());
                auxPB = auxPB.sig;
            }
            System.out.print(" /");
            
            aux = aux.sig;
        }
    }

}
