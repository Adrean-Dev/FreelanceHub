
public class pruebaproyecto {

    public static void main(String[] args) {

    
        GestorProyectos gestorProyectos = new GestorProyectos();
        GestorTareas gestorTareas = new GestorTareas();

        // Crear proyectos
        Proyecto proyecto1 = new ProyectoPrecioFijo(
                "P001", "Pagina web", "Desarrollo de una pagina web", 500
        );

        Proyecto proyecto2 = new ProyectoPorHoras(
                "P002", "Aplicacion movil", "Desarrollo de una app", 20, 15
        );

        // Agregar proyectos
        gestorProyectos.agregarProyecto(proyecto1);
        gestorProyectos.agregarProyecto(proyecto2);

        // Crear tareas
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
        System.out.println("===== LISTA DE PROYECTOS =====");
        gestorProyectos.listarProyectos();

        // Listar tareas
        System.out.println("\n===== TAREAS DEL PROYECTO P001 =====");
        gestorTareas.listarTareas(proyecto1);

        // Buscar tarea
        System.out.println("\n===== BUSCAR TAREA =====");
        Tarea encontrada = gestorTareas.buscarTarea(proyecto1, "T001");

        if (encontrada != null) {
            System.out.println("Tarea encontrada: " + encontrada.getTitulo());
        } else {
            System.out.println("Tarea no encontrada");
        }

        // Actualizar tarea
        System.out.println("\n===== ACTUALIZAR TAREA =====");
        gestorTareas.actualizarTarea(tarea1, "Diseñar nueva interfaz");
        System.out.println("Nuevo titulo: " + tarea1.getTitulo());

        // Cambiar estado
        System.out.println("\n===== CAMBIAR ESTADO =====");
        gestorTareas.cambiarEstado(tarea1, EstadoTarea.EN_PROGRESO);
        System.out.println("Nuevo estado: " + tarea1.getEstado());

        // Eliminar tarea
        System.out.println("\n===== ELIMINAR TAREA =====");
        gestorTareas.eliminarTarea(proyecto1, tarea2);
        gestorTareas.listarTareas(proyecto1);

        // Eliminar proyecto
        System.out.println("\n===== ELIMINAR PROYECTO =====");
        gestorProyectos.eliminarProyecto("P002");
        gestorProyectos.listarProyectos();
    }
}
