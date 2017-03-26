

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
        this.sig= null;
    }  
}
