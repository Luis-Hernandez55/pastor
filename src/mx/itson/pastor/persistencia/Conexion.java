/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.pastor.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
 * 
 *
 * @author lahg2
 */
public class Conexion {
    
    public ResultSet resultado;
    public Statement sentencia;
   
    public static Connection obtener(){
       Connection conexion = null;
       try{
          conexion = DriverManager.getConnection("jdbc:mysql://localhost/pastordb?user=root&password=");
       }catch(Exception e){
           System.err.print(e.getMessage());
       }
       return conexion;
    }
    
    
}














