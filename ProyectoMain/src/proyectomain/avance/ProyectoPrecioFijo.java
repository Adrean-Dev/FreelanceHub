
package proyecto.avance;


    public class ProyectoPrecioFijo extends Proyecto {

    private double precioFijo;

    public ProyectoPrecioFijo(String codigo, String titulo, String descripcion, double precioFijo) {
        super(codigo, titulo, descripcion);
        this.precioFijo = precioFijo;
    }

    @Override
    public double calcularCostoTotal() {
        return precioFijo;
    }

    public double getPrecioFijo() {
        return precioFijo;
    }

    public void setPrecioFijo(double precioFijo) {
        this.precioFijo = precioFijo;
    }
    
}
    

