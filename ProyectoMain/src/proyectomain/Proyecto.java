
package proyecto.avance;
import java.util.ArrayList;

public abstract class Proyecto implements ICalculoCosto {

    private String codigo;
    private String titulo;
    private String descripcion;
    private EstadoTarea estado;
    private ArrayList<Tarea> tareas;

    public Proyecto(String codigo, String titulo, String descripcion) {

        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = EstadoTarea.PENDIENTE;
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

       public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }
    

    public abstract double calcularCostoTotal();
}