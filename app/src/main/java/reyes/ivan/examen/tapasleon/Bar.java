package reyes.ivan.examen.tapasleon;

/**
 * Created by ivan on 4/12/14.
 */
public class Bar {
    private String Nombre;
    private String Direccion;

    public Bar(String nombre, String direccion) {
        Nombre = nombre;
        Direccion = direccion;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
