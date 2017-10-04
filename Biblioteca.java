import java.util.*;

/**
 * @autor(Acosta Juan, Acosta Vanni Sebastian, Artista Piragine Jonathan)
 * @version 1
 */

public class Biblioteca {
    private String nombre;
    private ArrayList <Socio> socios;
    private ArrayList <Libro> libros;
    
    public Biblioteca(String p_nombre) 
    {
        this.setNombre(p_nombre);
        this.setSocios(new ArrayList <Socio> ());
        this.setLibros(new ArrayList <Libro> ());
    }
    
    private void setNombre(String p_nombre) 
    {
        this.nombre = p_nombre;
    }
    
    private void setSocios(ArrayList <Socio> p_socios) 
    {
        this.socios = p_socios;
    }
    
    private void setLibros(ArrayList <Libro> p_libros) 
    {
        this.libros = p_libros;
    }
    
    public String getNombre() 
    {
        return this.nombre;
    }
    
    public ArrayList <Socio> getSocios() 
    {
        return this.socios;
    }
    
    public ArrayList <Libro> getLibros() 
    {
        return this.libros;
    }
    
    public void addSocio(Socio p_socio) 
    {
        this.getSocios().add(p_socio);
    }
    
    public void removeSocio(Socio p_socio) 
    {
        this.getSocios().remove(p_socio);
    }
    
    private void addLibro(Libro p_libro) 
    {
        this.getLibros().add(p_libro);
    }
    
    public void removeLibro(Libro p_libro) 
    {
        this.getLibros().remove(p_libro);
    }
    
    //crea un objeto de tipo Libro y lo agrega a la coleccion de libros.
    public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial, int p_anio) 
    {
        Libro libro1 = new Libro(p_titulo, p_edicion, p_editorial, p_anio);
        this.addLibro(libro1);
        
    }
    
    //crea un objeto del tipo Estudiante y lo agrega a la coleccion de socios.
    public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre, String p_carrera) 
    {
        Estudiante estudiante = new Estudiante(p_dniSocio, p_nombre, p_carrera);
        this.addSocio(estudiante);
    }
    
    //crea un objeto del tipo Docente y lo agrega a la coleccion de socios.
    public void nuevoSocioDocente(int p_dniSocio, String p_nombre, String p_area) 
    {
        Docente docente = new Docente(p_dniSocio, p_nombre, p_area);
        this.addSocio(docente);
    
    }
    
    //cantidad de socios según su tipo (estudiante o docente)
    public int cantidadSociosPorTipo(String p_objeto) 
    {
        int cant = 0;
        for(Socio s : this.getSocios()) {
            if (s.soyDeLaClase() == p_objeto) {
                cant = cant + 1;
            }
        }
        return cant;
    }
    
    //pretar un libro
    public boolean prestarLibro(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro) 
    {
        int aux = 0; //variable auxiliar que vamos a usar para guardar la posicion del libro buscado dentro de la colección
        boolean ejemplarDisponible = false;
        
        //recorre la coleccion de libros
        for (int i = 0; i < this.getLibros().size(); i ++) 
        {
            //este "if" pregunta si el libro en la posición "i" actual tiene el mismo título que el libro pasado por parametro 
            //y si el libro está disponible o no usando el método "pestado()"
            if (this.getLibros().get(i).getTitulo() == p_libro.getTitulo() &&  this.getLibros().get(i).prestado() == false ) 
            {
                aux = i; //guarda la posición del libro buscado dentro de la colección para utilizarlo mas adelante
                ejemplarDisponible = true; //como el libro está disponible, guardamos este valor dentro de esta variable para usarlo después
            }
        }
        
        //acá preguntamos si el socio que pasaron por parámetro puede pedir un libro y si el libro encontrado está disponible o no
        //se deben cumplir las dos condiciones para poder efectuar el préstamo.
        if(this.buscarSocio(p_socio.getDniSocio()).puedePedir()  &&  ejemplarDisponible)  
        {
            //creamos un objeto del tipo Prestamo
            Prestamo prestamo = new Prestamo(p_fechaRetiro, this.buscarSocio(p_socio.getDniSocio()), this.getLibros().get(aux));
            
            //modifica el estado del objeto de tipo Libro agregando un prestamo.
            this.getLibros().get(aux).addPrestamo(prestamo);
            //modifica el estado del objeto de tipo Socio agregando un prestamo.
            this.buscarSocio(p_socio.getDniSocio()).addPrestamo(prestamo);
            
            //si el prestamo se realizó con exito, retorna true
            return true;
        }
        else 
        {
            //si llegamos hasta aca es porque el prestamo no se realizo con exito
            return false;
        }
    }
    
    //modifica estado del objeto Libro pasado por parámetro
    public void devolverLibro(Libro p_libro) 
    {
        p_libro.getPrestamo().setFechaDevolucion(new GregorianCalendar());
    }
    
    //
    public ArrayList <Prestamo> prestamosVencidos() 
    {
        ArrayList <Prestamo> prestamosVencidos = new ArrayList <Prestamo> ();
        
        //recorre la colección de libros
        for (Libro l : this.getLibros()) 
        {
            //pregunta si el libro esta prestado y si el último prestamo de dicho libro está vencido
            if (l.prestado() && l.getPrestamo().vencido(new GregorianCalendar())) 
            {
                //agrega el prestamo a la coleccion de prestamos vencidos.
                prestamosVencidos.add(l.getPrestamo());
            }
        }
        //devuelve la coleccion de prestamos vencidos
        return prestamosVencidos;
    }
    
    //devuelve una coleccion de objetos de tipo Docente que sean "responsables"
    public ArrayList <Docente> docentesResponsables() 
    {
        //creamos un arraylist de objetos del tipo Docente
        ArrayList <Docente> docentesResponsables = new ArrayList <Docente> ();
        
        //recorremos la coleccion de socios
        for (Socio s: this.getSocios()) 
        {
            //preguntamos si el socio es de la clase Docente
            if(s.soyDeLaClase() == "Docente")
            {
                //pregunta si el docente es responsable
                if (((Docente)s).esResponsable())
                {
                    //se agrega el docente responsable a la coleccion creada al comienzo del metodo
                    docentesResponsables.add((Docente)s);
                }
            }
        }
        //retorna la coleccion de docentes responsables
        return docentesResponsables;
    }
    
    //devuelve el nombre del socio que posee el libro con el titulo ingresado como parametro
    public String quienTieneElLibro(Libro p_libro) 
    {
        if (p_libro.prestado()){
            return p_libro.getPrestamo().getSocio().getNombre();
        }
        else return "El libro no fue prestado";
    }
    
    //devuelve el socio con el dni ingresado como parametro
    public Socio buscarSocio(int p_dni) 
    {
        for (Socio s : this.getSocios()) 
        {
            //busca el socio con el dni ingresado
            if (s.getDniSocio() == p_dni) 
            {
                return s;
            }
        }
        return null; 
    }
    
    //
    public String listaDeSocios()
    {
        
        //crea la variable "lista" de tipo String para ir concatenando 
        String lista = "\tLista de Socios: \n";
        lista += "\n";
        //recorre la coleccion de socios 
        for (int i = 0; i < this.getSocios().size(); i++) 
        {
            //vamos concatenando la lista usando el metodo toString de la clase Socio
            lista += (i + 1) + ") " + this.getSocios().get(i).toString() + "\n";
        }
        
        lista += "\n";
        lista += "********************************************************************** \n";
        lista += "Cant. Socios tipo Estudiante: " + this.cantidadSociosPorTipo("Estudiante") + "\n";
        lista += "Cant. Socios tipo Docente: " + this.cantidadSociosPorTipo("Docente") + "\n";
        lista += "**********************************************************************";
        return lista;
        
    }
    
    //devuelve una lista de los libros que contiene la coleccion y aclara si esta prestado o no.
    public String listaDeLibros() 
    {
        String lista = "\tLista de Libros: \n";
        lista += "\n";
        String aux;
        for (int i = 0; i < this.getLibros().size(); i++) 
        {
            
            if (this.getLibros().get(i).prestado()) {
                aux = "SI";
            }
            else {
                aux ="NO";
            }
            
            lista += (i + 1) + ") " + this.getLibros().get(i).toString() + " || Prestado: ("+aux+") " + "\n";
            
        }
        
        return lista;
    }
    
    //devuelve un String con la lista de docentes responsables.
    public String listaDeDocentesResponsables() 
    {
        String lista = "\tLista de Docentes Responsables \n";
        
        for (Docente d : this.docentesResponsables()) 
        {
            lista += "* " + d.toString() + "\n";
        }
        
        return lista;
    }
}
