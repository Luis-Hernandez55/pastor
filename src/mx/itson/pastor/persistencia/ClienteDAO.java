/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.pastor.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.pastor.entidades.Cliente;
import mx.itson.pastor.entidades.Cuenta;

/**
 *
 * @author lahg2
 */
public class ClienteDAO {

  public static List<Cliente> obtenerTodoso(){
      List<Cliente> clientes = new ArrayList<>();
      try{
          Connection connection = Conexion.obtener();
          Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery("SELECT id, nombre, direccion, telefono, email FROM cliente");
          while(resultSet.next()){
           Cliente c = new Cliente();
           c.setId(resultSet.getInt(1));
           c.setNombre(resultSet.getString(2));
           c.setDireccion(resultSet.getString(3));
           c.setTelefono(resultSet.getString(4));
           c.setEmail(resultSet.getString(5));
           clientes.add(c);
          }
      }catch(Exception ex){
          System.err.println("Ocurrio un error: " + ex.getMessage());
      }
      return clientes;
  }
  
  public static boolean guardar(String nombre, String direccion, String telefono, String email){
    boolean resultado =false;
    
      try {
          Connection connection = Conexion.obtener();
           String consulta = "INSERT INTO cliente (nombre, direccion, telefono, email) VALUES (?,?,?,?)";
           PreparedStatement statement = connection.prepareStatement(consulta);
           statement.setString (1, nombre);
           statement.setString (2, direccion);
           statement.setString (3, telefono);
           statement.setString (4, email);
           statement.execute();
           
           resultado = statement.getUpdateCount() == 1;
          
      } catch (Exception ex) {
          System.out.println("Ocurrió un error: " + ex.getMessage());
      }
      return resultado;
    
  }
  
  /*public static boolean login(Cliente cli){
      boolean existencia = false;
      try{
          Connection connection = Conexion.obtener();
          String consulta = "SELECT * FROM cliente WHERE nombre = ?";
          PreparedStatement statement = connection.prepareStatement(consulta);
          statement.setString(1, cli.getNombre());
          ResultSet resulSet = statement.executeQuery();
          
          existencia = resulSet.next();
      }catch(Exception ex){
          System.out.println("Ocurrió un erro: " + ex.getMessage());
      }
      return existencia;
  }*/
  
  public static boolean verificarExistencia(String email){
      boolean existencia = false;
      try{
          Connection connection = Conexion.obtener();
          String consulta = "SELECT * FROM cliente WHERE email = ?";
          PreparedStatement statement = connection.prepareStatement(consulta);
          statement.setString(1, email);
          ResultSet resulSet = statement.executeQuery();
          
          existencia = resulSet.next();
      }catch(Exception ex){
          System.out.println("Ocurrió un erro: " + ex.getMessage());
      }
      return existencia;
  }
  
  public static List<Cliente> obtenerTodosc() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Connection connection = Conexion.obtener();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT cu.id, cu.numero, cl.nombre, cl.direccion, cl.telefono, cl.email FROM cuenta cu INNER JOIN cliente cl ON cu.idCliente = cl.id");
            while (resultSet.next()) {
                Cliente c = new Cliente();
                c.setId(resultSet.getInt(1));
                c.setNombre(resultSet.getString(2));
                c.setDireccion(resultSet.getString(3));
                c.setTelefono(resultSet.getString(4));
                c.setEmail(resultSet.getString(5));
                c.setCuenta(resultSet.getString(6));
                clientes.add(c);
            }
        } catch (Exception ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return clientes;
    
}
  
}
