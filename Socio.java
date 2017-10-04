import java.util.*;


/**
 * Clase abstracta socio.
 * 
 * @author Jos� Bord�n
 * @version 1.0
 */
public abstract class Socio
{
    //Variables de instancia
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList<Prestamo> prestamos;
    
    //Accesors
    public void setDniSocio(int p_dniSocio) {this.dniSocio = p_dniSocio;}
    public void setNombre(String p_nombre) {this.nombre = p_nombre;}
    public void setDiasPrestamo(int p_dias) {this.diasPrestamo = p_dias;}
    public void setPrestamos(ArrayList<Prestamo> p_prestamos) {this.prestamos = p_prestamos;}
    public int getDniSocio() {return this.dniSocio;}
    public String getNombre() {return this.nombre;}
    public int getDiasPrestamo() {return this.diasPrestamo;}
    public ArrayList<Prestamo> getPrestamos() {return this.prestamos;}
    
    /**
     * Método constructor. Recibe el nombre como parámetro.
     */
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo) {
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<Prestamo>() );
    }
    
    /**
     * Método constructor. No recibe el nombre, el mismo se inicializa en una cadena vacía.
     */
    public Socio(int p_idSocio, int p_diasPrestamo) {
        this.setDniSocio(p_idSocio);
        this.setNombre("");
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList<Prestamo>() );
    }
    
    /**
     * Añade un préstamo a la colección
     * @param p_prestamo Préstamo a añadir.
     */
    public boolean addPrestamo(Prestamo p_prestamo) {
        return this.getPrestamos().add(p_prestamo);
    }
    
    /**
     * Quita un préstamo de la colección
     * @param p_prestamo Préstamo a quitar.
     */
    public boolean removePrestamo(Prestamo p_prestamo) {
        return this.getPrestamos().remove(p_prestamo);
    }
    
    /**
     * Devuelve la cantidad de libros prestados al socio.
     * @return Cantidad de libros.
     */
    public int cantLibrosPrestados() {
        return this.getPrestamos().size();
    }
    
    /**
     * Devuelve una cadena con información del socio.
     * @return Cadena de caracteres de la forma D.N.I.: <<dni>> || <<nombre y apellido>> ([Docente|Estudiante])
     */
    public String toString() {
        return ("D.N.I.: " + this.getDniSocio() + " || " + this.getNombre() + " (" + this.soyDeLaClase() + ")");
    }
    
    /**
     * Método abstracto soy de la clase. Devolverá una cadena con la clase del objeto. Será redefinida en clases sucesoras.
     */
    public abstract String soyDeLaClase();
    
    /**
     * Continuar con la clase Prestamo para terminar este método.
     */
    public boolean puedePedir() {
        return true;
    }
}
