package mx.itson.pastor.negocio;

import mx.itson.pastor.persistencia.ClienteDAO;


public class ClienteNegocio {
    
    public static boolean guardar(String nombre, String direccion, String telefono, String email){
        boolean resultado = false;
        try {
            if(!ClienteDAO.verificarExistencia(email)){
                resultado = ClienteDAO.guardar(nombre, direccion, telefono, email);
            }
            //resultado = ClienteDAO.guardar(nombre, direccion, telefono, email);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }
    
}
