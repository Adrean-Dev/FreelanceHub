package proyecto.avance;

import java.util.Scanner;

/**
 * @author Danna Freire
 * @author Jean Piere Baca
 * @author Matias Cassola
 */
public class ProyectoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorProyectos gestorProyectos = new GestorProyectos();
        GestorTareas gestorTareas = new GestorTareas();
        MotorDeFlujo motor = new MotorDeFlujo();

        Proyecto proyecto1 = new ProyectoPrecioFijo("P001", "Plataforma E-commerce", "Desarrollo de tienda online", 500.0);
        gestorProyectos.agregarProyecto(proyecto1);

        Tarea tarea1 = new Tarea("T001", "Desarrollar pasarela de pagos", "Integración con API bancaria");
        gestorTareas.agregarTarea(proyecto1, tarea1);

        int opcionPrincipal;

        do {
            System.out.println("\n==========================================");
            System.out.println("   SISTEMA FREELANCE WORKFLOW ENGINE      ");
            System.out.println("==========================================");
            System.out.println("Seleccione su rol en el sistema:");
            System.out.println("1. Ingresar como CLIENTE");
            System.out.println("2. Ingresar como FREELANCER");
            System.out.println("3. Salir del Sistema");
            System.out.print("Elija una opcion: ");

            if (scanner.hasNextInt()) {
                opcionPrincipal = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("-> Error: Ingrese un numero valido.");
                scanner.nextLine();
                opcionPrincipal = 0;
                continue;
            }

            switch (opcionPrincipal) {
                case 1:
                    menuCliente(scanner, proyecto1);
                    break;
                case 2:
                    menuFreelancer(scanner, proyecto1, gestorTareas, motor);
                    break;
                case 3:
                    System.out.println("\nSaliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("\n-> Opcion no valida. Intente de nuevo.");
            }

        } while (opcionPrincipal != 3);

        scanner.close();
    }

    public static void menuCliente(Scanner scanner, Proyecto proyecto) {
        int opcion;
        do {
            System.out.println("\n--- MENU CLIENTE ---");
            System.out.println("1. Consultar Estado y Costo del Proyecto");
            System.out.println("2. Regresar al Menu Principal");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("-> Opcion invalida.");
                scanner.nextLine();
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n[Informacion del Proyecto]");
                    System.out.println("Codigo: " + proyecto.getCodigo());
                    System.out.println("Titulo: " + proyecto.getTitulo());
                    System.out.println("Descripcion: " + proyecto.getDescripcion());
                    System.out.println("Costo Total: $" + proyecto.calcularCostoTotal());
                    System.out.println("\n--- Tareas Asociadas ---");
                    for (Tarea t : proyecto.getTareas()) {
                        System.out.println("- " + t.getTitulo() + " | Estado: " + t.getEstado());
                    }
                    break;
                case 2:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 2);
    }

    public static void menuFreelancer(Scanner scanner, Proyecto proyecto, GestorTareas gestorTareas, MotorDeFlujo motor) {
        int opcion;
        do {
            System.out.println("\n--- MENU FREELANCER ---");
            System.out.println("1. Listar y Evaluar Tareas (Motor de Flujo)");
            System.out.println("2. Cambiar Estado de una Tarea");
            System.out.println("3. Regresar al Menu Principal");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("-> Opcion invalida.");
                scanner.nextLine();
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n[Evaluando Tareas con el Motor de Flujo]");
                    for (Tarea t : proyecto.getTareas()) {
                        motor.evaluarAvanceTarea(t);
                    }
                    break;
                case 2:
                    gestorTareas.listarTareas(proyecto);
                    System.out.print("Ingrese el codigo de la tarea a actualizar (ej. T001): ");
                    String codT = scanner.nextLine();
                    Tarea tareaEncontrada = gestorTareas.buscarTarea(proyecto, codT);
                    if (tareaEncontrada != null) {
                        System.out.println("Seleccione el nuevo estado:");
                        System.out.println("1. PENDIENTE");
                        System.out.println("2. EN_PROGRESO");
                        System.out.println("3. COMPLETADA");
                        System.out.print("Elija una opcion: ");
                        if (scanner.hasNextInt()) {
                            int est = scanner.nextInt();
                            scanner.nextLine();
                            if (est == 1) {
                                gestorTareas.cambiarEstado(tareaEncontrada, EstadoTarea.PENDIENTE);
                            } else if (est == 2) {
                                gestorTareas.cambiarEstado(tareaEncontrada, EstadoTarea.EN_PROGRESO);
                            } else if (est == 3) {
                                gestorTareas.cambiarEstado(tareaEncontrada, EstadoTarea.COMPLETADA);
                            }
                            System.out.println("-> ¡Estado actualizado con éxito!");
                        } else {
                            scanner.nextLine();
                        }
                    } else {
                        System.out.println("-> Tarea no encontrada.");
                    }
                    break;
                case 3:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 3);
    }
}
