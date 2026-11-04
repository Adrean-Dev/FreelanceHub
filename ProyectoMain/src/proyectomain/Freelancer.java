package proyectomain;

import java.util.ArrayList;
import java.util.Arrays;

public class Freelancer extends Usuario {
    private ArrayList<String> habilidades;
    
    public Freelancer(String id, String nombre, String correo, String[] habilidades) {
        super(id, nombre, correo);
        this.habilidades = new ArrayList<>(Arrays.asList(habilidades));
    }
    
    public int addHabilidad(String habilidad) {
        habilidades.add(habilidad);
        return habilidades.size()-1;
    }
    
    public String removeHabilidad(int indice) {
        return habilidades.remove(indice);
    }
    
    public String getHabilidad(int indice) {
        return habilidades.get(indice);
    }
    
    public Object[] getHabilidades() {
        return habilidades.toArray();
    }

    @Override
    public void mostrarDashboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
