package progratorneo;

/**
 *
 * @author Julio Cesar
 */
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
        while(aux != null){
            if(aux.nombre.equals(nombre) & aux.clave.equals(clave)){
                return aux;
            }
            aux = aux.sig;
        }
        return null;
    }

    public Entrenador buscarEntrenador(String nombre) {
        Entrenador aux = inicioEn;
        while (aux != null) {
            if (aux.nombre.equals(nombre)) {
                return aux;
            }
            if(aux == finalEn){
                return null;
            }
            aux = aux.sig;
        }
        return null;
    }

    public Jugador buscarJugador(String nombre) {
        Jugador aux = inicioJ;
        while (aux != null) {
            if (aux.nombre.equals(nombre)) {
                return aux;
            }
            aux = aux.sig;
        }
        return null;
    }
}
