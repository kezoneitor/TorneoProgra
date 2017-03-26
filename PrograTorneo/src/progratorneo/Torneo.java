
package progratorneo;

public class Torneo {

    String[] GrupoA;
    String[] GrupoB;
    int[] Premio;
    Partidos SubPartidos;
    Torneo sig;

    public Torneo(String[] GrupoA, String[] GrupoB, int[] Premio) {
        this.GrupoA = null;
        this.GrupoB = null;
        this.Premio = Premio;
        this.sig = null;
        this.SubPartidos = null;
    }

}
