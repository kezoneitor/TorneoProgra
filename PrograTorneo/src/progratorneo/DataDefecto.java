/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progratorneo;

import static java.lang.Math.random;
import java.util.ArrayList;

/**
 *
 * @author Kezo
 */
public class DataDefecto {
    
    ArrayList<Equipo> listaEquiposG =  new ArrayList();
    ArrayList<ArrayList> Jugadores = new ArrayList();// matriz 
    ArrayList<String> listNombre = new ArrayList();
    ArrayList<String> listApellido = new ArrayList();

    //Ubicacion de la camisa
    String[] estampado = {"/cruz", "/rayas", "/tresVertical"};
    String[] colores = {"/camisaAmarilla.png", "/camisaAnaranjada.png", "/camisaAzul.png", "/camisaBlanca.png", "/camisaCeleste.png", "/camisaMorada.png", "/camisaNegra.png", "/camisaRoja.png", "/camisaVerde.png", "/camisaVioleta.png"};

    public void AgregarNombreApellido() {
        //Nombres
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
        listNombre.add("Jafeth");
        listNombre.add("Ibrahimovic");
        listNombre.add("Carlos");

        //Apellidos
        listApellido.add("manantial");
        listApellido.add("Tevez");
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
        listApellido.add("Bubble");
        listApellido.add("moon");

    }

    public void CrearJugadores() {
        for (int i = 0; i < listNombre.size(); i++) {
            for (int j = 0; j < listApellido.size(); j++) {
                ArrayList jugador = new ArrayList();
                int[] habilidades = generarHabilidades();
                int precio = precio(habilidades);
                jugador.add(listNombre.get(i));
                jugador.add(listApellido.get(j));
                jugador.add(habilidades);
                jugador.add(precio);
                Jugadores.add(jugador);
            }
        }
        String[] posiciones = {"portero", "defensa", "medio", "delantero"};
        int count = (Jugadores.size() / 11);
        for (ArrayList Jugadore : Jugadores) {
            if (count != 0) {
                boolean flag = true;
                while (flag) {
                    int pos = (int) (random() * (Jugadores.size() - 1));
                    if (Jugadores.get(pos).size() == 4) {
                        Jugadores.get(pos).add(posiciones[0]);
                        flag = false;
                    }
                }
                count--;
            }
        }
        count = (Jugadores.size() / 11) * 4;
        for (ArrayList Jugadore : Jugadores) {
            if (count != 0) {
                boolean flag = true;
                while (flag) {
                    int pos = (int) (random() * (Jugadores.size() - 1));
                    if (Jugadores.get(pos).size() == 4) {
                        Jugadores.get(pos).add(posiciones[1]);
                        flag = false;
                    }
                }
                count--;
            }
        }
        count = (Jugadores.size() / 11) * 4;
        for (int i = 0; i < Jugadores.size(); i++) {
            if (count != 0 & Jugadores.get(i).size() == 4) {
                Jugadores.get(i).add(posiciones[2]);
                count--;
            }
        }
        count = (Jugadores.size() / 11) * 2;
        for (int i = 0; i < (Jugadores.size() / 11) * 2; i++) {
            if (count != 0 & Jugadores.get(i).size() == 4) {
                Jugadores.get(i).add(posiciones[3]);
                count--;
            }
        }
        for (int i = 0; i < Jugadores.size(); i++) {
            int pos = (int) (random() * 3);
            if (Jugadores.get(i).size() == 4) {
                Jugadores.get(i).add(posiciones[pos]);
            }
        }
    }

    public int[] generarHabilidades() {
        int pto1 = (int) (random() * 9) + 1;
        int pto2 = (int) (random() * 9) + 1;
        int pto3 = (int) (random() * 9) + 1;
        int pto4 = (int) (random() * 9) + 1;
        int[] habilidades = {pto1, pto2, pto3, pto4};
        return habilidades;
    }

    public int precio(int[] habilidades) {
        int precio = 0;
        precio += (habilidades[0] * 15000);
        precio += (habilidades[1] * 30000);
        precio += (habilidades[2] * 40000);
        precio += (habilidades[3] * 100000);
        return precio;
    }
    
    public void crearEquipo(){
        
    String[] camisa1 = { "progratorneo/camisas/color/camisaAmarilla.png","progratorneo/camisas/cruz/camisaNegra.png" };
    Equipo equipo1 = new Equipo("Barcelona",camisa1); 
    
    String[] camisa2 = { "progratorneo/camisas/color/camisaAnaranjada.png","progratorneo/camisas/cruz/camisaVerde.png" };
    Equipo equipo2 = new Equipo("Bayern",camisa2); 
    
    String[] camisa3 = { "progratorneo/camisas/color/camisaAzul.png","progratorneo/camisas/cruz/camisaRoja.png" };
    Equipo equipo3 = new Equipo("Arsenal",camisa3); 
    
    String[] camisa4 = { "progratorneo/camisas/color/camisaBlanca.png","progratorneo/camisas/cruz/camisaNegra.png" };
    Equipo equipo4 = new Equipo("PSG",camisa4); 
    
    String[] camisa5 = { "progratorneo/camisas/color/camisaCeleste.png","progratorneo/camisas/cruz/camisaMorada.png" };
    Equipo equipo5 = new Equipo("Celtic F. C.",camisa5); 
    
    String[] camisa6 = { "progratorneo/camisas/color/camisaMorada.png","progratorneo/camisas/cruz/camisaCeleste.png" };
    Equipo equipo6 = new Equipo("Mónaco",camisa6); 
    
    String[] camisa7 = { "progratorneo/camisas/color/camisaNegra.png","progratorneo/camisas/cruz/camisaBlanca.png" };
    Equipo equipo7 = new Equipo("Dortmund",camisa7); 
    
    String[] camisa8 = { "progratorneo/camisas/color/camisaRoja.png","progratorneo/camisas/cruz/camisaAzul.png" };
    Equipo equipo8 = new Equipo("Leverkusen",camisa8); 
    
    String[] camisa9 = { "progratorneo/camisas/color/camisaVerde.png","progratorneo/camisas/cruz/camisaAnaranjada.png" };
    Equipo equipo9 = new Equipo("Lyon",camisa9); 
    
    String[] camisa10 = { "progratorneo/camisas/color/camisaVioleta.png","progratorneo/camisas/cruz/camisaAmarilla.png" };
    Equipo equipo10 = new Equipo("Atlético Madrid",camisa10); 
    
    String[] camisa11 = { "progratorneo/camisas/color/camisaAmarilla.png","progratorneo/camisas/cruz/camisaVioleta.png" };
    Equipo equipo11 = new Equipo("Napoli",camisa11); 
    
    String[] camisa12 = { "progratorneo/camisas/color/camisaAnaranjada.png","progratorneo/camisas/rayas/camisaNegra.png" };
    Equipo equipo12 = new Equipo("Real Madrid",camisa12); 
    
    String[] camisa13 = { "progratorneo/camisas/color/camisaAzul.png","progratorneo/camisas/rayas/camisaBlanca.png" };
    Equipo equipo13 = new Equipo("Juventus",camisa13); 
    
    String[] camisa14 = { "progratorneo/camisas/color/camisaBlanca.png","progratorneo/camisas/rayas/camisaRoja.png" };
    Equipo equipo14 = new Equipo("Sevilla",camisa14); 
    
    String[] camisa15 = { "progratorneo/camisas/color/camisaCeleste.png","progratorneo/camisas/rayas/camisaVioleta.png" };
    Equipo equipo15 = new Equipo("Porto",camisa15); 
    
    String[] camisa16 = { "progratorneo/camisas/color/camisaMorada.png","progratorneo/camisas/rayas/camisaBlanca.png" };
    Equipo equipo16 = new Equipo("Dinamo",camisa16); 
    
    String[] camisa17 = { "progratorneo/camisas/color/camisaNegra.png","progratorneo/camisas/rayas/camisaRoja.png" };
    Equipo equipo17 = new Equipo("Manchester City F.C",camisa17); 
    
    String[] camisa18 = { "progratorneo/camisas/color/camisaRoja.png","progratorneo/camisas/rayas/camisaVerde.png" };
    Equipo equipo18 = new Equipo("PSV",camisa18); 
    
    String[] camisa19 = { "progratorneo/camisas/color/camisaVerde.png","progratorneo/camisas/rayas/camisaAmarilla.png" };
    Equipo equipo19 = new Equipo("Sporting Lisboa",camisa19); 
    
    String[] camisa20 = { "progratorneo/camisas/color/camisaVioleta.png","progratorneo/camisas/rayas/camisaBlanca.png" };
    Equipo equipo20 = new Equipo("Benfica",camisa20); 
    
    String[] camisa21 = { "progratorneo/camisas/color/camisaAmarilla.png","progratorneo/camisas/rayas/camisaAzul.png" };
    Equipo equipo21 = new Equipo("Club Brujas",camisa21); 
    
    String[] camisa22 = { "progratorneo/camisas/color/camisaAnaranjada.png","progratorneo/camisas/rayas/camisaMorada.png" };
    Equipo equipo22 = new Equipo("Tottenham",camisa22); 
    
    String[] camisa23 = { "progratorneo/camisas/color/camisaAzul.png","progratorneo/camisas/tresVertical/camisaVioleta.png" };
    Equipo equipo23 = new Equipo("Legia",camisa23); 
    
    String[] camisa24 = { "progratorneo/camisas/color/camisaBlanca.png","progratorneo/camisas/tresVertical/camisaCeleste.png" };
    Equipo equipo24 = new Equipo("København",camisa24); 
    
    String[] camisa25 = { "progratorneo/camisas/color/camisaCeleste.png","progratorneo/camisas/tresVertical/camisaNegra.png" };
    Equipo equipo25 = new Equipo("Rostov",camisa25); 
    
    String[] camisa26 = { "progratorneo/camisas/color/camisaMorada.png","progratorneo/camisas/tresVertical/camisaAnaranjada.png" };
    Equipo equipo26 = new Equipo("Leicester City",camisa26); 
    
    String[] camisa27 = { "progratorneo/camisas/color/camisaNegra.png","progratorneo/camisas/tresVertical/camisaAmarilla.png" };
    Equipo equipo27 = new Equipo("Dinamo Zagreb",camisa27); 
    
    String[] camisa28 = { "progratorneo/camisas/color/camisaRoja.png","progratorneo/camisas/tresVertical/camisaBlanca.png" };
    Equipo equipo28 = new Equipo("Mönchengladbach",camisa28); 
    
    String[] camisa29 = { "progratorneo/camisas/color/camisaVerde.png","progratorneo/camisas/tresVertical/camisaAzul.png" };
    Equipo equipo29 = new Equipo("Basel",camisa29); 
    
    String[] camisa30 = { "progratorneo/camisas/color/camisaVioleta.png","progratorneo/camisas/tresVertical/camisaNegra.png" };
    Equipo equipo30 = new Equipo("Ludogorets",camisa30); 
    
    String[] camisa31 = { "progratorneo/camisas/color/camisaBlanca.png","progratorneo/camisas/tresVertical/camisaAmarilla.png" };
    Equipo equipo31 = new Equipo("Beşiktaş JK",camisa31); 
    
    String[] camisa32 = { "progratorneo/camisas/color/camisaNegra.png","progratorneo/camisas/tresVertical/camisaAzul.png" };
    Equipo equipo32 = new Equipo("CSKA Moscú",camisa32); 
        
    listaEquiposG.add(equipo1);
    listaEquiposG.add(equipo2);
    listaEquiposG.add(equipo3);
    listaEquiposG.add(equipo4);
    listaEquiposG.add(equipo5);
    listaEquiposG.add(equipo6);
    listaEquiposG.add(equipo7);
    listaEquiposG.add(equipo8);
    listaEquiposG.add(equipo9);
    listaEquiposG.add(equipo10);
    listaEquiposG.add(equipo11);
    listaEquiposG.add(equipo12);
    listaEquiposG.add(equipo13);
    listaEquiposG.add(equipo14);
    listaEquiposG.add(equipo15);
    listaEquiposG.add(equipo16);
    listaEquiposG.add(equipo1);
    listaEquiposG.add(equipo17);
    listaEquiposG.add(equipo18);
    listaEquiposG.add(equipo19);
    listaEquiposG.add(equipo20);
    listaEquiposG.add(equipo21);
    listaEquiposG.add(equipo22);
    listaEquiposG.add(equipo23);
    listaEquiposG.add(equipo24);
    listaEquiposG.add(equipo25);
    listaEquiposG.add(equipo26);
    listaEquiposG.add(equipo27);
    listaEquiposG.add(equipo28);
    listaEquiposG.add(equipo29);
    listaEquiposG.add(equipo30);
    listaEquiposG.add(equipo31);
    listaEquiposG.add(equipo32);
    
   
    }
   
    
}
