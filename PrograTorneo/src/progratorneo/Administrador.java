/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progratorneo;

/**
 *
 * @author Kezo
 */
public class Administrador {
    String [] listTorneo;
    String nombre;
    String clave;
    int dinero;

    public Administrador(String nombre, String clave, int dinero) {
        this.nombre = nombre;
        this.clave = clave;
        this.dinero = dinero;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
        

}
