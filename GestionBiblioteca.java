import java.util.*;


/**
 * Clase ejecutable de prueba.
 * 
 * @author 
 * @version 1.0
 */
public class GestionBiblioteca
{
    public static void main(String[] args) {
        //Instanciación de la Biblioteca
        Biblioteca biblioteca = new Biblioteca("El gran plagio S.A.");
        
        biblioteca.nuevoLibro("Como copiar el Tanembaum", 4, "Didactica dinamica", 1955);
        biblioteca.nuevoLibro("Como multiplicar en ASSEMBLER", 5, "Puerto de palos", 2002);
        biblioteca.nuevoLibro("Como hacer una clase ejecutable de java", 1, "Carlos Romero", 2008);
        biblioteca.nuevoLibro("15 minutos de clases", 2, "Anita", 2014);
        biblioteca.nuevoLibro("Clases con animaciones", 5, "Kapelusz", 2012);
        biblioteca.nuevoLibro("Programando con JAVA", 1, "Suarez", 2008);
        biblioteca.nuevoSocioEstudiante(1111, "Juan Perez", "Licenciatura en Sistemas");
        biblioteca.nuevoSocioDocente(2222, "Esteban Alvarez", "Informatica");
        biblioteca.nuevoSocioDocente(3333, "Carlos Martinez", "Matematica");
        biblioteca.prestarLibro(new GregorianCalendar(1989, 12, 25), biblioteca.buscarSocio(1111), biblioteca.getLibros().get(0) );
        biblioteca.prestarLibro(new GregorianCalendar(2010, 5, 6), biblioteca.buscarSocio(1111), biblioteca.getLibros().get(1) );
        biblioteca.prestarLibro(new GregorianCalendar(2012, 6, 12), biblioteca.buscarSocio(2222), biblioteca.getLibros().get(2) );
        biblioteca.prestarLibro(new GregorianCalendar(2013, 8, 22), biblioteca.buscarSocio(2222), biblioteca.getLibros().get(5) );
        //Prestamo prestamo5 = new Prestamo(new GregorianCalendar(2014, 9, 10), biblioteca.buscarSocio(3333), biblioteca.getLibros().get(4) );
        //Prestamo prestamo6 = new Prestamo(new GregorianCalendar(2013, 10, 2), biblioteca.buscarSocio(3333), biblioteca.getLibros().get(5) );
        Libro libroPrestado = biblioteca.getLibros().get(0);
        System.out.println(biblioteca.listaDeSocios() );
        
        System.out.println(biblioteca.listaDeDocentesResponsables());
        
        System.out.println(biblioteca.listaDeLibros());
        
        System.out.println("Se averiguara que socio dispone del libro 'Programando con JAVA' ");
        System.out.println("Fue: "+biblioteca.quienTieneElLibro(libroPrestado));
        
    }
}
