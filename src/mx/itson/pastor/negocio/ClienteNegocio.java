package mx.itson.pastor.negocio;

import mx.itson.pastor.persistencia.ClienteDAO;


public class ClienteNegocio {
    
    public static boolean guardar(String nombre, String direccion, String telefono, String email){
        boolean resultado = false;
        try {
            resultado = ClienteDAO.guardar(nombre, direccion, telefono, email);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    
}
