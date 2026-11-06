package proyecto.avance;

import java.util.ArrayList;

public class GestorProyectos {

    private ArrayList<Proyecto> proyectos;

    public GestorProyectos() {
        proyectos = new ArrayList<>();
    }

    // REGISTRAR PROYECTO
    public void agregarProyecto(Proyecto proyecto) {
        proyectos.add(proyecto);
    }

    public void listarProyectos() {
        for (Proyecto p : proyectos) {
            System.out.println("Codigo: " + p.getCodigo());
            System.out.println("Titulo: " + p.getTitulo());
            System.out.println("Descripcion: " + p.getDescripcion());
            System.out.println("Costo: " + p.calcularCostoTotal());
            System.out.println();
        }
    }

  
    public Proyecto buscarProyecto(String codigo) {
        for (Proyecto p : proyectos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    // ACTUALIZAR PROYECTO
    public void actualizarProyecto(String codigo, String nuevoTitulo) {
        Proyecto p = buscarProyecto(codigo);

        if (p != null) {
            p.setTitulo(nuevoTitulo);
        }
    }

    public void eliminarProyecto(String codigo) {
        Proyecto p = buscarProyecto(codigo);

        if (p != null) {
            proyectos.remove(p);
        }
    }
}