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

    //---------Listas Genericas, de datos por defecto -------------//
    ArrayList<Entrenador> listaEntrenadorG = new ArrayList();
    ArrayList<Equipo> listaEquiposG = new ArrayList();
    ArrayList<Estadio> listaEstadioG = new ArrayList();
    ArrayList<ArrayList> listaEqJugadoresG = new ArrayList();

    ArrayList<ArrayList> Jugadores = new ArrayList();// matriz 
    ArrayList<String> listNombre = new ArrayList();
    ArrayList<String> listApellido = new ArrayList();

    //------------------------------------------------------------//
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

    public void crearEquipo() { // crea el equipo y alli mismo se crea en entrenador y se agrega al equipo.

        String[] camisa1 = {"progratorneo/camisas/color/camisaAmarilla.png", "progratorneo/camisas/cruz/camisaNegra.png"};
        Equipo equipo1 = new Equipo("Barcelona", camisa1);
        Entrenador entrenador1 = new Entrenador("Yeiner", "Iled");
        entrenador1.equipo = equipo1;
        equipo1.entrenador = entrenador1;

        String[] camisa2 = {"progratorneo/camisas/color/camisaAnaranjada.png", "progratorneo/camisas/cruz/camisaVerde.png"};
        Equipo equipo2 = new Equipo("Bayern", camisa2);
        Entrenador entrenador2 = new Entrenador("Yeiner", "Carranza");
        entrenador2.equipo = equipo2;
        equipo2.entrenador = entrenador2;

        String[] camisa3 = {"progratorneo/camisas/color/camisaAzul.png", "progratorneo/camisas/cruz/camisaRoja.png"};
        Equipo equipo3 = new Equipo("Arsenal", camisa3);
        Entrenador entrenador3 = new Entrenador("Yeiner", "Now");
        entrenador3.equipo = equipo3;
        equipo3.entrenador = entrenador3;

        String[] camisa4 = {"progratorneo/camisas/color/camisaBlanca.png", "progratorneo/camisas/cruz/camisaNegra.png"};
        Equipo equipo4 = new Equipo("PSG", camisa4);
        Entrenador entrenador4 = new Entrenador("Yeiner", "Oil");
        entrenador4.equipo = equipo4;
        equipo4.entrenador = entrenador4;

        String[] camisa5 = {"progratorneo/camisas/color/camisaCeleste.png", "progratorneo/camisas/cruz/camisaMorada.png"};
        Equipo equipo5 = new Equipo("Celtic F. C.", camisa5);
        Entrenador entrenador5 = new Entrenador("Yeiner", "Bottle");
        entrenador5.equipo = equipo5;
        equipo5.entrenador = entrenador5;

        String[] camisa6 = {"progratorneo/camisas/color/camisaMorada.png", "progratorneo/camisas/cruz/camisaCeleste.png"};
        Equipo equipo6 = new Equipo("Mónaco", camisa6);
        Entrenador entrenador6 = new Entrenador("Yeiner", "Do not Panic");
        entrenador6.equipo = equipo6;
        equipo6.entrenador = entrenador6;

        String[] camisa7 = {"progratorneo/camisas/color/camisaNegra.png", "progratorneo/camisas/cruz/camisaBlanca.png"};
        Equipo equipo7 = new Equipo("Dortmund", camisa7);
        Entrenador entrenador7 = new Entrenador("Yeiner", "Ant");
        entrenador7.equipo = equipo7;
        equipo1.entrenador = entrenador7;

        String[] camisa8 = {"progratorneo/camisas/color/camisaRoja.png", "progratorneo/camisas/cruz/camisaAzul.png"};
        Equipo equipo8 = new Equipo("Leverkusen", camisa8);
        Entrenador entrenador8 = new Entrenador("Yeiner", "Altefecuatro");
        entrenador8.equipo = equipo8;
        equipo8.entrenador = entrenador8;

        String[] camisa9 = {"progratorneo/camisas/color/camisaVerde.png", "progratorneo/camisas/cruz/camisaAnaranjada.png"};
        Equipo equipo9 = new Equipo("Lyon", camisa9);
        Entrenador entrenador9 = new Entrenador("Paquita", "Iled");
        entrenador9.equipo = equipo9;
        equipo9.entrenador = entrenador9;

        String[] camisa10 = {"progratorneo/camisas/color/camisaVioleta.png", "progratorneo/camisas/cruz/camisaAmarilla.png"};
        Equipo equipo10 = new Equipo("Atlético Madrid", camisa10);
        Entrenador entrenador10 = new Entrenador("Paquita", "Carranza");
        entrenador10.equipo = equipo10;
        equipo10.entrenador = entrenador10;

        String[] camisa11 = {"progratorneo/camisas/color/camisaAmarilla.png", "progratorneo/camisas/cruz/camisaVioleta.png"};
        Equipo equipo11 = new Equipo("Napoli", camisa11);
        Entrenador entrenador11 = new Entrenador("Paquita", "Now");
        entrenador11.equipo = equipo11;
        equipo11.entrenador = entrenador11;

        String[] camisa12 = {"progratorneo/camisas/color/camisaAnaranjada.png", "progratorneo/camisas/rayas/camisaNegra.png"};
        Equipo equipo12 = new Equipo("Real Madrid", camisa12);
        Entrenador entrenador12 = new Entrenador("Paquita", "Oil");
        entrenador12.equipo = equipo12;
        equipo12.entrenador = entrenador12;

        String[] camisa13 = {"progratorneo/camisas/color/camisaAzul.png", "progratorneo/camisas/rayas/camisaBlanca.png"};
        Equipo equipo13 = new Equipo("Juventus", camisa13);
        Entrenador entrenador13 = new Entrenador("Paquita", "Bottle");
        entrenador13.equipo = equipo13;
        equipo13.entrenador = entrenador13;

        String[] camisa14 = {"progratorneo/camisas/color/camisaBlanca.png", "progratorneo/camisas/rayas/camisaRoja.png"};
        Equipo equipo14 = new Equipo("Sevilla", camisa14);
        Entrenador entrenador14 = new Entrenador("Paquita", "Do Not Panic");
        entrenador14.equipo = equipo14;
        equipo14.entrenador = entrenador14;

        String[] camisa15 = {"progratorneo/camisas/color/camisaCeleste.png", "progratorneo/camisas/rayas/camisaVioleta.png"};
        Equipo equipo15 = new Equipo("Porto", camisa15);
        Entrenador entrenador15 = new Entrenador("Paquita", "Ant");
        entrenador15.equipo = equipo15;
        equipo15.entrenador = entrenador15;

        String[] camisa16 = {"progratorneo/camisas/color/camisaMorada.png", "progratorneo/camisas/rayas/camisaBlanca.png"};
        Equipo equipo16 = new Equipo("Dinamo", camisa16);
        Entrenador entrenador16 = new Entrenador("Paquita", "Altefecuatro");
        entrenador16.equipo = equipo16;
        equipo16.entrenador = entrenador16;

        String[] camisa17 = {"progratorneo/camisas/color/camisaNegra.png", "progratorneo/camisas/rayas/camisaRoja.png"};
        Equipo equipo17 = new Equipo("Manchester City F.C", camisa17);
        Entrenador entrenador17 = new Entrenador("Pepe", "Iled");
        entrenador17.equipo = equipo17;
        equipo17.entrenador = entrenador17;

        String[] camisa18 = {"progratorneo/camisas/color/camisaRoja.png", "progratorneo/camisas/rayas/camisaVerde.png"};
        Equipo equipo18 = new Equipo("PSV", camisa18);
        Entrenador entrenador18 = new Entrenador("Pepe", "Carranza");
        entrenador18.equipo = equipo18;
        equipo18.entrenador = entrenador18;

        String[] camisa19 = {"progratorneo/camisas/color/camisaVerde.png", "progratorneo/camisas/rayas/camisaAmarilla.png"};
        Equipo equipo19 = new Equipo("Sporting Lisboa", camisa19);
        Entrenador entrenador19 = new Entrenador("Pepe", "Now");
        entrenador19.equipo = equipo19;
        equipo19.entrenador = entrenador19;

        String[] camisa20 = {"progratorneo/camisas/color/camisaVioleta.png", "progratorneo/camisas/rayas/camisaBlanca.png"};
        Equipo equipo20 = new Equipo("Benfica", camisa20);
        Entrenador entrenador20 = new Entrenador("Pepe", "Oil");
        entrenador20.equipo = equipo20;
        equipo20.entrenador = entrenador20;

        String[] camisa21 = {"progratorneo/camisas/color/camisaAmarilla.png", "progratorneo/camisas/rayas/camisaAzul.png"};
        Equipo equipo21 = new Equipo("Club Brujas", camisa21);
        Entrenador entrenador21 = new Entrenador("Pepe", "Bottle");
        entrenador21.equipo = equipo21;
        equipo21.entrenador = entrenador21;

        String[] camisa22 = {"progratorneo/camisas/color/camisaAnaranjada.png", "progratorneo/camisas/rayas/camisaMorada.png"};
        Equipo equipo22 = new Equipo("Tottenham", camisa22);
        Entrenador entrenador22 = new Entrenador("Pepe", "Do Not Panic");
        entrenador22.equipo = equipo22;
        equipo22.entrenador = entrenador22;

        String[] camisa23 = {"progratorneo/camisas/color/camisaAzul.png", "progratorneo/camisas/tresVertical/camisaVioleta.png"};
        Equipo equipo23 = new Equipo("Legia", camisa23);
        Entrenador entrenador23 = new Entrenador("Pepe", "Ant");
        entrenador23.equipo = equipo23;
        equipo23.entrenador = entrenador23;

        String[] camisa24 = {"progratorneo/camisas/color/camisaBlanca.png", "progratorneo/camisas/tresVertical/camisaCeleste.png"};
        Equipo equipo24 = new Equipo("København", camisa24);
        Entrenador entrenador24 = new Entrenador("Pepe", "Altefecuatro");
        entrenador24.equipo = equipo24;
        equipo24.entrenador = entrenador24;

        String[] camisa25 = {"progratorneo/camisas/color/camisaCeleste.png", "progratorneo/camisas/tresVertical/camisaNegra.png"};
        Equipo equipo25 = new Equipo("Rostov", camisa25);
        Entrenador entrenador25 = new Entrenador("Pinto", "Iled");
        entrenador25.equipo = equipo25;
        equipo25.entrenador = entrenador25;

        String[] camisa26 = {"progratorneo/camisas/color/camisaMorada.png", "progratorneo/camisas/tresVertical/camisaAnaranjada.png"};
        Equipo equipo26 = new Equipo("Leicester City", camisa26);
        Entrenador entrenador26 = new Entrenador("Pinto", "Carranza");
        entrenador26.equipo = equipo26;
        equipo26.entrenador = entrenador26;

        String[] camisa27 = {"progratorneo/camisas/color/camisaNegra.png", "progratorneo/camisas/tresVertical/camisaAmarilla.png"};
        Equipo equipo27 = new Equipo("Dinamo Zagreb", camisa27);
        Entrenador entrenador27 = new Entrenador("Pinto", "Now");
        entrenador27.equipo = equipo27;
        equipo27.entrenador = entrenador27;

        String[] camisa28 = {"progratorneo/camisas/color/camisaRoja.png", "progratorneo/camisas/tresVertical/camisaBlanca.png"};
        Equipo equipo28 = new Equipo("Mönchengladbach", camisa28);
        Entrenador entrenador28 = new Entrenador("Pinto", "Oil");
        entrenador28.equipo = equipo28;
        equipo28.entrenador = entrenador28;

        String[] camisa29 = {"progratorneo/camisas/color/camisaVerde.png", "progratorneo/camisas/tresVertical/camisaAzul.png"};
        Equipo equipo29 = new Equipo("Basel", camisa29);
        Entrenador entrenador29 = new Entrenador("Pinto", "Bottle");
        entrenador29.equipo = equipo29;
        equipo29.entrenador = entrenador29;

        String[] camisa30 = {"progratorneo/camisas/color/camisaVioleta.png", "progratorneo/camisas/tresVertical/camisaNegra.png"};
        Equipo equipo30 = new Equipo("Ludogorets", camisa30);
        Entrenador entrenador30 = new Entrenador("Pinto", "Do Not Panic");
        entrenador30.equipo = equipo30;
        equipo30.entrenador = entrenador30;

        String[] camisa31 = {"progratorneo/camisas/color/camisaBlanca.png", "progratorneo/camisas/tresVertical/camisaAmarilla.png"};
        Equipo equipo31 = new Equipo("Beşiktaş JK", camisa31);
        Entrenador entrenador31 = new Entrenador("Pinto", "Ant");
        entrenador31.equipo = equipo31;
        equipo31.entrenador = entrenador31;

        String[] camisa32 = {"progratorneo/camisas/color/camisaNegra.png", "progratorneo/camisas/tresVertical/camisaAzul.png"};
        Equipo equipo32 = new Equipo("CSKA Moscú", camisa32);
        Entrenador entrenador32 = new Entrenador("Pinto", "Altefecuatro");
        entrenador32.equipo = equipo32;
        equipo32.entrenador = entrenador32;

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

        //---lista Entrenador-----//
        listaEntrenadorG.add(entrenador1);
        listaEntrenadorG.add(entrenador2);
        listaEntrenadorG.add(entrenador3);
        listaEntrenadorG.add(entrenador4);
        listaEntrenadorG.add(entrenador5);
        listaEntrenadorG.add(entrenador6);
        listaEntrenadorG.add(entrenador7);
        listaEntrenadorG.add(entrenador8);
        listaEntrenadorG.add(entrenador9);
        listaEntrenadorG.add(entrenador10);
        listaEntrenadorG.add(entrenador11);
        listaEntrenadorG.add(entrenador12);
        listaEntrenadorG.add(entrenador13);
        listaEntrenadorG.add(entrenador14);
        listaEntrenadorG.add(entrenador15);
        listaEntrenadorG.add(entrenador16);
        listaEntrenadorG.add(entrenador17);
        listaEntrenadorG.add(entrenador18);
        listaEntrenadorG.add(entrenador19);
        listaEntrenadorG.add(entrenador20);
        listaEntrenadorG.add(entrenador21);
        listaEntrenadorG.add(entrenador22);
        listaEntrenadorG.add(entrenador23);
        listaEntrenadorG.add(entrenador24);
        listaEntrenadorG.add(entrenador25);
        listaEntrenadorG.add(entrenador26);
        listaEntrenadorG.add(entrenador27);
        listaEntrenadorG.add(entrenador28);
        listaEntrenadorG.add(entrenador29);
        listaEntrenadorG.add(entrenador30);
        listaEntrenadorG.add(entrenador31);
        listaEntrenadorG.add(entrenador32);

    }

    public void CrearEstadioPorDefecto() {

        Estadio estadio1 = new Estadio("Camp Nou", "España", 99354);
        Estadio estadio2 = new Estadio("Wembley", "Inglaterra", 90000);
        Estadio estadio3 = new Estadio("Croke Park", "Irlanda", 82300);
        Estadio estadio4 = new Estadio("Juventus Stadium", "Italia", 46000);
        Estadio estadio5 = new Estadio("Allianz Arena", "Alemania", 69901);

        listaEstadioG.add(estadio1);
        listaEstadioG.add(estadio2);
        listaEstadioG.add(estadio3);
        listaEstadioG.add(estadio4);
        listaEstadioG.add(estadio5);
    }
        
}
