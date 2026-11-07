
package proyecto.avance;

public class GestorTareas {

   
    public void agregarTarea(Proyecto proyecto, Tarea tarea) {
        proyecto.agregarTarea(tarea);
    }

    
    public void listarTareas(Proyecto proyecto) {
        for (Tarea t : proyecto.getTareas()) {
            System.out.println("Codigo: " + t.getCodigo());
            System.out.println("Titulo: " + t.getTitulo());
            System.out.println("Descripcion: " + t.getDescripcion());
            System.out.println("Estado: " + t.getEstado());
            System.out.println();
        }
    }

    
    public Tarea buscarTarea(Proyecto proyecto, String codigo) {
        for (Tarea t : proyecto.getTareas()) {
            if (t.getCodigo().equals(codigo)) {
                return t;
            }
        }
        return null;
    }

        public void actualizarTarea(Tarea tarea, String nuevoTitulo) {
        tarea.setTitulo(nuevoTitulo);
    }

    
    public void cambiarEstado(Tarea tarea, EstadoTarea estado) {
        tarea.setEstado(estado);
    }

    
    public void eliminarTarea(Proyecto proyecto, Tarea tarea) {
        proyecto.getTareas().remove(tarea);
    }
}
