/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progratorneo;


public class Administrador {
    String nombre;
    String clave;
    int dinero;
    Administrador sig;

    public Administrador(String nombre, String clave, int dinero) {
        this.nombre = nombre;
        this.clave = clave;
        this.dinero = dinero;
    }  
}
