package progratorneo;

public class Torneo {

    String nombre;
    int[] Premio;
    Administrador admin;
    Partidos SubPartidosA;
    Partidos cuartosPA;
    Partidos semifinalesPA;
    Partidos finalPA;
    Torneo sig;
    Torneo ant;
    int cantPA;
    int entrada;
    boolean torneoActivo;
    int dineroAdmin;

    public Torneo(Administrador admin, String nombre, int[] Premio, int entrada) {
        this.nombre = nombre;
        this.admin = admin;
        this.Premio = Premio;
        this.sig = null;
        this.ant = null;
        this.SubPartidosA = null;
        cuartosPA = null;
        semifinalesPA = null;
        finalPA = null; 
        this.cantPA = 0;
        this.dineroAdmin = 0;
        this.entrada = entrada;
        this.torneoActivo = true;
    }

    @Override
    public String toString() {
        return "Torneo{" + "nombre=" + nombre + ", Premio=" + Premio + ", admin=" + admin + '}';
    }

}
