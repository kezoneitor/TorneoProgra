/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progratorneo;


public class Torneo {
    String [] GrupoA;
    String [] GrupoB;
    int [] Premio;
    Partidos SubPartidos;
    Torneo sig;

    public Torneo(String[] GrupoA, String[] GrupoB, int[] Premio) {
        this.GrupoA = GrupoA;
        this.GrupoB = GrupoB;
        this.Premio = Premio;
        this.sig = null;
        this.SubPartidos= null;
    }
    
    
}
