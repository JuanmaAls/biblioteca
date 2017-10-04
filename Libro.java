import java.util.*;
/**
 * Clase Libro
 * 
 */
public class Libro{
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList <Prestamo> prestamos;

    /**
     * Constructor con los siguientes parametros:
     * p_titulo de tipo String para el titulo del libro, p_edicion de tipo int para la edicion del libro, 
     * p_editorial de tipo int para la editorial del libro y p_anio de tipo int para el anio de emision del libro. 
     */

    public Libro (String p_titulo, int p_edicion, String p_editorial, int p_anio){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList());
    }

  
    /**
     * Asigna un valor al atributo titulo.
     * @param: p_titulo de tipo String
     */

    private void setTitulo(String p_titulo){
        this.titulo = p_titulo;
    }

    /**
     * Asigna un valor al atributo edicion.
     * @param: p_edicion de tipo int.
     */

    private void setEdicion(int p_edicion){
        this.edicion = p_edicion;
    }

    /**
     * Asigna un valor al atributo editorial.
     * @param: p_editorial de tipo String.
     */

    private void setEditorial(String p_editorial){
        this.editorial = p_editorial;
    }

    /**
     * Asigna un valor al atributo anio.
     * @param: p_anio de tipo int.
     */
    private void setAnio(int p_anio){
        this.anio = p_anio;
    }

    /**
     * Asigna un valor al atributo prestamo.
     * @param: p_prestamos de tipo ArrayList.
     */
    private void setPrestamos(ArrayList<Prestamo> p_prestamos){
        this.prestamos = p_prestamos;
    }
    
    /**
     * Retorna la coleccion de prestamos.
     * @param: p_prestamo de tipo Presatamo.
     */
    
    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }
    /**
     * Retorna el valor del atributo titulo.
     * @return: titulo de tipo String.
     */
    public String getTitulo(){
        return this.titulo;
    }

    /**
     * Retorna el valor del atributo edicion.
     * @return: edicion de tipo int.
     */
    public int getEdicion(){
        return this.edicion;
    }

    /**
     * Retorna el valor del atributo editorial.
     * @return: editorial de tipo String.
     */
    public String getEditorial(){
        return this.editorial;
    }

    /**
     * Retorna el valor del atributo anio.
     * @return: anio de tipo int.
     */
    public int getAnio(){
        return this.anio;
    }

    /**
     * Retorna la coleccion del atributo prestamos.
     * @return: prestamos de tipo ArrayList.
     */
    public Prestamo getPrestamo(){
        Prestamo aux = null;
        if (this.getPrestamos().size() != 0){
           aux = this.getPrestamos().get(this.getPrestamos().size()-1);
        }
        
        return aux;
    }

    /**
     * Agrega un prestamo a la coleccion de prestamos.
     * @param: p_prestamo de tipo Prestamo.
     */
    public void addPrestamo(Prestamo p_prestamo){
        this.getPrestamos().add(p_prestamo);
    }
    
    /***
     * Retorna true si el libro se encuentra prestado, false en caso contrario.
     */
    public boolean prestado(){
       if (this.getPrestamos().size() == 0){
           return false;
        }
        else{return true;}        
       
    }
    
    
    /**
     * Imprime el titulo del libro.
     */
    
    public String toString(){
        return ("Titulo: "+this.getTitulo());
    }
    
    /**
     * Elimina un prestamo de la coleccion de prestamos.
     * @param: p_prestamo de tipo Prestamo.
     */
    public void removePrestamo(Prestamo p_prestamo){
        this.getPrestamos().remove(p_prestamo);
    }
    }

