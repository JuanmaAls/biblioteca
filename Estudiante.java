import java.util.*;
public class Estudiante extends Socio{
    private String carrera;
    
    
    
    /**
     * Metodo constructor que no recibe el parametro p_diasPrestamos para la super clase.
     */
    public Estudiante(int p_dniSocio, String p_nombre, String p_carrera){
        super(p_dniSocio,p_nombre, 20);
        this.setCarrera(p_carrera);
    }
    
    /**
     * Mutador del atributo carrera
     */
    private void setCarrera(String p_carrera){
        this.carrera=p_carrera;
    }
    /**
     * Obersavor del atributo carrera
     */
    public String getCarrera(){
        return this.carrera;
    }
    /**
     * Metodo que retorna el nombre de la subclase situada
     */
    public String soyDeLaClase(){
        return "Estudiante";
    }
    /**
     * Verifica si puede retirar un libro o no
     */
    public boolean puedePedir(){
        boolean resp=true;
        if(this.cantLibrosPrestados()>3){
            resp=false;
        }
        
        Calendar fecha=Calendar.getInstance();
        
        Calendar fecha2;
        int cantidad=this.getPrestamos().size();
        for(int i=0;i<cantidad;i++){
            fecha2=((Prestamo)this.getPrestamos().get(i)).getFechaRetiro();
            fecha2.add(Calendar.DATE, 20);
            if(fecha2.before(fecha)){
                resp=false;
            }
        }
        
        return resp;
    }
}