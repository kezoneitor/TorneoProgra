package progratorneo;

public class Torneo {

    String nombre;
    int[] Premio;
    Administrador admin;
    Partidos SubPartidosA;
    Partidos SubPartidosB;
    Torneo sig;
    Torneo ant;
    int cantPA;
    int cantPB;

    public Torneo(Administrador admin, String nombre, int[] Premio) {
        this.nombre = nombre;
        this.admin = admin;
        this.Premio = Premio;
        this.sig = null;
        this.ant = null;
        this.SubPartidosA = null;
        this.SubPartidosB = null;
        this.cantPA = 0;
        this.cantPB = 0;
    }

    @Override
    public String toString() {
        return "Torneo{" + "nombre=" + nombre + ", Premio=" + Premio + ", admin=" + admin + '}';
    }

}
