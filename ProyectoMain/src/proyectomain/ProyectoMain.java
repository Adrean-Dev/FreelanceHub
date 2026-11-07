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

        // Datos precargados para demostración
        Proyecto proyectoDefault = new ProyectoPrecioFijo("P001", "Plataforma E-commerce", "Desarrollo de tienda online", 500.0);
        gestorProyectos.agregarProyecto(proyectoDefault);
        Tarea tareaDefault = new Tarea("T001", "Pasarela de pagos", "Integración API bancaria");
        gestorTareas.agregarTarea(proyectoDefault, tareaDefault);

        int opcionPrincipal;

        do {
            // Figura 1: Inicio de sesión / Ingreso al sistema
            System.out.println("\n==========================================");
            System.out.println("   FIGURA 1: INICIO DE SESIÓN / SISTEMA   ");
            System.out.println("==========================================");
            System.out.println("Seleccione el tipo de usuario (Registro):");
            System.out.println("1. Ingresar como CLIENTE (Figura 3)");
            System.out.println("2. Ingresar como FREELANCER (Figura 3)");
            System.out.println("3. Cierre de sesión / Salir (Figura 7)");
            System.out.print("Elija una opción: ");

            if (scanner.hasNextInt()) {
                opcionPrincipal = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("-> Error: Ingrese un número válido.");
                scanner.nextLine();
                opcionPrincipal = 0;
                continue;
            }

            switch (opcionPrincipal) {
                case 1:
                case 2:
                    // Figura 2: Menú Principal
                    menuPrincipalSistema(scanner, gestorProyectos, gestorTareas, motor);
                    break;
                case 3:
                    // Figura 7: Cierre de sesión
                    System.out.println("\n[Figura 7] Cierre de sesión exitoso. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("\n-> Opción no válida. Intente de nuevo.");
            }

        } while (opcionPrincipal != 3);

        scanner.close();
    }

    public static void menuPrincipalSistema(Scanner scanner, GestorProyectos gestorProyectos, GestorTareas gestorTareas, MotorDeFlujo motor) {
        int opcion;
        do {
            System.out.println("\n==========================================");
            System.out.println("       FIGURA 2: MENÚ PRINCIPAL           ");
            System.out.println("==========================================");
            System.out.println("1. Gestión de proyectos (Figura 4)");
            System.out.println("2. Gestión de tareas (Figura 5)");
            System.out.println("3. Actualización de estados y Motor de Flujo (Figura 6)");
            System.out.println("4. Cerrar sesión (Regresar al Inicio)");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("-> Opción inválida.");
                scanner.nextLine();
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    // Figura 4: Gestión de proyectos
                    System.out.println("\n--- [FIGURA 4] GESTIÓN DE PROYECTOS ---");
                    System.out.println("Proyectos actuales en el sistema:");
                    gestorProyectos.listarProyectos();
                    break;
                case 2:
                    // Figura 5: Gestión de tareas
                    System.out.println("\n--- [FIGURA 5] GESTIÓN DE TAREAS ---");
                    System.out.print("Ingrese el código del proyecto (ej. P001): ");
                    String codProj = scanner.nextLine();
                    Proyecto p = gestorProyectos.buscarProyecto(codProj);
                    if (p != null) {
                        System.out.println("\nTareas del proyecto " + p.getTitulo() + ":");
                        gestorTareas.listarTareas(p);
                    } else {
                        System.out.println("-> Proyecto no encontrado.");
                    }
                    break;
                case 3:
                    // Figura 6: Actualización de estados
                    System.out.println("\n--- [FIGURA 6] ACTUALIZACIÓN DE ESTADOS ---");
                    System.out.print("Ingrese el código del proyecto: ");
                    String cp = scanner.nextLine();
                    Proyecto proj = gestorProyectos.buscarProyecto(cp);
                    if (proj != null) {
                        System.out.print("Ingrese el código de la tarea a evaluar (ej. T001): ");
                        String ct = scanner.nextLine();
                        Tarea t = gestorTareas.buscarTarea(proj, ct);
                        if (t != null) {
                            System.out.println("\n[Estado actual antes de actualizar]");
                            motor.evaluarAvanceTarea(t);
                            
                            System.out.println("\nSeleccione el nuevo estado:");
                            System.out.println("1. PENDIENTE");
                            System.out.println("2. EN_PROGRESO");
                            System.out.println("3. COMPLETADA");
                            System.out.print("Elija opción: ");
                            int est = scanner.nextInt();
                            scanner.nextLine();
                            
                            if (est == 1) gestorTareas.cambiarEstado(t, EstadoTarea.PENDIENTE);
                            else if (est == 2) gestorTareas.cambiarEstado(t, EstadoTarea.EN_PROGRESO);
                            else if (est == 3) gestorTareas.cambiarEstado(t, EstadoTarea.COMPLETADA);
                            
                            System.out.println("\n[Estado actualizado verificado por el Motor de Flujo]");
                            motor.evaluarAvanceTarea(t);
                        } else {
                            System.out.println("-> Tarea no encontrada.");
                        }
                    } else {
                        System.out.println("-> Proyecto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("\nCerrando sesión de usuario...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
}
