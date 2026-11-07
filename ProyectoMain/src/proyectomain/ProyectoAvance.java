
package proyecto.avance;

public class ProyectoAvance {

    
    public static void main(String[] args) {
    
        GestorProyectos gestorProyectos = new GestorProyectos();
        GestorTareas gestorTareas = new GestorTareas();

    
        Proyecto proyecto1 = new ProyectoPrecioFijo(
                "P001", "Pagina web", "Desarrollo de una pagina web", 500
        );

        Proyecto proyecto2 = new ProyectoHora(
                "P002", "Aplicacion movil", "Desarrollo de una app", 20, 15
        );

        
        gestorProyectos.agregarProyecto(proyecto1);
        gestorProyectos.agregarProyecto(proyecto2);

      
        Tarea tarea1 = new Tarea(
                "T001", "Diseñar interfaz", "Crear el diseño de la pagina"
        );

        Tarea tarea2 = new Tarea(
                "T002", "Programar inicio", "Desarrollar pantalla principal"
        );

        Tarea tarea3 = new Tarea(
                "T003", "Realizar pruebas", "Comprobar funcionamiento"
        );

        // Agregar tareas al proyecto
        gestorTareas.agregarTarea(proyecto1, tarea1);
        gestorTareas.agregarTarea(proyecto1, tarea2);
        gestorTareas.agregarTarea(proyecto2, tarea3);

        // Listar proyectos
        System.out.println("LISTA DE PROYECTOS");
        gestorProyectos.listarProyectos();

        
        System.out.println(" TAREAS DEL PROYECTO ");
        gestorTareas.listarTareas(proyecto1);

       
        System.out.println(" BUSCAR TAREA");
        Tarea encontrada = gestorTareas.buscarTarea(proyecto1, "T001");

        if (encontrada != null) {
            System.out.println("Tarea encontrada: " + encontrada.getTitulo());
        } else {
            System.out.println("Tarea no encontrada");
        }    
    }
}        

     
    

