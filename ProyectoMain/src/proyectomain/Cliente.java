package proyectomain;

public class Cliente extends Usuario {
    private String empresa;

    public Cliente(String id, String nombre, String correo, String empresa) {
        super(id, nombre, correo);
        this.empresa = empresa;
    }
    
    @Override
    public void mostrarDashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
