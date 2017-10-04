import java.util.*;


/**
 * Abstracción de un préstamo de un libro.
 * 
 * @author José Bordón
 * @version 1.0
 */
public class Prestamo
{
    //Variables de instancia
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Socio socio;
    private Libro libro;
    
    //Accesors
    private void setFechaRetiro(Calendar p_fechaRetiro) {this.fechaRetiro = p_fechaRetiro;}
    public void setFechaDevolucion(Calendar p_fechaDevolucion) {this.fechaDevolucion = p_fechaDevolucion;}
    private void setSocio(Socio p_socio) {this.socio = p_socio;}
    private void setLibro(Libro p_libro) {this.libro = p_libro;}
    public Calendar getFechaRetiro() {return this.fechaRetiro;}
    public Calendar getFechaDevolucion() {return this.fechaDevolucion;}
    public Socio getSocio() {return this.socio;}
    public Libro getLibro() {return this.libro;}
    
    /**
     * Método constructor. Recibe la fecha de retiro como parametro.
     */
    public Prestamo(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro) {
        this.setFechaRetiro(p_fechaRetiro);
        Calendar fechaAux = p_fechaRetiro;
        // Se almacena en fechaAux la fecha de devoluciÃ³n. Se aÃ±ade los dÃ­as de prÃ©stamo a la fecha de retiro.
        fechaAux.add(Calendar.DATE, p_socio.getDiasPrestamo() );
        this.setFechaDevolucion(fechaAux);
        this.setSocio(p_socio);
        this.setLibro(p_libro);
    }
    
    /**
     * Método constructor. No recibe la fecha de retiro como parámetro. La fecha de retiro será la fecha actual.
     */
    public Prestamo(Socio p_socio, Libro p_libro) {
        this.setSocio(p_socio);
        this.setLibro(p_libro);
        Calendar fechaAux = Calendar.getInstance(); // Guardamos la fecha actual.
        this.setFechaRetiro(fechaAux); // Inicialiamos la fecha de retiro con la fecha actual.
        fechaAux.add(Calendar.DATE, p_socio.getDiasPrestamo() ); // Incrementamos la fecha en los dias de prÃ©stamo
        this.setFechaDevolucion(fechaAux);
        
    }
    
    /**
     * Determina si ya venció el plazo de devolución del libro.
     * @return True: ya venció el plazo / False en caso contrario
     */
    public boolean vencido(Calendar p_fecha) {
        return (p_fecha.after(this.getFechaDevolucion() ) );
    }
    
    /**
     * Devuelve una cadena con los datos del objeto.
     */
    public String toString() {
        String aux = "";
        
        String fechaRetiroAux = (this.getFechaRetiro().get(Calendar.YEAR) + "/" + this.getFechaRetiro().get(Calendar.MONTH)
                                                                          + "/" + this.getFechaRetiro().get(Calendar.DATE) );
                                                                          
        String fechaDevolucionAux = (this.getFechaDevolucion().get(Calendar.YEAR) + "/" + this.getFechaDevolucion().get(Calendar.MONTH)
                                                                          + "/" + this.getFechaDevolucion().get(Calendar.DATE) );
        aux = "Retiro: " + fechaRetiroAux + " - Devolucion: " + fechaDevolucionAux + "\nLibro: " + this.getLibro().getTitulo()
                                                                                   + "\nSocio: " + this.getSocio().getNombre();
        return aux;
    }
}
