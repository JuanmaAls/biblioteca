import java.util.*;

public class Docente extends Socio{
    
    private String area;
    
    public Docente(int p_dniSocio, String p_nombre, String p_area) {
        super(p_dniSocio,p_nombre, 5);
        this.setArea(p_area);
    }

    
    private void setArea(String p_area){
        this.area=p_area;
    }
    
    public String getArea(){
        return this.area;
    }
    
    public String soyDeLaClase(){
        return "Docente";
    }
    
    public void agregarDiasDePrestamo(int p_diasPrestamo){
        this.setDiasPrestamo(p_diasPrestamo+this.getDiasPrestamo());
    }
    
    public boolean esResponsable(){
                
        boolean resp=true;
        
        Calendar fecha=Calendar.getInstance();
        
        Calendar fecha2;
        int cantidad=this.getPrestamos().size();
        for(int i=0;i<cantidad;i++){
            fecha2=((Prestamo)this.getPrestamos().get(i)).getFechaRetiro();
            fecha2.add(Calendar.DATE, this.getDiasPrestamo());
            if(fecha2.before(fecha)){
                resp=false;
            }
        }
        
        return resp;
        
    }
}