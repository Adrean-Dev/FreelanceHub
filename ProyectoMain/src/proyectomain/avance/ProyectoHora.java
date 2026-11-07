
package proyecto.avance;


public class ProyectoHora extends Proyecto {

    private double tarifaPorHora;
    private int horasTrabajadas;

    public ProyectoHora(String codigo, String titulo,
            String descripcion, double tarifaPorHora,
            int horasTrabajadas) {

        super(codigo, titulo, descripcion);
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularCostoTotal() {
        return tarifaPorHora * horasTrabajadas;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
}