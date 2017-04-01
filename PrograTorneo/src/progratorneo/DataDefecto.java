/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progratorneo;

import java.util.ArrayList;

/**
 *
 * @author Kezo
 */
public class DataDefecto {

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
        for (int i = 0; i < Jugadores.size(); i++) {
            if (count != 0) {
                boolean flag = true;
                while (flag) {
                    int pos = (int) (Math.random() * (Jugadores.size() - 1));
                    if (Jugadores.get(pos).size() == 4) {
                        Jugadores.get(pos).add(posiciones[0]);
                        flag = false;
                    }
                }
                count--;
            }
        }
        count = (Jugadores.size() / 11) * 4;
        for (int i = 0; i < Jugadores.size(); i++) {
            if (count != 0) {
                boolean flag = true;
                while (flag) {
                    int pos = (int) (Math.random() * (Jugadores.size() - 1));
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
            int pos = (int) (Math.random() * 3);
            if (Jugadores.get(i).size() == 4) {
                Jugadores.get(i).add(posiciones[pos]);
            }
        }
    }

    public int[] generarHabilidades() {
        int pto1 = (int) (Math.random() * 9) + 1;
        int pto2 = (int) (Math.random() * 9) + 1;
        int pto3 = (int) (Math.random() * 9) + 1;
        int pto4 = (int) (Math.random() * 9) + 1;
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
}
