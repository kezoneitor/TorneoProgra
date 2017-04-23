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
            if (aux == finalEn) {
                break;
            }
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
    public ArrayList<Jugador> buscarJugadorPrecio(int precio, String signo) {
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
                if (aux.equipo.posicionTorneo == 0) {
                    auxAnt.sig = aux.sig;
                    return "Jugador eliminado";
                } else {
                    return "El jugador esta en un torneo, no puede ser eliminado";
                }
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
            if (aux.camisa == camisa) {
                return "La Camisa ya existe";
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
            out.println("Entrenador: " + aux.entrenador.nombre + " " + aux.entrenador.apellido + aux.toString());
            aux = aux.sig;
            if (aux.nombre.equals(finalEq.nombre)) {
                break;
            }
        }
    }

    public int lenEquipo() {
        Equipo auxEq = inicioEq;
        int lenEq = 0;
        while (auxEq != null) {
            lenEq++;
            if (auxEq == finalEq) {
                break;
            }
            auxEq = auxEq.sig;
        }
        return lenEq;
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

    public int lenEstadio() {
        Estadio auxEs = inicioEs;
        int lenEs = 0;
        while (auxEs != null) {
            lenEs++;
            auxEs = auxEs.sig;
        }
        return lenEs;
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
    
    public Torneo buscarTorneo(String nombreTorneo) {
        Torneo aux = inicioT;
        while (aux != null) {
            if (aux.nombre.equals(nombreTorneo)) {
                return aux;
            }
            aux = aux.sig;
        }
        return null;
    }

    // Insercion al final simple
    public String InsertarTorneo(Administrador admin, String nombre, int[] premios, int entrada) {
        Torneo nuevo = new Torneo(admin, nombre, premios, entrada);
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

    public String modificarTorneo(Administrador admin, String nombre, String nombreN, int[] premios, int entrada) {
        Torneo aux = inicioT;
        while (aux != null) {
            if (aux.nombre.equals(nombre) & aux.admin.nombre.equals(admin.nombre)) {
                aux.nombre = nombreN;
                aux.Premio = premios;
                aux.entrada = entrada;
                return " Datos del Administrador modificados. ";

            }
            aux = aux.sig;
        }
        return " El Torneo no existe.";

    }

    public String eliminarTorneo(Administrador admin, String nombre) {
        if (inicioT.nombre.equals(nombre) & inicioT.admin.nombre.equals(admin.nombre)) {
            Partidos auxPA = inicioT.SubPartidosA;
            while (auxPA != null) {
                auxPA.equipoA.posicionTorneo = 0;
                auxPA.equipoB.posicionTorneo = 0;
                auxPA = auxPA.sig;
            }
            inicioT = inicioT.sig;
            inicioT.ant = null;
            return " Torneo Eliminado. ";
        }
        Torneo aux = inicioT.sig;
        while (aux.sig != null) {
            if (aux.nombre.equals(nombre) & aux.admin.nombre.equals(admin.nombre)) {
                Partidos auxPA = aux.SubPartidosA;
                while (auxPA != null) {
                    auxPA.equipoA.posicionTorneo = 0;
                    auxPA.equipoB.posicionTorneo = 0;
                    auxPA = auxPA.sig;
                }
                aux.ant.sig = aux.sig;
                aux.sig.ant = aux.ant;
                return " Torneo Eliminado. ";
            }
            aux = aux.sig;
        }
        if (aux.nombre.equals(nombre) & aux.admin.nombre.equals(admin.nombre)) {
            Partidos auxPA = aux.SubPartidosA;
            while (auxPA != null) {
                auxPA.equipoA.posicionTorneo = 0;
                auxPA.equipoB.posicionTorneo = 0;
                auxPA = auxPA.sig;
            }
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
            while (auxPA != null) {
                System.out.print("/ " + auxPA.toString());
                auxPA = auxPA.sig;
            }
            System.out.println(" /");

            aux = aux.sig;
        }
    }

    public String insertarPartidoTorneo(String nombre, Equipo equipoA, Equipo equipoB, Estadio estadio) {
        Torneo auxT = inicioT;
        equipoA.posicionTorneo = 16;
        equipoA.posicionTorneo = 16;
        Partidos nuevo = new Partidos(estadio, equipoA, equipoB);

        while (auxT != null) {

            if (auxT.nombre.equals(nombre)) {

                if (auxT.cantPA < 8) {
                    if (auxT.SubPartidosA == null) {
                        auxT.SubPartidosA = nuevo;
                        auxT.cantPA++;
                        return "Partido insertado";
                    }
                    nuevo.sig = auxT.SubPartidosA;//
                    auxT.SubPartidosA = nuevo;
                    auxT.cantPA++;
                    return "Partido insertado";
                }

            }
            auxT = auxT.sig;
        }
        return " NO existe nigun torneo. ";
    }

    public String insertarPartidoTorneoCuartos(Torneo auxT, Equipo equipoA, Equipo equipoB, Estadio estadio) {
        equipoA.posicionTorneo = 8;
        equipoA.posicionTorneo = 8;
        Partidos nuevo = new Partidos(estadio, equipoA, equipoB);
        if (auxT.cuartosPA == null) {
            auxT.cuartosPA = nuevo;
            return "Partido insertado";
        }
        Partidos auxPA = auxT.cuartosPA;
        while (auxPA.sig != null) {
            auxPA = auxPA.sig;
        }
        auxPA.sig = nuevo;
        return "Partido insertado";
    }

    public String insertarPartidoTorneoSemifinales(Torneo auxT, Equipo equipoA, Equipo equipoB, Estadio estadio) {
        equipoA.posicionTorneo = 4;
        equipoA.posicionTorneo = 4;
        Partidos nuevo = new Partidos(estadio, equipoA, equipoB);
        if (auxT.semifinalesPA == null) {
            auxT.semifinalesPA = nuevo;
            return "Partido insertado";
        }
        Partidos auxPA = auxT.semifinalesPA;
        while (auxPA.sig != null) {
            auxPA = auxPA.sig;
        }
        auxPA.sig = nuevo;
        return "Partido insertado";
    }

    public String insertarPartidoTorneoFinal(Torneo auxT, Equipo equipoA, Equipo equipoB, Estadio estadio) {
        equipoA.posicionTorneo = 2;
        equipoA.posicionTorneo = 2;
        Partidos nuevo = new Partidos(estadio, equipoA, equipoB);
        if (auxT.finalPA == null) {
            auxT.finalPA = nuevo;
            return "Partido insertado";
        }
        nuevo.sig = auxT.finalPA;//
        auxT.finalPA = nuevo;
        return "Partido insertado";
    }

//-------------------------------------------METODOS PROGRA----------------------------------//
    public ArrayList<String> equiposRandom() {
        ArrayList<String> equipos = new ArrayList();
        Equipo auxEq = inicioEq;
        while (auxEq != null) {
            if (auxEq.posicionTorneo == 0 & auxEq.jugadores.size() == 11 & auxEq.entrenador != null) {
                equipos.add(auxEq.nombre);
            }
            if (auxEq == finalEq) {
                break;
            }
            auxEq = auxEq.sig;
        }
        if (equipos.size() < 16) {
            return null;
        }
        while (equipos.size() != 16) {
            int idx = (int) (Math.random() * (equipos.size() - 1));
            equipos.remove(idx);
        }
        return equipos;
    }

    public String asignarEntrenador(Entrenador entrenador, Equipo equipo) {
        if (equipo.entrenador == null & entrenador.equipo == null) {
            equipo.entrenador = entrenador;
            entrenador.equipo = equipo;
            return "Entrenador asignado";
        } else if (equipo.entrenador != null & entrenador.equipo == null) {
            return "El quipo ya tiene un entrenador";
        } else if (entrenador.equipo != null & equipo.entrenador == null) {
            return "El entrenador ya tiene un equipo";
        } else {
            return "El equipo ya tiene entrenador y el entrenador ya tiene equipo";
        }
    }

    public Partidos buscarPartido(String nombreAdmin, String nombreTor, int i) {
        Torneo auxT = buscarTorneo(nombreAdmin, nombreTor);
        Partidos auxPAOct = auxT.SubPartidosA;
        Partidos auxPACuar = auxT.cuartosPA;
        Partidos auxPASemi = auxT.semifinalesPA;
        Partidos auxPAFin = auxT.finalPA;
        int j = 1;
        if (i <= 8) {
            while (auxPAOct != null) {
                if (j == i) {
                    return auxPAOct;
                }
                j++;
                auxPAOct = auxPAOct.sig;
            }
        }
        if (i >= 8 & i <= 12) {
            i -= 8;
            while (auxPACuar != null) {
                if (j == i) {
                    return auxPACuar;
                }
                j++;
                auxPACuar = auxPACuar.sig;
            }
        }
        if (i >= 12 & i <= 14) {
            i -= 12;
            while (auxPASemi != null) {
                if (j == i) {
                    return auxPASemi;
                }
                j++;
                auxPASemi = auxPASemi.sig;
            }
        }
        if (i == 15) {
            i -= 14;
            return auxPAFin;
        }
        return null;
    }

    public String imprmirListaJugadores(Equipo equipo) {
        String jugadores = "";
        for (int i = 0; i < equipo.jugadores.size(); i++) {
            jugadores += "Nombre: " + equipo.jugadores.get(i).nombre + ", ";
            jugadores += "\tApellido: " + equipo.jugadores.get(i).apellido + ", ";
            jugadores += "\tPosición: " + equipo.jugadores.get(i).posicion + ", ";
            int[] habi = equipo.jugadores.get(i).habilidades;
            jugadores += "\tHabilidades( Fis: " + habi[0] + " Def: " + habi[1] + " Dri: " + habi[2] + "Dis: " + habi[3] + "\n";
        }
        return jugadores;
    }
    
    public String imprimirEquiposTorneo(Torneo torneo){
        String equipos = "";
        Partidos auxPA = torneo.SubPartidosA;
        while(auxPA != null){
            equipos += "Equipo: " + auxPA.equipoA.nombre;
            equipos += "\nEquipo: " + auxPA.equipoB.nombre;
            auxPA = auxPA.sig;
        }
        return equipos;
    }
    
    public Jugador buscarGoleador(Equipo equipo){
        Jugador goleador = inicioJ;
        for(int i = 0; i < equipo.jugadores.size();i++){
            if(equipo.jugadores.get(i).goles > goleador.goles){
                goleador = equipo.jugadores.get(i);
            }
        }
        return goleador;
    }
    
    
}
